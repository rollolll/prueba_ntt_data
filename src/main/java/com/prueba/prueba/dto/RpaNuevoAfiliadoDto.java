package com.prueba.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RpaNuevoAfiliadoDto {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("documento")
    private String documento;

    public RpaNuevoAfiliadoDto() {
    }

    public RpaNuevoAfiliadoDto(String nombre, String apellido, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }


}
