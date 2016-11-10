package com.model;

/**
 * Created by qiniu.
 */
public class AudioInfo {

    private String bitRate;

    private int quality;
    private String sampleRate;
    private String codecName;

    public int getQuality() {
        return quality;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getCodecName() {
        return codecName;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }


    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }


}



