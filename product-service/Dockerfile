# Use Ubuntu as the base image
FROM ubuntu:22.04

# Avoid prompts from apt
ENV DEBIAN_FRONTEND=noninteractive

# Install OpenJDK for Java and Maven for building the app
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    rm -rf /var/lib/apt/lists/* && \
    apt-get clean

# Copy your application source
WORKDIR /app
COPY src /app/src
COPY pom.xml /app/

# Build your Spring Boot application
RUN mvn clean package -DskipTests

# Create the directory before moving the JAR
RUN mkdir -p /opt/app

# Move the built jar to a known location
RUN mv target/*.jar /opt/app/app.jar

# Expose ports for your application and MySQL
EXPOSE 8090

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","/opt/app/app.jar"]