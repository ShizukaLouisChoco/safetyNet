package com.safetynet.alertsapplication.repository;

import com.safetynet.alertsapplication.model.FireStation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FireStationRepository {
    Optional<FireStation> findStationNumberByAddress(String address);

    void deleteByAddress(String address);

    FireStation saveFireStation(FireStation fireStation);

    List<FireStation> getAllFireStations() throws IOException;
}
