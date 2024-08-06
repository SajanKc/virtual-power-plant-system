package com.iamsajan.VirtualPowerPlantSystem.battery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BatteryServiceTest {

    @Mock
    private BatteryRepository batteryRepository;

    @InjectMocks
    private BatteryService batteryService;

    private List<Battery> batteryList;

    @BeforeEach
    void setUp() {
        Battery battery1 = Battery.builder().name("Battery1").postCode("12345").capacity(100).build();
        Battery battery2 = Battery.builder().name("Battery2").postCode("12346").capacity(150).build();
        Battery battery3 = Battery.builder().name("Battery3").postCode("12347").capacity(200).build();
        batteryList = List.of(battery1, battery2, battery3);
    }

    @Test
    void saveAllBatteries() {
        batteryService.saveAllBatteries(batteryList);
        verify(batteryRepository, times(1)).saveAll(batteryList);
    }

    @Test
    void getBatteriesInRange() {
        Mockito.when(batteryRepository.findByPostCodeBetween("12345", "12347")).thenReturn(batteryList);

        List<Battery> batteriesInRange = batteryService.getBatteriesInRange("12345", "12347");

        assertEquals(3, batteriesInRange.size());
        assertEquals("Battery1", batteriesInRange.getFirst().getName());
        assertEquals("Battery2", batteriesInRange.get(1).getName());
        assertEquals("Battery3", batteriesInRange.getLast().getName());
    }

    @Test
    void getTotalWattCapacity() {
        int totalWattCapacity = batteryService.getTotalWattCapacity(batteryList);
        assertEquals(450, totalWattCapacity);
    }

    @Test
    void getAverageWattCapacity() {
        double averageWattCapacity = batteryService.getAverageWattCapacity(batteryList);
        assertEquals(150.0, averageWattCapacity);
    }
}