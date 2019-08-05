FROM tcr:5000/topsec/openjdk:8u131-jdk-alpine-base-1

# MAINTAINER指令允许你给将要制作的镜像设置作者信息
MAINTAINER iucheng <liu_cheng@topsec.com.cn>

#ADD cacerts /etc/ssl/certs/java/cacerts

ADD serivceGRPC-1.0-SNAPSHOT.jar /serivceGRPC-1.0-SNAPSHOT.jar

ENV TZ "Asia/Shanghai"


EXPOSE 50051

#dockerfile中增加健康检查，interval表示每个5分钟检查一次，timeout每次超过5秒钟认定为失败，retries失败后轮询3次认定为容器不健康，考虑重启。
#HEALTHCHECK --interval=60s --timeout=5s --retries=6 \
#  CMD curl -f http://localhost:8180 || exit 1

ENTRYPOINT ["java","-jar","/serivceGRPC-1.0-SNAPSHOT.jar"]