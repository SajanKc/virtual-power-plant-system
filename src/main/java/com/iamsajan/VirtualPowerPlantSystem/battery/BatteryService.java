package com.iamsajan.VirtualPowerPlantSystem.battery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryService {

    private final BatteryRepository batteryRepository;

    /**
     * Saves a list of Battery entities to the repository.
     *
     * @param batteries the list of Battery entities to be saved
     */
    public void saveAllBatteries(List<Battery> batteries) {
        batteryRepository.saveAll(batteries);
    }
}
