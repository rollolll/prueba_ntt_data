package com.prueba.prueba.services.impl;

import com.prueba.prueba.dummyMock.Dummy;
import com.prueba.prueba.repository.IAfiliadosRepository;
import com.prueba.prueba.repository.ICasosRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class AfiliadosServiceImplTest {

    @InjectMocks
    private AfiliadosServiceImpl afiliadosServiceImpl;

    @Mock
    private IAfiliadosRepository iAfiliadosRepository;
    @Mock
    private ICasosRepository iCasosRepository;

    private Dummy dummy = new Dummy();


    @Test
    void crearAfiliado() {
        Mockito.when(iAfiliadosRepository.consultarDocumentoExistente(dummy.rpaNuevoAfiliadoDto().getDocumento())).thenReturn(0);
        Mockito.when(iAfiliadosRepository.crearAfiliado(dummy.rpaNuevoAfiliadoDto().getNombre(),
                dummy.rpaNuevoAfiliadoDto().getApellido(),dummy.rpaNuevoAfiliadoDto().getDocumento())).thenReturn("Afiliado creado");
        String Respuesta = afiliadosServiceImpl.crearAfiliado(dummy.rpaNuevoAfiliadoDto());
        Assert.assertEquals("Afiliado creado", Respuesta);
    }

    @Test
    void crearAfiliadoFail() {
        Mockito.when(iAfiliadosRepository.consultarDocumentoExistente(dummy.rpaNuevoAfiliadoDto().getDocumento())).thenReturn(1);
        String Respuesta = afiliadosServiceImpl.crearAfiliado(dummy.rpaNuevoAfiliadoDto());
        Assert.assertEquals("Ya existe un afiliado con el documento ingresado", Respuesta);
    }

}








