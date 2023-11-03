# Criando a partir de uma imagem do ubuntu (versão mais recente)
FROM ubuntu:latest AS build

# Atualizando os pacoted o meu linux
RUN apt-get update

# Instalando o JDK 17 no meu linux
RUN apt-get install openjdk-17-jdk -y

# Copiando o meu projeto para o container
COPY . .

# Instalando o Maven
RUN apt-get install maven -y

# Gerando um .jar do meu app
RUN mvn clean package

# Criando a partir de uma imagem do java 17
FROM openjdk:17-jdk-slim

# Expondo a porta 8080 para uso
EXPOSE 8080

# Copiando o meu jar gerado pelo maven para o container ja o renomeando para "app.jar"
COPY --from=build /target/rest.api-0.0.1-SNAPSHOT.jar app.jar

# Executando o jar
ENTRYPOINT ["java", "-jar", "app.jar"]