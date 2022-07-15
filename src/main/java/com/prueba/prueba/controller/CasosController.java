package com.prueba.prueba.controller;


import com.prueba.prueba.dto.GenericDto;
import com.prueba.prueba.dto.RpaCasoByDocumentoDto;
import com.prueba.prueba.dto.RpaNuevoCasoDto;
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

    //Consultar todos los casos
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/todosCasos")
    public ResponseEntity<GenericDto> consultarTodosCasos() {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iCasosService.consultarTodosCasos()));
    }

    //Consultar caso por documento afiliado
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/casoPorDocumentoAfiliado")
    public ResponseEntity<GenericDto> casoPorDocumentoAfiliado(@RequestBody RpaCasoByDocumentoDto rpaCasoByDocumentoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iCasosService.consultarCasoPorDocumentoAfiliado(rpaCasoByDocumentoDto.getDocumento_afiliado())));
    }

    //Crear caso
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/crearCaso")
    public ResponseEntity<GenericDto> crearCaso(@RequestBody RpaNuevoCasoDto rpaNuevoCasoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iCasosService.crearCaso(rpaNuevoCasoDto)));
    }

    //Actualizar caso
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/actualizarCaso")
    public ResponseEntity<GenericDto> actualizarCaso(@RequestBody RpaNuevoCasoDto rpaNuevoCasoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iCasosService.actualizarCaso(rpaNuevoCasoDto)));
    }

    //Eliminar caso
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/eliminarCaso")
    public ResponseEntity<GenericDto> eliminarCaso(@RequestBody RpaNuevoCasoDto rpaNuevoCasoDto) {
        return ResponseEntity.ok().body( GenericDto.sucess(this.iCasosService.eliminarCaso(rpaNuevoCasoDto.getDocumento_afiliado())));
    }


}
