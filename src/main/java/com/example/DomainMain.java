package com.example;

import com.qiniu.DomainManage;

/**
 * Created by qiniu
 */
public class DomainMain {

    public static void main(String[] args){

        DomainManage domainManage=new DomainManage();
        boolean x=domainManage.createCustomDomain("lingyue","hao123.qbox.net","china");
        System.out.println(x);
        System.out.println(domainManage.createCustomDomain("lingyue","leshi.qbox.net","china"));

        System.out.println(domainManage.getCustomDomainInfo("lingyue","hao123.qbox.net"));
        System.out.println(domainManage.getCustomDomainInfoList("lingyue"));
        System.out.println(domainManage.setCustomDomain("lingyue","hao123.qbox.net",1));

        System.out.println(domainManage.enableCustomDomain("lingyue","hao123.qbox.net",1));
        System.out.println(domainManage.enableCustomDomain("lingyue","hao123.qbox.net",0));
        System.out.println(domainManage.removeCustomDomain("lingyue","hao123.qbox.net"));
    }
}
