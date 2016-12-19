package com.qiniu;

import com.google.gson.Gson;
import com.qiniu.util.UrlSafeBase64;

import java.util.Map;

/**
 * Created by qiniu
 */
public class DRMManage {
    private static HttpClient httpClient;

    public DRMManage() {
        httpClient = HttpClient.getHttpClient();
    }

    public boolean setDRMSafeMode(String hub, int mode) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/protection/" + mode;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);

        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);
        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /***
     * GET /v1/hubs/<Hub>/protection
     * Authorization: <QiniuToken>
     * @param hub
     * @return
     */
    public String getDRMSafeMode(String hub) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/protection";
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }

    /***
     * GET /v1/hubs/<Hub>/videos/<EncodedVideoKey>/ukey
     * Authorization: <QiniuToken>
     * @param hub
     * @param videoKey
     * @return
     */
    public String getVideoUserSecretKey(String hub, String videoKey) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos/" + UrlSafeBase64.encodeToString(videoKey) + "/ukey";
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }
}
