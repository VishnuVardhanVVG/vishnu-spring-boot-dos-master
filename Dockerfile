FROM openjdk:11
ADD target/vishnu-spring-boot-dos-0.0.1-SNAPSHOT.jar vishnu-spring-boot-dos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","vishnu-spring-boot-dos-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080