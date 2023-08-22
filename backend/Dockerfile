FROM maven:latest AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN mvn clean package -DskipTests

FROM openjdk:21-ea-17-jdk-slim
ARG PROJECT_NAME=super-market
ARG VERSION=0.0.1
ARG JAR_FILE=${PROJECT_NAME}-${VERSION}.jar
WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/${PROJECT_NAME}.jar

ENTRYPOINT [ "java", "-jar", "super-market.jar" ]
