FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY docker.jar app.jar
COPY cluster_ip.txt cluster_ip.txt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]