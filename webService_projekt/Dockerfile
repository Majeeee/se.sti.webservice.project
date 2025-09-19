FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/webService_projekt-0.0.1-SNAPSHOT.jar /app/my-todo-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/my-todo-app.jar"]