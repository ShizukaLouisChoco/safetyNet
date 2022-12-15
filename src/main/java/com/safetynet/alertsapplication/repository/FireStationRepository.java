package com.safetynet.alertsapplication.repository;

import com.safetynet.alertsapplication.model.FireStation;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FireStationRepository {
    Optional<FireStation> findStationNumberByAddress(String address);

    void deleteFireStationByAddress(String address);

    FireStation saveFireStation(FireStation fireStation);

    List<FireStation> getAllFireStation();

    Stream<FireStation> getAllFireStationByStationNumber(String number);
    Stream<FireStation> getAllFireStationByAddress(String a);

    Stream<FireStation> getAllFireStationByStationNumberList(List<String> fireStationNumbers);
}
