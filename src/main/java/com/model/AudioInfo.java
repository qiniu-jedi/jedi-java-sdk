package com.model;

/**
 * Created by qiniu.
 */
public class AudioInfo {

    private String bit_rate;
    private int quality;
    private String sample_rate;

    public String getBit_rate() {
        return bit_rate;
    }

    public void setBit_rate(String bit_rate) {
        this.bit_rate = bit_rate;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getSample_rate() {
        return sample_rate;
    }

    public void setSample_rate(String sample_rate) {
        this.sample_rate = sample_rate;
    }

    public String getCodec_name() {
        return codec_name;
    }

    public void setCodec_name(String codec_name) {
        this.codec_name = codec_name;
    }

    private String codec_name;
}



