package com.api.crud.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @GetMapping("/info")
    public ResponseEntity<?> getClientInfo(
            @RequestParam("type") String documentType,
            @RequestParam("number") String documentNumber) {

        // Validar tipo de documento
        if (!documentType.equals("C") && !documentType.equals("P")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Tipo de documento inválido. Debe ser 'C' o 'P'.");
        }

        // Datos mockeados para cédula 23445322
        if (documentNumber.equals("23445322")) {
            Map<String, String> clientInfo = new HashMap<>();
            clientInfo.put("primerNombre", "Juan");
            clientInfo.put("segundoNombre", "Carlos");
            clientInfo.put("primerApellido", "Perez");
            clientInfo.put("segundoApellido", "Gomez");
            clientInfo.put("telefono", "3001234567");
            clientInfo.put("direccion", "Calle Falsa 123");
            clientInfo.put("ciudadResidencia", "Bogotá");

            return ResponseEntity.ok(clientInfo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado.");
        }
    }


    @GetMapping("/download-json")
    public ResponseEntity<ByteArrayResource> downloadJsonFile() {
        // URL pública del archivo JSON en Google Cloud Storage
        String fileUrl = "https://storage.googleapis.com/nttapp-bucket-112233/clientes.json";

        try {
            RestTemplate restTemplate = new RestTemplate();
            byte[] fileBytes = restTemplate.getForObject(fileUrl, byte[].class);

            // Configurar encabezados para forzar la descarga del archivo
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=clientes.json");

            // Devolver el archivo como recurso
            ByteArrayResource resource = new ByteArrayResource(fileBytes);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileBytes.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno del servidor.");
    }


}
