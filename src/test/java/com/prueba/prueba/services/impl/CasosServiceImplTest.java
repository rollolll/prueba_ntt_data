package com.prueba.prueba.services.impl;

import com.prueba.prueba.dummyMock.Dummy;
import com.prueba.prueba.repository.IAfiliadosRepository;
import com.prueba.prueba.repository.ICasosRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    
}








