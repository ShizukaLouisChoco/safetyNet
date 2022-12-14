package com.safetynet.alertsapplication.service.impl;

import com.safetynet.alertsapplication.exception.FireStationNotFoundException;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.repository.FireStationRepository;
import com.safetynet.alertsapplication.service.FireStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FireStationServiceImpl implements FireStationService {

    //log.info("FireStationServiceImpl");
    private final FireStationRepository fireStationRepository;


    public FireStationServiceImpl(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    @Override
    public Optional<FireStation> findFireStationByAddress(final String address)  {
        return fireStationRepository.findStationNumberByAddress(address);
    }

    @Override
    public List<FireStation> getAllFireStations()  {
        return fireStationRepository.getAllFireStation();
    }

    @Override
    public FireStation saveFireStation(FireStation fireStation) {
        return fireStationRepository.saveFireStation(fireStation);
    }

    @Override
    public FireStation updateFireStation(String address, FireStation fireStation) throws FireStationNotFoundException {
        final var currentFireStation = findFireStationByAddress(address)
                .orElseThrow(() -> new FireStationNotFoundException());

        final FireStation updatedFireStation = currentFireStation.update(fireStation);

        fireStationRepository.updateFireStation(updatedFireStation);
        return updatedFireStation;
    }

    @Override
    public void deleteFireStation(String address) {
        fireStationRepository.deleteFireStationByAddress(address);
    }




}
