package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.repository.MedicalRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {
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
}
