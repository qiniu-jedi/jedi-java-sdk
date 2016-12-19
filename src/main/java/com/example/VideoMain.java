package com.example;

import com.model.UpdateVideoArgs;
import com.qiniu.VideoManage;

/**
 * Created by qiniu
 */
public class VideoMain {

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
    }
}
