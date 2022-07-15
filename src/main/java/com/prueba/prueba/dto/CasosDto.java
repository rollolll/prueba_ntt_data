package com.prueba.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CasosDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("documento_afiliado")
    private String documento_afiliado;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("estado")
    private String estado;


    public CasosDto() {}

    public CasosDto(Integer id, String documento_afiliado, String descripcion, String estado) {
        this.id = id;
        this.documento_afiliado = documento_afiliado;
        this.descripcion = descripcion;
        this.estado = estado;
    }

}
