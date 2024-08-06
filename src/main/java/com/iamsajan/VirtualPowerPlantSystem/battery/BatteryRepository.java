package com.iamsajan.VirtualPowerPlantSystem.battery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
    List<Battery> findByPostCodeBetween(String startPostcode, String endPostcode);
}
