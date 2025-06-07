# Use Eclipse Temurin (Java 17) base image
FROM eclipse-temurin:17-jdk-alpine

# Set work directory
WORKDIR /app

# Copy all files
COPY . .

# Give execute permission to mvnw
RUN chmod +x mvnw

# Package using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Expose port (Railway sets $PORT env automatically)
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/BodasFinal-0.0.1-SNAPSHOT.jar"]
