package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.dao.DataStorage;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.repository.FireStationRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FireStationRepositoryImpl implements FireStationRepository {

    private final DataStorage dataStorage;

    public FireStationRepositoryImpl(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }


    @Override
    public Optional<FireStation> findStationNumberByAddress(String address){
    return Optional.empty();
    }

    @Override
    public void deleteByAddress(String address){
    }

    @Override
    public FireStation saveFireStation(FireStation fireStation){
        return null;
    }

    @Override
    public List<FireStation> getAllFireStations() throws IOException {
       return  dataStorage.getFireStations();
    }

}
