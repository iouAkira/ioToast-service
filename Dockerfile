FROM maven:3.6.1-jdk-8

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

VOLUME /tmp

WORKDIR /code

ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve","verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["cp", "/code/src/main/resource/application.properties", "/code/app-prod.properties"]
RUN ["mvn", "clean", "package"]
RUN ["ls", "/code", "/code/target"]

EXPOSE 1990

ENTRYPOINT [ "java", "-jar","-Dspring.config.location=/code/app-prod.properties", "/code/target/iotoast.jar" ]
