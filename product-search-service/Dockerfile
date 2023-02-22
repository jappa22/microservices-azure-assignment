FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} product-search-service.jar
ENTRYPOINT ["java", "-jar", "/product-search-service.jar"]
EXPOSE 8083