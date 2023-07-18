FROM ubuntu:latest

ENV version=docker

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /app

ADD target/mz-bdleather.jar .

ENTRYPOINT ["java", "-jar", "mz-bdleather.jar"] 

