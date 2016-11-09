# jedi-java-sdk


## 安装

下载 [the latest JAR][1] 或者 通过 Maven:
```xml
<dependency>
  <groupId>com.qiniu</groupId>
  <artifactId>qiniu-java-sdk</artifactId>
  <version>[7.0.0, 7.2.99]</version>
</dependency>
```
或者 Gradle:
```groovy
compile 'com.qiniu:qiniu-java-sdk:7.1.+'
```
7.0.x 版本的jdk 6.0 不能直接使用mvn上的okhttp, 需要另外下载，[代码][2], [okhttp.jar][3], [okio.jar][4]
7.1.x, 7.2.x 版本 jdk6.0 支持 后面会做处理，暂时只支持7及以上, 原因同前。

## 运行环境

| Qiniu SDK版本 | Java 版本 |
|:--------------------:|:---------------------------:|
|          7.2.x         |  7+ |
|          7.1.x         |  7+ |
|          7.0.x         |  6+ |
|          6.x         |  6+ |

## 使用方法

* 在resource文件夹的QiniuKey.properties中填写自己的key，从portal中获得，这一步先做后续的操作才能进行。

* SDK包含视频管理，转码配置和预设，水印配置，跑马灯配置和视频广告配置，需要用相应的方法，只需要实例化相应的类即可。

* 上传资源，调用UploadRes类来上传。

* JEDI 的 SDK 只依赖于七牛的存储SDK（包括okhttp,gson），不依赖于其他外部jar包。