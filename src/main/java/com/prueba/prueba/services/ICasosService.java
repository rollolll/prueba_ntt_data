package com.prueba.prueba.services;

import com.prueba.prueba.dto.CasosDto;
import com.prueba.prueba.dto.RpaNuevoCasoDto;

import java.util.List;

public interface ICasosService {

    List<CasosDto> consultarTodosCasos();

    List<CasosDto> consultarCasoPorDocumentoAfiliado(String documento);

    String crearCaso(RpaNuevoCasoDto rpaNuevoCasoDto);

    String actualizarCaso(RpaNuevoCasoDto rpaNuevoCasoDto);

    String eliminarCaso(String documento);

}
