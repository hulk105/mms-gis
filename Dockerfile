FROM maven:3.6.3-openjdk-11 as builder
ADD . /app/
WORKDIR /app/
RUN mvn clean install -DskipTests

FROM openjdk:11.0.10-jre-slim-buster
COPY --from=builder /app/target/*.jar /app/app.jar
WORKDIR /app/
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080