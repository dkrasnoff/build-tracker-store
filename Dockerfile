FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine
VOLUME /tmp

ARG JAR_FILE

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]