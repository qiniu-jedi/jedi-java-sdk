package com.model;

/**
 * Created by qiniu
 */
public class VideoAdInfo {

    private String videoKey;
    private boolean enabled;
    private String name;
    private String position;
    private String url;

    public String getVideoKey() {
        return videoKey;
    }

    public void setVideoKey(String videoKey) {
        this.videoKey = videoKey;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
