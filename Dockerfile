# Use Eclipse Temurin (Java 17) base image
FROM eclipse-temurin:17-jdk-alpine

# Set work directory
WORKDIR /app

# Copy and build the app
COPY . .

# Package using Maven Wrapper or install mvn locally
RUN ./mvnw clean package

# Expose port (Railway sets $PORT env automatically)
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/BodasFinal-0.0.1-SNAPSHOT.jar"]
