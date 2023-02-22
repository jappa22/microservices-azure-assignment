FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} catalogue-service.jar
ENTRYPOINT ["java", "-jar", "/catalogue-service.jar"]
EXPOSE 8081