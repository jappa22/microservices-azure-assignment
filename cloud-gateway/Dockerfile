FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cloud-gateway-service.jar
ENTRYPOINT ["java", "-jar", "/cloud-gateway-service.jar"]
EXPOSE 9191