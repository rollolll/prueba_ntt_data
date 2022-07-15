package com.prueba.prueba.services;

import com.prueba.prueba.dto.AfiliadosDto;
import com.prueba.prueba.dto.RpaNuevoAfiliadoDto;

import java.util.List;

public interface IAfiliadosService {

    List<AfiliadosDto> consultarTodosAfiliados();

    List<AfiliadosDto> consultarAfiliadoPorDocumento(String documento);

    String crearAfiliado(RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto);

    String actualizarAfiliado(RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto);

    String eliminarAfiliado(String documento);


}
