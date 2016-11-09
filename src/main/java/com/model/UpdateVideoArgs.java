package com.model;

/**
 * Created by qiniu
 */
public class UpdateVideoArgs {

    private String name;

    private String[] tags;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {

        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
