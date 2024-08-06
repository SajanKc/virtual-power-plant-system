package com.iamsajan.VirtualPowerPlantSystem.battery;

import com.iamsajan.VirtualPowerPlantSystem.dto.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        BaseResponseDto response = new BaseResponseDto("200", HttpStatus.CREATED, "Batteries added successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
