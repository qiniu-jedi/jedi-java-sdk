package com.example;

import com.qiniu.DRMManage;

/**
 * Created by qiniu
 */
public class DRMMain {


    public static void main(String[] args) {
        DRMManage drmManage = new DRMManage();

        boolean s = drmManage.setDRMSafeMode("lingyue", 0);
        System.out.println(s);

        System.out.println(drmManage.getDRMSafeMode("lingyue"));

        System.out.println(drmManage.getVideoUserSecretKey("lingyue", "bz.mp4"));

    }
}
