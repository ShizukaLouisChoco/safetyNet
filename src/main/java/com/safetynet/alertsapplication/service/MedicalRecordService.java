package com.safetynet.alertsapplication.service;

import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;

import java.util.Optional;

public interface MedicalRecordService {
    Optional<MedicalRecord> getMedicalRecord(final String firstName, final String lastName);

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);

    MedicalRecord updateMedicalRecord(String firstName, String lastName, MedicalRecord medicalRecord) throws MedicalRecordNotFoundException;

    void deleteMedicalRecord(String firstName, String lastName);
}
