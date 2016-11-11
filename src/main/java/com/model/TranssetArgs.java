package com.model;

/**
 * Created by qiniu
 */
public class TranssetArgs {

    private String name;
    private boolean enabled;
    private String format;
    private VideoInfo video;
    private AudioInfo audio;

    public AudioInfo getAudio() {
        return audio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public VideoInfo getVideo() {
        return video;
    }

    public void setVideo(VideoInfo video) {
        this.video = video;
    }

    public void setAudio(AudioInfo audio) {
        this.audio = audio;
    }
}




