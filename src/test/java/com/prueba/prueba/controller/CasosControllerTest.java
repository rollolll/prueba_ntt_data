package com.prueba.prueba.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
class CasosControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CasosController casosController;

    @Test
    public void consultarTodosCasos() throws Exception {
        mockMvc.perform(get("/casos/todosCasos")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void casoPorDocumentoAfiliado() throws Exception {
        String Json = "{\"documento_afiliado\":112233}";
        mockMvc.perform(post("/casos/casoPorDocumentoAfiliado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void casoPorDocumentoAfiliadoFail() throws Exception {
        String Json = "{\"documento\":\"\"}";
        mockMvc.perform(post("/casos/casoPorDocumentoAfiliado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void crearCaso() throws Exception {
        String Json = "{\"documento_afiliado\":\"12345\",\"descripcion\":\"DEMANDA POR ALOJAMIENTO\",\"estado\":\"estado\"}";
        mockMvc.perform(post("/casos/crearCaso")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void crearCasoFail() throws Exception {
        String Json = "{\"documento_afiliado\":\"12345\",\"descripcion\":\"\",\"estado\":\"estado\"}";
        mockMvc.perform(post("/casos/crearCaso")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void actualizarCaso() throws Exception {
        String Json = "{\"documento_afiliado\":\"12345\",\"descripcion\":\"DEMANDA POR ALOJAMIENTO\",\"estado\":\"estado\"}";
        mockMvc.perform(post("/casos/actualizarCaso")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }


}





