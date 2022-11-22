package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.repository.FireStationRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FireStationRepositoryImpl implements FireStationRepository {

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

}
