package com.safetynet.alertsapplication.repository;


import com.safetynet.alertsapplication.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MedicalRecordRepository {
    Optional<MedicalRecord> findMedicalRecordByFirstNameAndLastName(String firstName, String lastName);

    void deleteMedicalRecordByFirstNameAndLastName(String firstName, String lastName) ;

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) ;

    List<MedicalRecord> getAllMedicalRecords();

    void updateMedicalRecord(MedicalRecord updatedMedicalRecord);
}
