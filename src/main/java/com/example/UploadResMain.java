package com.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.XVod;
import com.qiniu.UploadRes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiniu
 */
public class UploadResMain {
    public static void main(String[] args) {
        System.out.println("==============upload resource demo===============");
        UploadRes up = new UploadRes();

        XVod xVod=new XVod("http://www.baidu.com");
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        String vodStr=gson.toJson(xVod);
        System.out.println(vodStr);

        Map<String,Object> pmap=new HashMap<String, Object>();
        pmap.put("x:vod",vodStr);
        pmap.put("key","qq2.mp4");

        Map<String, Object> res = up.uploadResource("lingyue", 3600 * 7,null, "/Users/l2015019/Downloads/qq.mp4", pmap);

        Set<String> set = res.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = it.next();
            System.out.println(key + " : " + res.get(key));
        }
    }
}
