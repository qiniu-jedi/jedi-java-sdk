package com.model;

/**
 * Created by qiniu
 */
public class WatermarkInfo {

    private String type;
    private boolean enabled;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public int getOffset_x() {
        return offset_x;
    }

    public void setOffset_x(int offset_x) {
        this.offset_x = offset_x;
    }

    public int getOffset_y() {
        return offset_y;
    }

    public void setOffset_y(int offset_y) {
        this.offset_y = offset_y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_font() {
        return text_font;
    }

    public void setText_font(String text_font) {
        this.text_font = text_font;
    }

    public String getText_color() {
        return text_color;
    }

    public void setText_color(String text_color) {
        this.text_color = text_color;
    }

    public int getText_size() {
        return text_size;
    }

    public void setText_size(int text_size) {
        this.text_size = text_size;
    }

    private String gravity;
    private int offset_x;
    private int offset_y;
    private String image;
    private String text;
    private String text_font;
    private String text_color;
    private int text_size;

}
