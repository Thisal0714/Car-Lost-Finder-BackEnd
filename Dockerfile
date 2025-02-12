FROM openjdk:23-jdk-slim

ARG JARFILE=target/LostCarFinder-0.0.1-SNAPSHOT.jar
COPY ${JARFILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
