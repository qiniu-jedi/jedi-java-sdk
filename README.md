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
* 7.0.x 版本的jdk 6.0 不能直接使用mvn上的okhttp, 需要另外下载，[代码][2], [okhttp.jar][3], [okio.jar][4]
7.1.x, 7.2.x 版本 jdk6.0 支持 后面会做处理，暂时只支持7及以上, 原因同前。
* 上述安装操作，是下载安装存储的sdk，并且这步是必须的。点播云的sdk，可以将本项目的代码放置到自己的项目环境中，注意路径设置，具体参考项目源码。

## 运行环境

| Qiniu SDK版本 | Java 版本 |
|:--------------------:|:---------------------------:|
|          7.2.x         |  7+ |
|          7.1.x         |  7+ |
|          7.0.x         |  6+ |
|          6.x         |  6+ |

## 使用方法

* 填写 用户 Access Key 和 Secret Key 到resource的配置文件中。登陆 https://portal.qiniu.com 可以查看自己的 Access Key 和 Secret Key。

* SDK包含视频管理，转码配置和预设，水印配置，跑马灯配置，视频广告配置，贴片广告配置，DRM配置，自定义域名配置，需要用相应的方法，只需要实例化相应的类即可。

* 上传资源，调用UploadRes类来上传,private 方法不要修改和调用，直接调用相应的public方法即可。该public方法属于直传文件方法。

* 点播云的 SDK 只依赖于七牛的存储SDK（存储SDK会自动下载它依赖的第三方包，包括okhttp,gson），除了存储的jar包，不依赖于其他外部jar包。


## 方法返回值说明
* 对于返回值为string的方法,需要反序列化，可以在该项目的model包里找到相应的pojo
```
  {
     "msg": http response body,
     "code": 200
  }
```
* 对于不能返回正确结果或者抛出异常的方法
```
  {
      "msg": http response body,
      "code":http response status (400,401,403,404,500,501,502...) ，不能识别的返回-1
  }
```
* 对于返回值为布尔值的方法,直接判断服务器是否返回200来判断,返回200则为true，否则为false

***
## 其他
* 如果在使用过程中，遇到bug或者不人性化的地方，欢迎指出，并在 https://github.com/qiniu-jedi/jedi-java-sdk/issues 中提出issue，七牛开发者会持续跟进该sdk，并改进。





