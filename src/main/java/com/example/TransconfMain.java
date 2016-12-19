package com.example;

import com.model.AudioInfo;
import com.model.TranssetArgs;
import com.model.VideoInfo;
import com.qiniu.TransconfManage;

/**
 * Created by qiniu
 */
public class TransconfMain {


    public static void main(String[] args) {
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

    }
}
