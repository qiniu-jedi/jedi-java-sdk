package com.model;

/**
 * Created by qiniu
 */
public class XVod {
    private Callback callback;

    public XVod(String url){
        callback=new Callback(url);
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}


class Callback {
    private String url;
    public Callback(String url){
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}