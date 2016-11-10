package com.qiniu;

import com.google.gson.Gson;
import com.qiniu.util.UrlSafeBase64;
import com.model.UpdateVideoArgs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiniu.
 */
public class VideoManage {

    private static HttpClient httpClient;

    public VideoManage() {
        httpClient = HttpClient.getHttpClient();
    }

    /**
     * GET /v1/hubs/<Hub>/videos/<EncodedVideoKey>?include_player=<IncludePlayer>
     *
     * @return
     */
    public String getVideoInfo(String hub, String videoKey) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos/" + UrlSafeBase64.encodeToString(videoKey);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, null);
        return new Gson().toJson(ret);
    }

    /*
     * GET /v1/hubs/<Hub>/videos?cursor=<Cursor>&count=<Count>
     * Authorization: <QiniuToken>
     */
    public String getVideoInfoList(String hub, String cursor, Integer count) {
        if (count == null) {
            count = 100;
        }
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos?count=" + count;
        if (cursor != null && cursor.length() > 0) {
            rawUrl += "&cursor=" + cursor;
        }
        String auth = httpClient.getHttpRequestSign("GET", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("GET", rawUrl, null, false, auth);
        return new Gson().toJson(ret);
    }

    /*
     * PUT /v1/hubs/<Hub>/videos/<EncodedVideoKey>
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     */
    public boolean updateVideoInfo(UpdateVideoArgs args, String hub, String videoKey) {

        Gson gson = new Gson();
        String bodyStr = gson.toJson(args);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos/" + UrlSafeBase64.encodeToString(videoKey);

        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, bodyStr, true, auth);

        if ((Integer) ret.get("code") == 200) {
            return true;
        }

        return false;
    }

    /*
     * PUT /v1/hubs/<Hub>/videos/<EncodedVideoKey>/thumbnails/active/<Active>
     * Authorization: <QiniuToken>
     * @return
     */
    public boolean appointVideoThumbnails(String hub, String videoKey, int active) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos/" + UrlSafeBase64.encodeToString(videoKey)
                + "/thumbnails/active/" + active;

        String auth = httpClient.getHttpRequestSign("PUT", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("PUT", rawUrl, null, false, auth);
        if ((Integer) ret.get("code") == 200) {
            return true;
        }
        return false;
    }

    /*
     * DELETE /v1/hubs/<Hub>/videos/<EncodedVideoKey>
     * Authorization: <QiniuToken>
     */
    public boolean deleteOneVideo(String hub, String videoKey) {
        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos/" + UrlSafeBase64.encodeToString(videoKey);
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, null, false);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, null, false, auth);
        if ((Integer) ret.get("code") == 200) {
            return true;
        }

        return false;
    }

    /*
     * DELETE /v1/hubs/<Hub>/videos
     * Authorization: <QiniuToken>
     * Content-Type: application/json
     *
     * @return
     */
    public String deleteBatchVideos(String hub, String[] videoKeys) {

        for (int i = 0; i < videoKeys.length; i++) {
            videoKeys[i] = UrlSafeBase64.encodeToString(videoKeys[i]);
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("keys", videoKeys);
        String bodyStr = gson.toJson(map);

        String rawUrl = Const.HOST + "/v1/hubs/" + hub + "/videos";
        String auth = httpClient.getHttpRequestSign("DELETE", rawUrl, bodyStr, true);
        Map<String, Object> ret = httpClient.doRequest("DELETE", rawUrl, bodyStr, true, auth);

        return gson.toJson(ret);
    }


}
