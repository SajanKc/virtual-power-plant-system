package com.iamsajan.VirtualPowerPlantSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BaseResponseDto {
    private String code;
    private HttpStatus status;
    private String message;
}
