package com.example;

import com.model.CustomDomainArgs;
import com.qiniu.DomainManage;

/**
 * Created by qiniu
 */
public class DomainMain {

    public static void main(String[] args) {

        DomainManage domainManage = new DomainManage();
        CustomDomainArgs dargs = new CustomDomainArgs();
        dargs.setDomain("your domain");
        dargs.setProtocol("https or http");
        dargs.setGeoCover("china");
        dargs.setServerKey("your server key");
        dargs.setServerCrt("your server crt");

        System.out.println(domainManage.createCustomDomain("your hub name", dargs));
        System.out.println(domainManage.getCustomDomainInfo("your hub name", "your domain"));
        System.out.println(domainManage.getCustomDomainInfoList("your hub name"));
        System.out.println(domainManage.setCustomDomain("your hub name", "your domain", 1));
        System.out.println(domainManage.enableCustomDomain("your hub name", "your domain", 1));
        System.out.println(domainManage.enableCustomDomain("your hub name", "your domain", 0));
        System.out.println(domainManage.removeCustomDomain("your hub name", "your domain"));
    }
}
