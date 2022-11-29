package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.dao.DataStorage;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.repository.MedicalRecordRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {

    private final DataStorage dataStorage;

    public MedicalRecordRepositoryImpl(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }


    @Override
    public Optional<MedicalRecord> findByFirstNameAndLastName(String firstName, String lastName) {
        return Optional.empty();
    }

    @Override
    public void deleteByFirstNameAndLastName(String firstName, String lastName) {

    }

    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return null;
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecords() throws IOException {

        return dataStorage.getMedicalRecords();

    }
}
