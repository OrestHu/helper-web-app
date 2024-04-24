FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/help-web-app-0.0.1-SNAPSHOT.jar help-web-app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "help-web-app.jar"]