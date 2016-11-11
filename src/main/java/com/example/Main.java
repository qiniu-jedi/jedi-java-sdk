
package com.example;

import com.model.*;
import com.qiniu.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("===========video manage=============");
        System.out.println("==========get video info=============");
        VideoManage vm = new VideoManage();
        String ret = vm.getVideoInfo("lingyue", "bz.mp4");
        System.out.println(ret);

        System.out.println("========get video list========");
        String videosRet = vm.getVideoInfoList("lingyue", null, 10);
        System.out.println(videosRet);

        System.out.println("========update video info==========");
        UpdateVideoArgs uv = new UpdateVideoArgs();
        uv.setName("wanggang.mp4");
        uv.setTags(new String[]{"1", "2", "3"});
        uv.setDescription("hhhh");

        System.out.println(vm.updateVideoInfo(uv, "lingyue", "bz.mp4"));

        System.out.println("==========appoint thumbnails=========");
        System.out.println(vm.appointVideoThumbnails("lingyue", "bz.mp4", 1));

        System.out.println("======delete video info=======");
        System.out.println(vm.deleteOneVideo("lingyue", "bz.mp4"));

        System.out.println("=======delete video list==========");
        System.out.println(vm.deleteBatchVideos("lingyue", new String[]{"bz.mp4", "onepiece.mp4"}));

        /********************transconf*************************/
        TransconfManage tr = new TransconfManage();
        System.out.println("==========create transconf===========");
        System.out.println(tr.createTransconf("lingyue", "nju123"));

        System.out.println("==========delete transconf============");
        System.out.println(tr.deleteTransconf("lingyue", "5821b88964703c8164000249"));

        System.out.println("============create transsets===============");
        TranssetArgs trArgs = new TranssetArgs();
        trArgs.setName("njutransset");
        trArgs.setEnabled(false);
        trArgs.setFormat("mp4");

        AudioInfo audio = new AudioInfo();
        audio.setQuality(50);
        audio.setBitRate("256k");
        audio.setSampleRate("44100");
        audio.setCodecName("libfaac");


        VideoInfo video = new VideoInfo();
        video.setBitRate("150k");
        video.setWidth(1280);
        video.setHeight(720);
        video.setFrameRate("24");
        video.setCodecName("libx264");

        trArgs.setAudio(audio);
        trArgs.setVideo(video);


        System.out.println(tr.createTransset(trArgs, "lingyue", "5821bbc8caf655a71d000242"));

        System.out.println("============get transsets============");
        System.out.println(tr.getTransset("lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243"));

        System.out.println("===========update transsets=============");

        trArgs = new TranssetArgs();
        trArgs.setName("njucoder");
        trArgs.setEnabled(false);
        trArgs.setFormat("mp4");

        audio = new AudioInfo();
        audio.setQuality(50);
        audio.setBitRate("256k");
        audio.setSampleRate("44100");
        audio.setCodecName("libfaac");


        video = new VideoInfo();
        video.setBitRate("150k");
        video.setWidth(1280);
        video.setHeight(720);
        video.setFrameRate("24");
        video.setCodecName("libx264");

        trArgs.setAudio(audio);
        trArgs.setVideo(video);
        System.out.println(tr.updateTransset(trArgs, "lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243"));

        System.out.println("===========get transsets=============");
        System.out.println(tr.getTransset("lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243"));

        System.out.println("===========enable transsets==============");
        System.out.println(tr.enableTransset("lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243", 1));

        System.out.println("==========get transsets==============");
        System.out.println(tr.getTransset("lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243"));

        System.out.println("===========get all transconfs=============");
        System.out.println(tr.getAllTransconf("lingyue"));


        System.out.println("===================delete transset====================");
        System.out.println(tr.deleteTransset("lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243"));

        System.out.println("============get transset after delete transset============");
        System.out.println(tr.getTransset("lingyue", "5821bbc8caf655a71d000242", "5821bc07caf655a71d000243"));


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

        System.out.println("=========video ad==========");

        VideoAdManage videoAdManage = new VideoAdManage();
        VideoAdInfo vad = new VideoAdInfo();
        vad.setVideoKey("video-ad");
        vad.setEnabled(true);
        vad.setName("video-ad-name");
        vad.setPosition("North");
        vad.setUrl("http//www.hao123.com");

        System.out.println("=========create video ad==========");
        System.out.println(videoAdManage.createVideoAdConf(vad, "lingyue"));

        System.out.println("==============upload resource===============");
        UploadRes up = new UploadRes();
        System.out.println(up.uploadResource("lingyue", 3600 * 7, null, "bz2.mp4", "/Users/l2015019/Downloads/bz.mp4"));

    }


}
