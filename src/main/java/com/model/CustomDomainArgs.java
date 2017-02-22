package com.model;

/**
 * Created by qiniu
 */
public class CustomDomainArgs {

    private String domain;
    private String geoCover;
    private String protocol;
    private String serverKey;
    private String serverCrt;

    public String getGeoCover() {
        return geoCover;
    }

    public void setGeoCover(String geoCover) {
        this.geoCover = geoCover;
    }

    public CustomDomainArgs() {

    }

    public String getProtocol() {
        return protocol;

    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }

    public String getServerCrt() {
        return serverCrt;
    }

    public void setServerCrt(String serverCrt) {
        this.serverCrt = serverCrt;
    }


    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


}
