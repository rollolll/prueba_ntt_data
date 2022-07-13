package com.prueba.prueba.services.impl;

import com.prueba.prueba.repository.IAfiliadosRepository;
import com.prueba.prueba.repository.ICasosRepository;
import com.prueba.prueba.services.IAfiliadosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class AfiliadosServiceImpl implements IAfiliadosService {



    @Autowired
    public AfiliadosServiceImpl() {

    }


}
