package com.qiniu;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.ImageAdArgs;
import com.model.ImageArgs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiniu
 */
public class ImageAdManage {

    private static HttpClient httpClient;

    public ImageAdManage() {
        httpClient = HttpClient.getHttpClient();

    }

    /***
     * POST /v1/hubs/<Hub>/ad/images
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     * @param hub
     * @param args
     * @return
     */
    public String createImageAd(String hub, ImageAdArgs args) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        String bodyStr = gson.toJson(args);
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/images";

        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);

    }

    /***
     * PUT /v1/hubs/<Hub>/ad/images/<AdId>
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     * @param hub
     * @param adId
     * @param args
     * @return
     */
    public boolean updateImageAd(String hub, String adId, ImageAdArgs args) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        String bodyStr = gson.toJson(args);
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/images/" + adId;

        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;

    }

    /***
     * GET /v1/hubs/<Hub>/ad/images/<AdId>
     * Authorization: <QiniuToken>
     * @param hub
     * @param adId
     * @return
     */
    public String getImageAdInfo(String hub,String adId){
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/images/"+adId;
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }

    /***
     * GET /v1/hubs/<Hub>/ad/images
     * Authorization: <QiniuToken>
     * @param hub
     * @return
     */
    public String getImageAdInfoList(String hub){
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/images";
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }

    /***
     * DELETE /v1/hubs/<Hub>/ad/images/<AdId>
     * Authorization: <QiniuToken>
     * @param hub
     * @param adId
     * @return
     */
    public boolean deleteImageAd(String hub,String adId){
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/images/" + adId;
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /***
     * DELETE /v1/hubs/<Hub>/ad/images
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     * @param hub
     * @param adIds
     * @return
     */
    public String deleteImageAdList(String hub,String[] adIds){
        Map<String, Object> idMap = new HashMap<String, Object>();
        idMap.put("ids", adIds);

        Gson gson = new Gson();
        String bodyStr = gson.toJson(idMap);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/ad/images";
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);
    }

    /***
     * PUT /v1/hubs/<Hub>/ad/images/<AdId>/enabled/<Enabled>
     * Authorization: <QiniuToken>
     * @param hub
     * @param adId
     * @param enabled
     * @return
     */
    public boolean enableImageAd(String hub,String adId,int enabled){
        String rawUrl = Const.HOST + "/v1/hubs/" + hub
                + "/ad/images/" + adId + "/enabled/" + enabled;

        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }
}
