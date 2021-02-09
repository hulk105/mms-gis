FROM openjdk:11.0.9.1-oraclelinux8
COPY target/*.jar /tmp/app.jar
WORKDIR /tmp/
ENTRYPOINT ["java","-jar","app.jar"]
