package com.qiniu;

import com.google.gson.Gson;
import com.model.VideoAdInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiniu.
 */
public class VideoAdManage {

    private static HttpClient httpClient;

    public VideoAdManage() {
        httpClient = HttpClient.getHttpClient();
    }

    /**
     * POST /v1/hubs/<Hub>/ad/videos
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     */
    public String createVideoAdConf(VideoAdInfo videoAdInfo, String hub) {
        Gson gson = new Gson();
        String bodyStr = gson.toJson(videoAdInfo);

        System.out.println(bodyStr);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/videos";
        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);
    }

    /**
     * PUT /v1/hubs/<Hub>/ad/videos/<AdId>
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     *
     * @return
     */
    public boolean updateVideoAdConf(VideoAdInfo videoAdInfo, String hub, String adId) {
        Gson gson = new Gson();
        String bodyStr = gson.toJson(videoAdInfo);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/videos/" + adId;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        return false;

    }

    /**
     * GET /v1/hubs/<Hub>/ad/videos/<AdId>
     * Authorization: <QiniuToken>
     *
     * @return
     */
    public String getVideoAdConf(String hub, String adId) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/videos/" + adId;
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);

        return new Gson().toJson(ret);
    }

    /**
     * GET /v1/hubs/<Hub>/ad/videos?cursor=<Cursor>&count=<Count>&position=<Postion>&enabled=<Enabled>
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     *
     * @return
     */
    public String getVideoAdConfList(String hub, Integer count, String cursor, String position, int enabled) {
        if (count == null) {
            count = 100;
        }

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/videos?count="
                + count + "&position=" + position + "&enabled=" + enabled;
        if (cursor != null && cursor.length() > 0) {
            rawUrl += "&cursor=" + cursor;
        }

        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, true);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, true, auth);
        return new Gson().toJson(ret);
    }


    /**
     * DELETE /v1/hubs/<Hub>/ad/videos/<AdId>
     * Authorization: <QiniuToken>
     *
     * @return
     */
    public boolean deleteVideoAdConf(String hub, String adId) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/videos/" + adId;
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        return false;

    }

    /**
     * DELETE /v1/hubs/<Hub>/ad/videos
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     *
     * @return
     */
    public String deleteVideoAdConfList(String hub, String[] ids) {

        Map<String, Object> idMap = new HashMap<String, Object>();
        idMap.put("ids", ids);

        Gson gson = new Gson();
        String bodyStr = gson.toJson(idMap);


        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/videos";
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);
    }

    /**
     * PUT /v1/hubs/<Hub>/ad/videos/<AdId>/enabled/<Enabled>
     * Authorization: <QiniuToken>
     *
     * @return
     */
    public boolean enableVideoAdConf(String hub, String adId, int enabled) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub
                + "/ad/videos/" + adId + "/enabled/" + enabled;

        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        return false;

    }

}












