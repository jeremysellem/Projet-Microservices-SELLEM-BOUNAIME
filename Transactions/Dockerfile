FROM openjdk:8-jdk-alpine
ADD target/spring-boot-transaction-app.jar spring-boot-transaction-app.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "spring-boot-transaction-app.jar"]