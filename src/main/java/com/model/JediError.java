package com.model;

import java.util.Map;

/**
 * Created by qiniu
 * 标准的错误类型
 */
public class JediError {

    private String error;
    private String description;

    private Map<String, Object> parameters;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}

