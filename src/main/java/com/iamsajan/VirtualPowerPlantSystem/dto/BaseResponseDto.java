package com.iamsajan.VirtualPowerPlantSystem.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
public class BaseResponseDto {

    private String code;
    private HttpStatus status;
    private String message;

}
