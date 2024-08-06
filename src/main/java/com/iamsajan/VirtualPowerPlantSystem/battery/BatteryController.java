package com.iamsajan.VirtualPowerPlantSystem.battery;

import com.iamsajan.VirtualPowerPlantSystem.battery.dto.BatteriesResponseDto;
import com.iamsajan.VirtualPowerPlantSystem.dto.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battery")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;

    /**
     * Endpoint to add a list of batteries.
     *
     * @param batteries the list of Battery entities to be saved
     * @return ResponseEntity containing the response code, status, and message
     */
    @PostMapping("/save-all")
    public ResponseEntity<BaseResponseDto> saveAllBatteries(@RequestBody List<Battery> batteries) {
        batteryService.saveAllBatteries(batteries);
        BaseResponseDto response = BaseResponseDto.builder()
                .code("200")
                .status(HttpStatus.CREATED)
                .message("Batteries added successfully.")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Endpoint to get a list of battery names within a given postcode range, along with their total and average watt capacity.
     *
     * @param startPostCode the starting postcode of the range
     * @param endPostCode   the ending postcode of the range
     * @return ResponseEntity containing the list of battery names sorted, total watt capacity, and average watt capacity
     */
    @GetMapping("/get-in-range")
    public ResponseEntity<BatteriesResponseDto> getBatteriesInRange(@RequestParam String startPostCode,
                                                                    @RequestParam String endPostCode) {
        List<Battery> batteryList = batteryService.getBatteriesInRange(startPostCode, endPostCode);

        List<String> batteryNames = batteryList.stream().map(Battery::getName).toList();
        int totalWattCapacity = batteryService.getTotalWattCapacity(batteryList);
        double averageWattCapacity = batteryService.getAverageWattCapacity(batteryList);

        BatteriesResponseDto batteriesResponseDto = BatteriesResponseDto.builder()
                .code("200")
                .status(HttpStatus.OK)
                .message("Batteries retrieved successfully")
                .batteryNames(batteryNames)
                .totalWattCapacity(totalWattCapacity)
                .averageWattCapacity(averageWattCapacity)
                .build();

        return ResponseEntity.ok(batteriesResponseDto);
    }
}
