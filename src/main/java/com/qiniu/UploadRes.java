package com.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiniu.
 */
public class UploadRes {

    private static HttpClient httpClient;

    public UploadRes() {
        httpClient = HttpClient.getHttpClient();
    }


    private String getVodUptoken(String hub, int deadline, String type) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("hub", hub);
        map.put("type", "video");
        map.put("deadline", 6 * 3600);

        if (deadline >= 0) {
            map.put("deadline", deadline);
        }


        if (type != null && type.length() > 0) {
            map.put("type", type);
        }

        String bodyStr = gson.toJson(map);

        String rawUrl = Const.HOST + "/v1/uptokens";

        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        Pattern pt = Pattern.compile("\"uptoken\":\"(.+?)\"}");
        Matcher matcher = pt.matcher(ret.get("msg").toString());

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    /**
     * POST /v1/uptokens
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     *
     * @return
     */
    public boolean uploadResource(String hub, int deadline, String type, String key, String path) {
        String uptoken = getVodUptoken(hub, deadline, type);

        //创建上传对象
        UploadManager uploadManager = new UploadManager();

        try {
            //调用put方法上传
            Response res = uploadManager.put(path, key, uptoken);
            //打印返回的信息
            System.out.println(res.bodyString());
            return true;
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }

        return false;
    }
}
