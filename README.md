# ioToast 服务端


### Build docker image:
![Automated build](https://img.shields.io/docker/cloud/automated/akyakya/iotoast-service?style=flat-square)![Build Status](https://img.shields.io/docker/cloud/build/akyakya/iotoast-service?label=&style=flat-square) ![MicroBadger Layers (tag)](https://img.shields.io/microbadger/layers/akyakya/iotoast-service/latest?color=red&style=flat-square) ![MicroBadger Size (tag)](https://img.shields.io/microbadger/image-size/akyakya/iotoast-service/latest?style=flat-square) ![Docker Pulls](https://img.shields.io/docker/pulls/akyakya/iotoast-service?color=bluevioletstyle=flat-square)

here is the `Dockerfile`
```
FROM maven:3.6.1-jdk-8

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

VOLUME /tmp

WORKDIR /code

ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve","verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["mvn", "clean", "package"]
RUN ["ls", "/code/target"]

EXPOSE 1990

ENTRYPOINT [ "java", "-jar", "/code/target/iotoast.jar" ]
```
#### Docker Usage
`docker run --name iotoast -p 10000:1990 -d akyakya/iotoast-service`
