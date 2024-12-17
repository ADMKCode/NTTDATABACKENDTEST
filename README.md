# Prueba Técnica - Backend

## Descripción
Este proyecto implementa un servicio **REST** para consultar información básica de un cliente.  
La aplicación utiliza **Spring Boot** y **Maven** como tecnologías principales y proporciona datos **mockeados** en su respuesta.

---

## Requisitos

1. **Manejo de códigos HTTP en las respuestas**:
   - **200 OK**: Respuesta exitosa.
   - **400 Bad Request**: Parámetros de entrada incorrectos.
   - **404 Not Found**: Cliente no encontrado.
   - **500 Internal Server Error**: Error interno en el servidor.

2. **Parámetros de entrada obligatorios**:
   - **Tipo de documento**:
     - `C`: Cédula de ciudadanía.
     - `P`: Pasaporte.
   - **Número de documento**.

3. **Datos de respuesta (mockeados)**:
   - Primer nombre
   - Segundo nombre
   - Primer apellido
   - Segundo apellido
   - Teléfono
   - Dirección
   - Ciudad de residencia

4. **Puerto**: La aplicación debe correr en el puerto **8090**.

---

## Ejecución de la Aplicación

### Prerrequisitos
- **Java 17+**
- **Maven 3+**

### Pasos para ejecutar

1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
