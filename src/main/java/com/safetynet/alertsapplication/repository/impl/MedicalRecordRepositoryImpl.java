package com.safetynet.alertsapplication.repository.impl;
import com.safetynet.alertsapplication.dao.DataStorage;
import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.repository.MedicalRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {

    private final DataStorage dataStorage;

    public MedicalRecordRepositoryImpl(DataStorage dataStorageImpl) {
        this.dataStorage = dataStorageImpl;

    }


    @Override
    public Optional<MedicalRecord> findMedicalRecordByFirstNameAndLastName(final String firstName, final String lastName) {
        return getAllMedicalRecords()
                .stream()
                .filter(allMedicalRecords -> allMedicalRecords.getFirstName().equals(firstName) && allMedicalRecords.getLastName().equals(lastName))
                .findFirst();

    }
    @Override
    public List<MedicalRecord> getAllMedicalRecords(){
        return dataStorage.getData().getMedicalrecords();
    }

    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord)  {
        if(findMedicalRecordByFirstNameAndLastName(medicalRecord.getFirstName(),medicalRecord.getLastName()).isPresent()){
            throw new IllegalArgumentException("Medical Record exists");
        }
        getAllMedicalRecords().add(medicalRecord);
        return medicalRecord;
    }
    @Override
    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord)throws MedicalRecordNotFoundException {
        var existingMedicalRecord = findMedicalRecordByFirstNameAndLastName(updatedMedicalRecord.getLastName(), updatedMedicalRecord.getLastName())
                .orElseThrow(() -> new MedicalRecordNotFoundException());

        var index = getAllMedicalRecords().indexOf(existingMedicalRecord);
        getAllMedicalRecords().add(index, updatedMedicalRecord);

    }


    @Override
    public void deleteMedicalRecordByFirstNameAndLastName(String firstName, String lastName) {
        findMedicalRecordByFirstNameAndLastName(firstName,lastName).ifPresent(m->removeMedicalRecord(m));
    }

    private void removeMedicalRecord(MedicalRecord medicalRecord){
        dataStorage.getData().getMedicalrecords().remove(medicalRecord);
    }
}
