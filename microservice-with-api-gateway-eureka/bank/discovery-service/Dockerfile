FROM java:8
ARG JAR_FILE=target/discovery-service.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
EXPOSE 8761
