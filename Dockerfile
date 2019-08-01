FROM maven:3.6.1-jdk-8

#VOLUME /tmp
WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["mvn", "clean", "package"]

RUN ["ls", "/code/target"]
RUN ["pwd"]
RUN ["ls", "-ltrh", "/code/target/iotoast-*.jar"]

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/code/target/iotoast-*.jar" ]
