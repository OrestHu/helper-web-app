FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/help-web-app-0.0.1-SNAPSHOT.jar help-web-app.jar
ENTRYPOINT ["java", "-jar", "/help-web-app.jar"]