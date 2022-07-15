package com.prueba.prueba.controller;

import com.prueba.prueba.dto.GenericDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class AfiliadosControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AfiliadosController afiliadosController;

    @Test
    public void consultarTodosAfiliados() throws Exception {
        mockMvc.perform(get("/afiliados/todosAfiliados")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void afiliadoPorDocumento() throws Exception {
        String Json = "{\"documento\":112233}";
        mockMvc.perform(post("/afiliados/afiliadoPorDocumento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void afiliadoPorDocumentoFail() throws Exception {
        String Json = "{\"documento\":\"\"}";
        mockMvc.perform(post("/afiliados/afiliadoPorDocumento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void crearAfiliado() throws Exception {
        String Json = "{\"nombre\":\"Agustin\",\"apellido\":\"Garcia\",\"documento\":\"112233\"}";
        mockMvc.perform(post("/afiliados/crearAfiliado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void crearAfiliadoFail() throws Exception {
        String Json = "{\"nombre\":\"\",\"apellido\":\"Garcia\",\"documento\":\"\"}";
        mockMvc.perform(post("/afiliados/crearAfiliado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void actualizarAfiliado() throws Exception {
        String Json = "{\"nombre\":\"Agustin\",\"apellido\":\"Garcia\",\"documento\":\"112233\"}";
        mockMvc.perform(post("/afiliados/actualizarAfiliado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }


}





