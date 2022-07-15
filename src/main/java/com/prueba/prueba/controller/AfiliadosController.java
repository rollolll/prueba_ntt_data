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

    //Consultar todos los afiliados
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/todosAfiliados")
    public ResponseEntity<GenericDto> consultarTodosAfiliados() {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iAfiliadosService.consultarTodosAfiliados()));
    }

    //Consultar afiliado por documento
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/afiliadoPorDocumento")
    public ResponseEntity<GenericDto> afiliadoPorDocumento(@RequestBody RpaAfiliadoDocumentoDto rpaAfiliadoDocumentoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iAfiliadosService.consultarAfiliadoPorDocumento(rpaAfiliadoDocumentoDto.getDocumento())));
    }

    //Crear afiliado
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/crearAfiliado")
    public ResponseEntity<GenericDto> crearAfiliado(@RequestBody RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iAfiliadosService.crearAfiliado(rpaNuevoAfiliadoDto)));
    }

    //Actualizar afiliado
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/actualizarAfiliado")
    public ResponseEntity<GenericDto> actualizarAfiliado(@RequestBody RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iAfiliadosService.actualizarAfiliado(rpaNuevoAfiliadoDto)));
    }

    //Eliminar afiliado
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/eliminarAfiliado")
    public ResponseEntity<GenericDto> eliminarAfiliado(@RequestBody RpaAfiliadoDocumentoDto rpaAfiliadoDocumentoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iAfiliadosService.eliminarAfiliado(rpaAfiliadoDocumentoDto.getDocumento())));
    }


}
