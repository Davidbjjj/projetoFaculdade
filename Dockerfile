# Usar uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Maven para dentro do container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Define variáveis de ambiente recomendadas para o Render
ENV PORT=10000

# Expõe a porta que será usada pelo Render
EXPOSE 10000

# Comando para rodar a aplicação no Render
CMD ["java", "-jar", "app.jar"]
