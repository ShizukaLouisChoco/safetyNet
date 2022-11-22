package com.safetynet.alertsapplication.service.impl;

import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.repository.MedicalRecordRepository;
import com.safetynet.alertsapplication.service.MedicalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    //log.info("MedicalRecordServiceImpl");

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public Optional<MedicalRecord> getMedicalRecord(final String firstName, final String lastName) {
        return medicalRecordRepository.findByFirstNameAndLastName(firstName,lastName);
    }


    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.saveMedicalRecord(medicalRecord);
    }

    @Override
    public MedicalRecord updateMedicalRecord(String firstName, String lastName, MedicalRecord medicalRecord) throws MedicalRecordNotFoundException {
        //String msg = "No medical record with that name exists";
        final var currentMedicalRecord = getMedicalRecord(firstName, lastName)
                .orElseThrow(() -> new MedicalRecordNotFoundException());

        final var updatedMedicalRecord = currentMedicalRecord.update(medicalRecord);

        return medicalRecordRepository.saveMedicalRecord(updatedMedicalRecord);
    }

    @Override
    public void deleteMedicalRecord(String firstName, String lastName) {
        medicalRecordRepository.deleteByFirstNameAndLastName(firstName,lastName);

    }

}
