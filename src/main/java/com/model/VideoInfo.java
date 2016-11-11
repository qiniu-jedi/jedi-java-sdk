package com.model;

/**
 * Created by qiniu.
 */
public class VideoInfo {

    private String bitRate;
    private int width;
    private int height;
    private String frameRate;
    private String codecName;


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


    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getCodecName() {
        return codecName;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }
}

