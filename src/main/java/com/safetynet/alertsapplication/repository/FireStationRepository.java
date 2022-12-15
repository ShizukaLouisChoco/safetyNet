package com.safetynet.alertsapplication.repository;

import com.safetynet.alertsapplication.model.FireStation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
public interface FireStationRepository {
    Optional<FireStation> findStationNumberByAddress(String address);

    void deleteFireStationByAddress(String address);

    void updateFireStation(FireStation fireStation);

    FireStation saveFireStation(FireStation fireStation);

    List<FireStation> getAllFireStation();

    Stream<FireStation> getAllFireStationByStationNumber(String number);
    Stream<FireStation> getAllFireStationByAddress(String a);

    Stream<FireStation> getAllFireStationByStationNumberList(List<String> fireStationNumbers);
}
