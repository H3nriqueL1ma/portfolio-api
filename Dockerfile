FROM maven:3.9.7-eclipse-temurin-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin
COPY --from=build /target/portfolio-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar"]