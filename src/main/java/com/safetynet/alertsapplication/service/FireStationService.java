package com.safetynet.alertsapplication.service;

import com.safetynet.alertsapplication.exception.FireStationNotFoundException;
import com.safetynet.alertsapplication.model.FireStation;

import java.util.Optional;

public interface FireStationService {
    FireStation saveFireStation(FireStation fireStation);

    FireStation updateFireStation(String address, FireStation fireStation) throws FireStationNotFoundException;

    void deleteFireStation(String address);

    Optional<FireStation> getFireStation(String address);
}
