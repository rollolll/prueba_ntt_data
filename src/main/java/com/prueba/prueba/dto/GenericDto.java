package com.prueba.prueba.dto;

import lombok.Data;

@Data
public class GenericDto {
	
	public String status;
    public Object payload;

    public static GenericDto sucess(Object message) {
        GenericDto genericDto = new GenericDto();
        genericDto.setStatus("200");
        genericDto.setPayload(message);
        return genericDto;
    }

    public static GenericDto failed(Object data) {
        GenericDto genericDto = new GenericDto();
        genericDto.setStatus("500");
        genericDto.setPayload(data);

        return genericDto;
    }

}
