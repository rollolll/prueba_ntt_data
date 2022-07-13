package com.prueba.prueba.controller;


import com.prueba.prueba.dto.GenericDto;
import com.prueba.prueba.services.ICasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casos")
public class CasosController {

    private ICasosService iCasosService;

    @Autowired
    public CasosController(ICasosService iCasosService) {
        this.iCasosService = iCasosService;
    }



}
