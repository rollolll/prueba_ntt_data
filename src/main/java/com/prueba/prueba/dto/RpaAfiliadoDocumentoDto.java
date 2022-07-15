package com.prueba.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RpaAfiliadoDocumentoDto {
    @JsonProperty("documento")
    private String documento;

    public RpaAfiliadoDocumentoDto() {
    }

    public RpaAfiliadoDocumentoDto(String documento) {
        this.documento = documento;
    }
}
