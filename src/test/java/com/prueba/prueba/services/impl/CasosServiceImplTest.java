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


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class CasosServiceImplTest {

    @InjectMocks
    private CasosServiceImpl casosServiceImpl;

    @Mock
    private IAfiliadosRepository iAfiliadosRepository;
    @Mock
    private ICasosRepository iCasosRepository;

    private Dummy dummy = new Dummy();


    @Test
    void crearCaso() {
        Mockito.when(iCasosRepository.consultarCasoPorAfiliadoExistente(dummy.rpaNuevoCasoDto().getDocumento_afiliado())).thenReturn(0);
        Mockito.when(iAfiliadosRepository.consultarDocumentoExistente(dummy.rpaNuevoCasoDto().getDocumento_afiliado())).thenReturn(1);
        Mockito.when(iCasosRepository.crearCaso(dummy.rpaNuevoCasoDto().getDocumento_afiliado(),
                dummy.rpaNuevoCasoDto().getDescripcion(),dummy.rpaNuevoCasoDto().getEstado())).thenReturn("Afiliado creado");
        String Respuesta = casosServiceImpl.crearCaso(dummy.rpaNuevoCasoDto());
        Assert.assertEquals("Caso creado correctamente", Respuesta);
    }


    @Test
    void crearCasoFail() {
        Mockito.when(iCasosRepository.consultarCasoPorAfiliadoExistente(dummy.rpaNuevoCasoDto().getDocumento_afiliado())).thenReturn(1);
        Mockito.when(iAfiliadosRepository.consultarDocumentoExistente(dummy.rpaNuevoCasoDto().getDocumento_afiliado())).thenReturn(1);
        String Respuesta = casosServiceImpl.crearCaso(dummy.rpaNuevoCasoDto());
        Assert.assertEquals("El afiliado ya tiene un caso registrado", Respuesta);
    }

    @Test
    void crearCasoFail2() {
        Mockito.when(iCasosRepository.consultarCasoPorAfiliadoExistente(dummy.rpaNuevoCasoDto().getDocumento_afiliado())).thenReturn(0);
        Mockito.when(iAfiliadosRepository.consultarDocumentoExistente(dummy.rpaNuevoCasoDto().getDocumento_afiliado())).thenReturn(0);
        String Respuesta = casosServiceImpl.crearCaso(dummy.rpaNuevoCasoDto());
        Assert.assertEquals("No se puede crear el caso, el afiliado no existe", Respuesta);
    }
    
}








