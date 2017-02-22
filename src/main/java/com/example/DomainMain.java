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
        dargs.setDomain("zhaoling0002.qiniuts.com");
        dargs.setProtocol("https");
        dargs.setGeoCover("china");
        dargs.setServerKey("");
        dargs.setServerCrt("");

        boolean x = domainManage.createCustomDomain("qa-dianbotest", dargs);
        System.out.println(x);

        System.out.println(domainManage.getCustomDomainInfo("lingyue", "hao123.qbox.net"));
        System.out.println(domainManage.getCustomDomainInfoList("lingyue"));
        System.out.println(domainManage.setCustomDomain("lingyue", "hao123.qbox.net", 1));

        System.out.println(domainManage.enableCustomDomain("lingyue", "hao123.qbox.net", 1));
        System.out.println(domainManage.enableCustomDomain("lingyue", "hao123.qbox.net", 0));
        System.out.println(domainManage.removeCustomDomain("lingyue", "hao123.qbox.net"));
    }
}
