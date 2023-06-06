# Use a base image with Java and Maven
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory in the container
WORKDIR /app
 
# Copy the Maven project file
COPY pom.xml .

# Resolve Maven dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "target/EquiGame-0.0.1-SNAPSHOT.jar"]