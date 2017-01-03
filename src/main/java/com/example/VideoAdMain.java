package com.example;

import com.model.VideoAdInfo;
import com.qiniu.UploadRes;
import com.qiniu.VideoAdManage;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiniu
 */
public class VideoAdMain {


    public static void main(String[] args) {
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
        Map<String, Object> res = up.uploadResource("lingyue", 3600 * 7, null, "bz1.mp4", "/Users/l2015019/Downloads/bz.mp4");

        Set<String> set = res.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = it.next();
            System.out.println(key + " : " + res.get(key));
        }
    }
}
