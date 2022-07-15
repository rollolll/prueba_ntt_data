package com.prueba.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RpaCasoByDocumentoDto {
    @JsonProperty("documento_afiliado")
    private String documento_afiliado;

    public RpaCasoByDocumentoDto() {
    }

    public RpaCasoByDocumentoDto(String documento_afiliado) {
        this.documento_afiliado = documento_afiliado;
    }
}
