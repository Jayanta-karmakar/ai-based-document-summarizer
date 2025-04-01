# Use Eclipse Temurin JDK 21 as the base image
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built application JAR into the container
COPY target/ai-based-document-summarizer-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
