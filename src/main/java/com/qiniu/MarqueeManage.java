package com.qiniu;

import com.google.gson.Gson;
import com.model.MarqueeConf;

import java.util.Map;

/**
 * Created by qiniu.
 */
public class MarqueeManage {

    private static HttpClient httpClient;

    public MarqueeManage() {
        httpClient = HttpClient.getHttpClient();

    }


    /*
     * POST /v1/hubs/<Hub>/marquee
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     * @return
     */
    public boolean createMarqueeConf(MarqueeConf marquee, String hub) {
        Gson gson = new Gson();
        String bodyStr = gson.toJson(marquee);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/marquee";
        String auth = httpClient.getHttpRequestSign("POST", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("POST", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }

        return false;
    }

    /*
     * GET /v1/hubs/<Hub>/marquee
     * Authorization: <QiniuToken>
     * @return
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
     * Authorization: <QiniuToken>
     * @return
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
