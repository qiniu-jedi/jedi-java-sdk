
package com.example;

import com.model.*;
import com.qiniu.*;

public class MarqueeMain {
    public static void main(String[] args) {

        System.out.println("======================marquee manage======================");
        System.out.println("========================create or update marquee conf==========================");
        MarqueeManage marqueeManage = new MarqueeManage();
        MarqueeConf marquee = new MarqueeConf();
        marquee.setDirection("xyz");
        marquee.setEnabled(true);
        marquee.setLoop(-1);
        marquee.setDuration(2);
//        marquee.setImage("1.png");
        marquee.setText("marquee");
        marquee.setTextFont("Consolas");
        marquee.setTextColor("#FF");
        marquee.setTextSize(12);

        System.out.println(marqueeManage.createMarqueeConf(marquee, "lingyue"));


        System.out.println("======================get marquee conf=======================");
        System.out.println(marqueeManage.getMarqueeConf("lingyue"));

        System.out.println("====================enable marquee conf======================");
        System.out.println(marqueeManage.enableMarqueeConf("lingyue", 0));

        System.out.println("======================get marquee conf=======================");
        System.out.println(marqueeManage.getMarqueeConf("lingyue"));


    }


}
