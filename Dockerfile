FROM maven:3.6.3-openjdk-11 as builder
ADD . /gis-monitoring-service/
WORKDIR /gis-monitoring-service/
RUN mvn clean install -DskipTests

FROM openjdk:11.0.10-jre-slim-buster
COPY --from=builder /gis-monitoring-service/target/*.jar /gis-monitoring-service/app.jar
WORKDIR /gis-monitoring-service/
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080