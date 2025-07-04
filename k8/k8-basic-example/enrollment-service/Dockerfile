FROM eclipse-temurin:17-jdk-alpine

# Copy the built JAR directly (no ARG needed for COPY)
COPY target/enrollment-service-0.0.1-SNAPSHOT.jar app.jar

# Use shell-style ENTRYPOINT (more Windows & Alpine friendly)
ENTRYPOINT java -jar /app.jar