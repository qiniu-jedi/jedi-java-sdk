package com.example;

import com.qiniu.DRMManage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiniu
 */
public class DRMMain {

    public static void main(String[] args) {
        DRMManage drmManage = new DRMManage();
        boolean s = drmManage.setDRMSafeMode("your hub name", 0);
        System.out.println(s);
        System.out.println(drmManage.getDRMSafeMode("your hub name"));
        System.out.println(drmManage.getVideoUserSecretKey("your hub name", "your video file name"));
    }
}
