# Estágio 1: Build da aplicação usando Java 25
FROM maven:3.9.9-eclipse-temurin-25 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estágio 2: Execução usando o JRE do Java 25
FROM eclipse-temurin:25-jre
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]