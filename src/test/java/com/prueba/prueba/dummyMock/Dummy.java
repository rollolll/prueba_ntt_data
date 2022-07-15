package com.prueba.prueba.dummyMock;

import com.prueba.prueba.dto.*;

public class Dummy {

    public RpaCasoByDocumentoDto rpaCasoByDocumentoDto() {
        RpaCasoByDocumentoDto rpaCasoByDocumentoDto = new RpaCasoByDocumentoDto();
        rpaCasoByDocumentoDto.setDocumento_afiliado("12345");
        return rpaCasoByDocumentoDto;
    }

    public RpaAfiliadoDocumentoDto rpaAfiliadoDocumentoDto() {
        RpaAfiliadoDocumentoDto rpaAfiliadoDocumentoDto = new RpaAfiliadoDocumentoDto();
        rpaAfiliadoDocumentoDto.setDocumento("678910");
        return rpaAfiliadoDocumentoDto;
    }

    public RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto() {
        RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto = new RpaNuevoAfiliadoDto();
        rpaNuevoAfiliadoDto.setNombre("Juan");
        rpaNuevoAfiliadoDto.setApellido("Pelaes");
        rpaNuevoAfiliadoDto.setDocumento("998877");
        return rpaNuevoAfiliadoDto;
    }

    public RpaNuevoCasoDto rpaNuevoCasoDto() {
        RpaNuevoCasoDto rpaNuevoCasoDto = new RpaNuevoCasoDto();
        rpaNuevoCasoDto.setDocumento_afiliado("998877");
        rpaNuevoCasoDto.setDescripcion("Descripcion del caso 1");
        rpaNuevoCasoDto.setEstado("ABIERTO");
        return rpaNuevoCasoDto;
    }

    public AfiliadosDto afiliadosDto() {
        AfiliadosDto afiliadosDto = new AfiliadosDto();
        afiliadosDto.setId(1);
        afiliadosDto.setNombre("Mario");
        afiliadosDto.setApellido("Garcia");
        afiliadosDto.setDocumento("9267483");
        return afiliadosDto;
    }

    public CasosDto casosDto() {
        CasosDto casosDto = new CasosDto();
        casosDto.setId(1);
        casosDto.setDocumento_afiliado("9267483");
        casosDto.setDescripcion("Descripcion del caso 1");
        casosDto.setEstado("ABIERTO");
        return casosDto;
    }

}
