package com.qiniu;

import com.qiniu.util.Auth;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by qiniu.
 */
public class HttpClient {

    private String acceptKey;
    private String secretKey;

    private static volatile HttpClient httpClient = null;

    private HttpClient() {

    }

    private HttpClient(String ak, String sk) {
        this.acceptKey = ak;
        this.secretKey = sk;
    }


    public static HttpClient getHttpClient() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("resource/QiniuKey.properties"));

            String ak = prop.getProperty("acceptKey");
            String sk = prop.getProperty("secretKey");

            if (httpClient == null) {
                synchronized (HttpClient.class) {
                    if (httpClient == null) {
                        httpClient = new HttpClient(ak, sk);
                    }
                }
            }
            return httpClient;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * url
     * content-type
     * authorization
     **/
    public Map<String, Object> doRequest(String method, String rawUrl, String bodyStr, boolean hasContype, String auth) {
        try {
            URL url = new URL(rawUrl);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setRequestMethod(method);

            if (hasContype) {
                httpCon.setRequestProperty("Content-Type", "application/json");
            }

            if (auth != null && auth.length() > 0) {
                httpCon.setRequestProperty("Authorization", auth);
            }

            httpCon.setDoOutput(true);
            httpCon.setDoInput(true);


            OutputStreamWriter out = null;
            if (bodyStr != null && bodyStr.length() > 0) {
                out = new OutputStreamWriter(
                        httpCon.getOutputStream());
                out.write(bodyStr);
                out.flush();
                out.close();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String temp = null;
            StringBuilder sb = new StringBuilder();
            while ((temp = in.readLine()) != null) {
                sb.append(temp);
            }
            String result = sb.toString();
            in.close();

            int status = httpCon.getResponseCode();

            if (result != null && result.length() > 0) {
                result = result.trim();
            }


            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("code", status);
            resMap.put("msg", result);

            return resMap;

        } catch (Exception e) {
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("code", -1);
            resMap.put("msg", e.getMessage());
            return resMap;
        }
    }

    public String getHttpRequestSign(String method, String rawUrl, String bodyStr, boolean hasContype) {

        String contentType = null;
        if (hasContype) {
            contentType = "application/json";
        }

        String host = null;
        String uri = null;
        String rawQuery = null;


        try {
            URL connURL = new URL(rawUrl);
            host = connURL.getHost();
            uri = connURL.getPath();
            rawQuery = connURL.getQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String data = method + " " + uri;

        if (rawQuery != null && rawQuery.length() > 0) {
            data += "?" + rawQuery;
        }

        data += "\nHost: " + host;

        if (contentType != null && contentType.length() > 0) {
            data += "\nContent-Type: " + contentType;
        }

        data += "\n\n";

        if (contentType != null && contentType.length() > 0 && bodyStr != null && bodyStr.length() > 0 && (!contentType.equals("application/octet-stream"))) {
            data += bodyStr;
        }

        try {
            Auth auth = Auth.create(acceptKey, secretKey);
            String sign = auth.sign(data);
            return "Qiniu " + sign;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
