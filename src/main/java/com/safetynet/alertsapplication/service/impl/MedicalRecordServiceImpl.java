package com.safetynet.alertsapplication.service.impl;

import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.repository.MedicalRecordRepository;
import com.safetynet.alertsapplication.service.MedicalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Optional<MedicalRecord> findMedicalRecordByFirstNameAndLastName(final String firstName, final String lastName) {
        return medicalRecordRepository.findMedicalRecordByFirstNameAndLastName(firstName,lastName);
    }
    @Override
    public List<MedicalRecord> getAllMedicalRecords(){
        return medicalRecordRepository.getAllMedicalRecords();
    }

    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord)  {
        return medicalRecordRepository.saveMedicalRecord(medicalRecord);
    }
    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord)throws MedicalRecordNotFoundException {
        final var currentMedicalRecord = findMedicalRecordByFirstNameAndLastName(medicalRecord.getFirstName(), medicalRecord.getLastName())
                .orElseThrow(()-> new MedicalRecordNotFoundException());
        final MedicalRecord updatedMedicalRecord = currentMedicalRecord.update(medicalRecord);

        medicalRecordRepository.updateMedicalRecord(updatedMedicalRecord);
        return updatedMedicalRecord;
    }


    @Override
    public void deleteMedicalRecordByFirstNameAndLastName(String firstName, String lastName) {
    medicalRecordRepository.deleteMedicalRecordByFirstNameAndLastName(firstName,lastName);
    }

}
