package com.iamsajan.VirtualPowerPlantSystem.battery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    /**
     * Retrieves a list of Battery entities whose postcodes fall within the specified range, inclusive.
     * The batteries are sorted alphabetically by their names.
     *
     * @param startPostCode the starting postcode of the range (inclusive)
     * @param endPostCode   the ending postcode of the range (inclusive)
     * @return a list of Battery entities sorted by name within the specified postcode range
     */
    public List<Battery> getBatteriesInRange(String startPostCode, String endPostCode) {
        return batteryRepository.findByPostCodeBetween(startPostCode, endPostCode).stream()
                .sorted(Comparator.comparing(Battery::getName))
                .toList();
    }

    /**
     * Calculates the total watt capacity of a list of Battery entities.
     *
     * @param batteries the list of Battery entities
     * @return the total watt capacity of the batteries
     */
    public int getTotalWattCapacity(List<Battery> batteries) {
        return batteries.stream().mapToInt(Battery::getCapacity).sum();
    }

    /**
     * Calculates the average watt capacity of a list of Battery entities.
     *
     * @param batteries the list of Battery entities
     * @return the average watt capacity of the batteries, or 0 if the list is empty
     */
    public double getAverageWattCapacity(List<Battery> batteries) {
        return batteries.stream().mapToInt(Battery::getCapacity).average().orElse(0);
    }
}
