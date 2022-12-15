package com.safetynet.alertsapplication.service;

import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;

import java.util.List;
import java.util.Optional;

public interface MedicalRecordService {

    Optional<MedicalRecord> findMedicalRecordByFirstNameAndLastName(String firstName, String lastName);

    List<MedicalRecord> getAllMedicalRecords();

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);

    MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) throws MedicalRecordNotFoundException;

    void deleteMedicalRecordByFirstNameAndLastName(String firstName, String lastName);
}
