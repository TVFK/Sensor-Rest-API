FROM ubuntu:latest
FROM openjdk:latest
LABEL authors="Tavfik"

COPY sensorRestApi.jar sensorApi.jar

ENTRYPOINT ["java", "-jar", "sensorApi.jar"]

EXPOSE 8080