# Estágio 1: Build da aplicação usando a imagem oficial do JDK 25
FROM eclipse-temurin:25-jdk AS build

# Define a pasta de trabalho dentro do servidor
WORKDIR /app

# Copia todos os seus arquivos para lá
COPY . .

# Dá permissão ao Maven Wrapper e faz o build (o segredo está aqui!)
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Estágio 2: Execução usando apenas o necessário para rodar (JRE)
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]