package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.dao.impl.DataStorageImpl;
import com.safetynet.alertsapplication.exception.FireStationNotFoundException;
import com.safetynet.alertsapplication.model.FireStation;

import com.safetynet.alertsapplication.repository.FireStationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class FireStationRepositoryImpl implements FireStationRepository {

    private final DataStorageImpl dataStorageImpl;

    public FireStationRepositoryImpl(DataStorageImpl dataStorageImpl) {
        this.dataStorageImpl = dataStorageImpl;
    }


    @Override
    public Optional<FireStation> findStationNumberByAddress(String address) {

        return getAllFireStation() // List<FireStation>
                .stream()// Stream <FireStation>
                .filter(allFireStations -> allFireStations.getAddress().equals(address)) // return ONLY firstation with getAddress = address => Stream <FireStation> with getAddress = address
                .findFirst();

//        List<FireStation> allFireStationList = getAllFireStation();
//        for (FireStation fireStation : allFireStationList) {
//            if (fireStation.getAddress().equals(address) ){
//                return fireStation;
//            }
//        }
//        return null;
    }

    @Override
    public void deleteFireStationByAddress(String address) {
        findStationNumberByAddress(address).ifPresent(f -> removeFireStation(f));

/*        List<FireStation> allFireStationList = getAllFireStation();
        FireStation existingFireStation = findStationNumberByAddress(address);
        if (existingFireStation != null){
            allFireStationList.remove(existingFireStation);
        }*/

    }

    @Override
    public FireStation saveFireStation(FireStation fireStation) {

        if (findStationNumberByAddress(fireStation.getAddress()).isPresent()) {
            throw new IllegalArgumentException("FireStation exists");
        }

        getAllFireStation().add(fireStation);

        return fireStation;
    }

    @Override
    public void updateFireStation(FireStation updatedFireStation) throws FireStationNotFoundException {
        var existingStation = findStationNumberByAddress(updatedFireStation.getAddress())
                .orElseThrow(() -> new FireStationNotFoundException());

        var index = getAllFireStation().indexOf(existingStation);
        getAllFireStation().add(index, updatedFireStation);
    }

    @Override
    public List<FireStation> getAllFireStation() {
        return dataStorageImpl.getData().getFirestations();
    }

    private void removeFireStation(FireStation fireStation) {
        dataStorageImpl.getData().getFirestations().remove(fireStation);
    }

    @Override
    public Stream<FireStation> getAllFireStationByStationNumber(String number) {
        return dataStorageImpl
                .getFireStations()
                .stream()
                .filter(f -> f.getStation().equals(number));
    }

    @Override
    public Stream<FireStation> getAllFireStationByAddress(String address) {
        return dataStorageImpl
                .getFireStations()
                .stream()
                .filter(f -> f.getAddress().equals(address));
    }
    @Override
    public Stream<FireStation> getAllFireStationByStationNumberList(List<String> fireStationNumbers) {
        return dataStorageImpl
                .getFireStations()
                .stream()
                .filter(f -> fireStationNumbers.contains(f.getStation()));
    }
}
