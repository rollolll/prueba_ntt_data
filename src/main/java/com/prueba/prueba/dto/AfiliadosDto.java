package com.prueba.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AfiliadosDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("documento")
    private String documento;

    public AfiliadosDto() {}

    public AfiliadosDto(Integer id, String nombre, String apellido, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

}
