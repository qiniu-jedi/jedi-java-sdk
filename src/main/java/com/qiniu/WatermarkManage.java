package com.qiniu;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.WatermarkInfo;

import java.util.Map;

/**
 * Created by qiniu.
 * 水印的设置
 * 包括 水印的增删改查
 */
public class WatermarkManage {

    private static HttpClient httpClient;

    public WatermarkManage() {
        httpClient = HttpClient.getHttpClient();
    }

    /*
     * POST /v1/hubs/<Hub>/watermarks
     */
    public String createWatermarkConf(WatermarkInfo watermark, String hub) {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        String bodyStr = gson.toJson(watermark);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/watermarks";
        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);
    }

    /*
     * PUT /v1/hubs/<Hub>/watermarks/<WatermarkId>
     */
    public boolean updateWatermarkConf(WatermarkInfo watermark, String hub, String watermarkId) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        String bodyStr = gson.toJson(watermark);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/watermarks/" + watermarkId;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * DELETE /v1/hubs/<Hub>/watermarks/<WatermarkId>
     */
    public boolean deleteWatermarkConf(String hub, String watermarkId) {

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/watermarks/" + watermarkId;
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * GET /v1/hubs/<Hub>/watermarks/<WatermarkId>
     */
    public String getWatermarkConf(String hub, String watermarkId) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/watermarks/" + watermarkId;
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);

        return new Gson().toJson(ret);
    }

    /*
     * GET /v1/hubs/<Hub>/watermarks
     */
    public String getAllWatermarkConf(String hub) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/watermarks";
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }

    /*
     * PUT /v1/hubs/<Hub>/watermarks/<WatermarkId>/enabled/<Enabled>
     */
    public boolean enableWatermarkConf(String hub, String watermarkId, int enabled) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/watermarks/" + watermarkId + "/enabled/" + enabled;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }
}
