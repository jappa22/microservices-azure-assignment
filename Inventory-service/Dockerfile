FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} inventory-service.jar
ENTRYPOINT ["java", "-jar", "/inventory-service.jar"]
EXPOSE 8082