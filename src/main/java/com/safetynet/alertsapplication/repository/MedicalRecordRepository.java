package com.safetynet.alertsapplication.repository;


import com.safetynet.alertsapplication.model.MedicalRecord;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MedicalRecordRepository {
    Optional<MedicalRecord> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteByFirstNameAndLastName(String firstName, String lastName);

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);

    List<MedicalRecord> getAllMedicalRecords() throws IOException;
}
