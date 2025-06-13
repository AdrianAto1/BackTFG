# Use Eclipse Temurin (Java 17) base image
FROM eclipse-temurin:17-jdk-alpine

# Install necessary packages: bash for mvnw and dos2unix to fix line endings
RUN apk add --no-cache bash dos2unix

# Set working directory inside the container
WORKDIR /app

# Copy project files to the container
COPY . .

# Fix line endings (for Windows users) and give execute permissions to Maven Wrapper
RUN dos2unix mvnw && chmod +x mvnw

# Build the project using Maven Wrapper (skip tests to speed up)
RUN /bin/bash ./mvnw clean package -DskipTests

# Expose the application port (Railway will set $PORT)
EXPOSE 8080

# Run the generated JAR file
CMD ["java", "-jar", "target/BodasFinal-0.0.1-SNAPSHOT.jar"]
