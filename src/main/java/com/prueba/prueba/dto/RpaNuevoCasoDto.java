package com.prueba.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RpaNuevoCasoDto {

    @JsonProperty("documento_afiliado")
    private String documento_afiliado;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("estado")
    private String estado;

    public RpaNuevoCasoDto() {
    }

    public RpaNuevoCasoDto(String documento_afiliado, String descripcion, String estado) {
        this.documento_afiliado = documento_afiliado;
        this.descripcion = descripcion;
        this.estado = estado;
    }

}
