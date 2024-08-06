package com.iamsajan.VirtualPowerPlantSystem.battery.dto;

import com.iamsajan.VirtualPowerPlantSystem.dto.BaseResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder()
@EqualsAndHashCode(callSuper = true)
public class BatteriesResponseDto extends BaseResponseDto {

    private List<String> batteryNames;
    private int totalWattCapacity;
    private double averageWattCapacity;

}
