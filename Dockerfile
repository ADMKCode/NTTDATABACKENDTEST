# Imagen base de OpenJDK (versión 17)
FROM openjdk:17-jdk-slim

# Copia tu archivo JAR dentro del contenedor
COPY target/nttAppBackEnd.jar app.jar

# Expone el puerto 8080 (o el que use tu aplicación)
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT:8090}"]
