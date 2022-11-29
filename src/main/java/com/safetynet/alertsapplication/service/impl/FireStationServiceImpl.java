package com.safetynet.alertsapplication.service.impl;

import com.safetynet.alertsapplication.exception.FireStationNotFoundException;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.repository.FireStationRepository;
import com.safetynet.alertsapplication.service.FireStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public Optional<FireStation> getFireStation(final String address){
        return fireStationRepository.findStationNumberByAddress(address);
    }

    @Override
    public List<FireStation> getAllFireStations() throws IOException {
        return fireStationRepository.getAllFireStations();
    }

    @Override
    public FireStation saveFireStation(FireStation fireStation) {
        return fireStationRepository.saveFireStation(fireStation);
    }

    @Override
    public FireStation updateFireStation(String address, FireStation fireStation) throws FireStationNotFoundException {
        final var currentFireStation = getFireStation(address)
                .orElseThrow(() -> new FireStationNotFoundException());

        final FireStation updatedFireStation = currentFireStation.update(fireStation);

        return fireStationRepository.saveFireStation(updatedFireStation);
    }

    @Override
    public void deleteFireStation(String address) {
        fireStationRepository.deleteByAddress(address);
    }




}
