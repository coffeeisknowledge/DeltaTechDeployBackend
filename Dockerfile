FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/DiligenceTech-Platform-0.0.1-SNAPSHOT.jar DiligenceTech-Platform.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "DiligenceTech-Platform.jar"]

