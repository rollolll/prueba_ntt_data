package com.prueba.prueba.controller;


import com.prueba.prueba.dto.*;
import com.prueba.prueba.services.IAfiliadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/afiliados")
public class AfiliadosController {

    private IAfiliadosService iAfiliadosService;

    @Autowired
    public AfiliadosController(IAfiliadosService iAfiliadosService) {
        this.iAfiliadosService = iAfiliadosService;
    }



}
