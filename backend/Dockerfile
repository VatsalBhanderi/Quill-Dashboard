#build-time container
#FROM openjdk:17-jdk-slim as builder
#ARG JAR_FILE
#WORKDIR app
#COPY $backend backend
#COPY $JAR_FILE application.jar

#FROM gcr.io/distroless/java17-debian12
#ARG JAR_FILE
#WORKDIR /app
#COPY $JAR_FILE application.jar
#ENTRYPOINT ["java","-jar","application.jar"]

# Stage 1: Build
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY quill /app
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM gcr.io/distroless/java17-debian12
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

