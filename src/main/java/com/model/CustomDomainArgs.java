package com.model;

/**
 * Created by qiniu
 */
public class CustomDomainArgs {

    public CustomDomainArgs(String domain,String geoCover){
        this.setDomain(domain);
        this.setGeoCover(geoCover);
    }

    private String domain;
    private String geoCover;

    public String getDomain(){
        return  this.domain;
    }

    public void setDomain(String domain){
        this.domain=domain;
    }

    public String getGeoCover(){
        return this.geoCover;
    }
    public void setGeoCover(String geoCover){
        this.geoCover=geoCover;
    }

}
