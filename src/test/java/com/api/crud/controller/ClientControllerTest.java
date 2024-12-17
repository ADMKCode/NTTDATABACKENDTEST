package com.api.crud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetClientInfo_Success() throws Exception {
        mockMvc.perform(get("/api/client/info")
                        .param("type", "C")
                        .param("number", "23445322"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.primerNombre").value("Juan"));
    }

    @Test
    public void testGetClientInfo_NotFound() throws Exception {
        mockMvc.perform(get("/api/client/info")
                        .param("type", "C")
                        .param("number", "12345678"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetClientInfo_BadRequest() throws Exception {
        mockMvc.perform(get("/api/client/info")
                        .param("type", "X")
                        .param("number", "23445322"))
                .andExpect(status().isBadRequest());
    }
}