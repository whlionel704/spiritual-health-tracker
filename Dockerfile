# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application's JAR file into the container
ARG JAR_FILE=target/spiritual-health-tracker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose the port the app runs on
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
