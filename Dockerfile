FROM ubuntu:latest

ENV version=aws-db-prod-version

ENV dbuser=postgres

ENV dbpass=pass1234

ENV jdbcurl=jdbc:postgresql://mz-bd-leather-db.cnxd3mjlqx8v.us-east-2.rds.amazonaws.com:5432/postgres

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /app

ADD target/mz-bdleather.jar .

ENTRYPOINT ["java", "-jar", "mz-bdleather.jar"] 

