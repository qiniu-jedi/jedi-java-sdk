package com.example;

import com.model.WatermarkInfo;
import com.qiniu.WatermarkManage;

/**
 * Created by qiniu
 */
public class WatermarkMain {

    public static void main(String[] args) {

        System.out.println("==============watermark manage===============");
        WatermarkManage wm = new WatermarkManage();
        System.out.println("===============cteate watermark conf================");
        WatermarkInfo watermark = new WatermarkInfo();
        watermark.setType("text");
        watermark.setEnabled(false);
        watermark.setGravity("North");
        watermark.setOffsetX(1);
        watermark.setOffsetY(2);
        watermark.setImage("1.png");
        watermark.setText("watermark");
        watermark.setTextFont("Consolas");
        watermark.setTextColor("#ffffff");
        watermark.setTextSize(12);

        System.out.println(wm.createWatermarkConf(watermark, "lingyue"));


        System.out.println("==============update watermark conf====================");

        watermark = new WatermarkInfo();
        watermark.setType("text");
        watermark.setEnabled(true);
        watermark.setGravity("NorthWest");
        watermark.setOffsetX(1);
        watermark.setOffsetY(2);
        watermark.setImage("1.png");
        watermark.setText("watermark");
        watermark.setTextFont("Consolas");
        watermark.setTextColor("#ffffff");
        watermark.setTextSize(12);

        System.out.println(wm.updateWatermarkConf(watermark, "lingyue", "58228cee64703c8164000288"));

        System.out.println("===============get watermark conf===================");
        System.out.println(wm.getWatermarkConf("lingyue", "58228cee64703c8164000288"));


        System.out.println("==================get all watermark confs=====================");
        System.out.println(wm.getAllWatermarkConf("lingyue"));

        System.out.println("===================enable watermark conf=======================");
        System.out.println(wm.enableWatermarkConf("lingyue", "58228cee64703c8164000288", 0));

        System.out.println("===============get watermark conf===================");
        System.out.println(wm.getWatermarkConf("lingyue", "58228cee64703c8164000288"));

        System.out.println("=====================delete watermark conf=======================");
        System.out.println(wm.deleteWatermarkConf("lingyue", "58228cee64703c8164000288"));

        System.out.println("===============get watermark conf===================");
        System.out.println(wm.getWatermarkConf("lingyue", "58228cee64703c8164000288"));
    }

}
