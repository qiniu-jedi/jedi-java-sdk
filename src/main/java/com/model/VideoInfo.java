package com.model;

/**
 * Created by qiniu.
 */
public class VideoInfo {

    private String bit_rate;
    private int width;
    private int height;
    private String frame_rate;

    public String getBit_rate() {
        return bit_rate;
    }

    public void setBit_rate(String bit_rate) {
        this.bit_rate = bit_rate;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFrame_rate() {
        return frame_rate;
    }

    public void setFrame_rate(String frame_rate) {
        this.frame_rate = frame_rate;
    }

    public String getCodec_name() {
        return codec_name;
    }

    public void setCodec_name(String codec_name) {
        this.codec_name = codec_name;
    }

    private String codec_name;

}

