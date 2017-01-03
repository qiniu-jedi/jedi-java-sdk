package com.example;

import com.model.ImageAdArgs;
import com.qiniu.ImageAdManage;
import com.qiniu.UploadRes;

/**
 * Created by qiniu
 */
public class ImageAdMain {

    public static void main(String[] args) {
        ImageAdManage imageAdManage = new ImageAdManage();

        UploadRes up = new UploadRes();
        System.out.println(up.uploadResource("lingyue", 3600 * 7, "image_ad", "1.jpeg", "/Users/l2015019/Desktop/1.jpeg"));

        ImageAdArgs imageAdArgs=new ImageAdArgs();
        imageAdArgs.setImage("qresources/image_ad/58578e1bcaf6554c28000179");
        imageAdArgs.setEnabled(true);
        imageAdArgs.setFileName("caoz");
        imageAdArgs.setName("hellocode");
        imageAdArgs.setPosition("op");
        imageAdArgs.setUrl("http://www.baidu.com");

        String res = imageAdManage.createImageAd("jedihub", imageAdArgs);
        System.out.println(res);

        System.out.println(imageAdManage.getImageAdInfo("jedihub","58578e37caf6554c2800017a"));
        System.out.println(imageAdManage.getImageAdInfoList("jedihub"));

        System.out.println(imageAdManage.enableImageAd("lingyue","58578e37caf6554c2800017a",0));
        System.out.println(imageAdManage.getImageAdInfo("lingyue","58578e37caf6554c2800017a"));


        imageAdArgs.setName("qiniu");
        System.out.println(imageAdManage.updateImageAd("lingyue","58578e37caf6554c2800017a",imageAdArgs));
        System.out.println(imageAdManage.getImageAdInfo("lingyue","58578e37caf6554c2800017a"));

        System.out.println(imageAdManage.deleteImageAd("lingyue","58578e37caf6554c2800017a"));
        System.out.println(imageAdManage.deleteImageAdList("lingyue",new String[]{"58578e37caf6554c2800017a","58577f29caf6554c28000177"}));

        System.out.println(imageAdManage.getImageAdInfoList("lingyue"));


    }
}
