package com.qiniu;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.TranssetArgs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiniu.
 */
public class TransconfManage {

    private static HttpClient httpClient;

    public TransconfManage() {
        httpClient = HttpClient.getHttpClient();
    }

    /*
     * POST /v1/hubs/<Hub>/transconfs
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     * @return
     */
    public String createTransconf(String hub, String transconfName) {

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", transconfName);

        Gson gson = new Gson();
        String bodyStr = gson.toJson(map);

        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);
    }

    /*
     * DELETE /v1/hubs/<Hub>/transconfs/<TransconfId>
     * Authorization: <QiniuToken>
     * @return
     */
    public boolean deleteTransconf(String hub, String transconfId) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs/" + transconfId;
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * POST /v1/hubs/<Hub>/transconfs/<TransconfId>/transsets
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     */
    public String createTransset(TranssetArgs args, String hub, String transconfId) {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        String bodyStr = gson.toJson(args);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs/" + transconfId + "/transsets";
        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);

        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);
        return gson.toJson(ret);
    }

    /*
     * GET /v1/hubs/<Hub>/transconfs/<TransconfId>/transsets/<TranssetId>
     * Authorization: <QiniuToken>
     */
    public String getTransset(String hub, String transconfId, String transsetId) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs/" + transconfId + "/transsets/" + transsetId;
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);

        return new Gson().toJson(ret);
    }

    /*
     * PUT /v1/hubs/<Hub>/transconfs/<TransconfId>/transsets/<TranssetId>
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     * @return
     */
    public boolean updateTransset(TranssetArgs args, String hub, String transconfId, String transsetId) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        String bodyStr = gson.toJson(args);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs/" + transconfId + "/transsets/" + transsetId;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * DELETE /v1/hubs/<Hub>/transconfs/<TransconfId>/transsets/<TranssetId>
     * Authorization: <QiniuToken>
     */
    public boolean deleteTransset(String hub, String transconfId, String transsetId) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs/" + transconfId + "/transsets/" + transsetId;
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, null, false);

        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * PUT /v1/hubs/<Hub>/transconfs/<TransconfId>/transsets/<TranssetId>/enabled/<Enabled>
     * Authorization: <QiniuToken>
     * @return
     */
    public boolean enableTransset(String hub, String transconfId, String transsetId, int enabled) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfs/" + transconfId
                + "/transsets/" + transsetId + "/enabled/" + enabled;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);

        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);
        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * GET /v1/hubs/<Hub>/transconfsall
     * Authorization: <QiniuToken>
     * @return
     */
    public String getAllTransconf(String hub) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/transconfsall";
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);

        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }


}
