Prueba Técnica - Backend
Descripción
Este proyecto implementa un servicio REST para consultar información básica de un cliente. La aplicación utiliza Spring Boot y Maven como tecnologías principales y proporciona datos mockeados en su respuesta.

Requisitos
El servicio debe manejar códigos HTTP en sus respuestas:

200 OK: Respuesta exitosa.
400 Bad Request: Parámetros de entrada incorrectos.
404 Not Found: Cliente no encontrado.
500 Internal Server Error: Error interno en el servidor.
Los datos de entrada obligatorios son:

Tipo de documento:
C (Cédula de ciudadanía).
P (Pasaporte).
Número de documento.
El servicio retorna los siguientes datos mockeados:

Primer nombre
Segundo nombre
Primer apellido
Segundo apellido
Teléfono
Dirección
Ciudad de residencia
La aplicación debe iniciar en el puerto 8090.

Ejecución de la Aplicación
Prerrequisitos
Java 17+
Maven 3+
Pasos para ejecutar
Clonar el repositorio:

bash
Copiar código
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_PROYECTO>
Compilar y empaquetar la aplicación:

bash
Copiar código
mvn clean package
Ejecutar el JAR:

bash
Copiar código
java -jar target/<NOMBRE_DEL_JAR>.jar
La aplicación estará disponible en:

arduino
Copiar código
http://localhost:8090
Endpoints del Servicio
Método	URL	Descripción	Parámetros de entrada
GET	/api/v1/client	Consulta la información de un cliente	tipoDocumento (C/P), numeroDocumento
Ejemplo de Request:
http
Copiar código
GET /api/v1/client?tipoDocumento=C&numeroDocumento=23445322
Ejemplo de Respuesta Exitosa (200):
json
Copiar código
{
  "primerNombre": "Juan",
  "segundoNombre": "Carlos",
  "primerApellido": "Pérez",
  "segundoApellido": "Gómez",
  "telefono": "3101234567",
  "direccion": "Calle 123 # 45-67",
  "ciudadResidencia": "Medellín"
}
Pruebas
El proyecto incluye pruebas unitarias utilizando JUnit. Para ejecutar las pruebas, ejecuta el siguiente comando:

bash
Copiar código
mvn test
Notas
La respuesta está mockeada solo para el cliente con Cédula de Ciudadanía 23445322.
La aplicación incluye manejo de logs, pruebas unitarias y código estructurado para garantizar la calidad.
Tecnologías Utilizadas
Java 17
Spring Boot
Maven
JUnit
Entregables
JAR de la aplicación.
Código fuente del proyecto.
