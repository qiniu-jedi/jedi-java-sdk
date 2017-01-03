package com.qiniu;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.MarqueeConf;

import java.util.Map;

/**
 * Created by qiniu.
 * 跑马灯管理
 * 包括跑马灯的增查，停用启用
 */
public class MarqueeManage {

    private static HttpClient httpClient;

    public MarqueeManage() {
        httpClient = HttpClient.getHttpClient();

    }


    /*
     * POST /v1/hubs/<Hub>/marquee
     */
    public boolean createMarqueeConf(MarqueeConf marquee, String hub) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        String bodyStr = gson.toJson(marquee);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/marquee";
        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        System.out.println("http response status:" + ret.get("code") + " error");
        return false;
    }

    /*
     * GET /v1/hubs/<Hub>/marquee
     */
    public String getMarqueeConf(String hub) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/marquee";
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        Gson gson = new Gson();
        return gson.toJson(ret);
    }

    /*
     * PUT /v1/hubs/<Hub>/marquee/enabled/<Enabled>
     */
    public boolean enableMarqueeConf(String hub, int enabled) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/marquee/enabled/" + enabled;
        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }

        return false;
    }
}
