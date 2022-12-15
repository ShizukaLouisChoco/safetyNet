package com.safetynet.alertsapplication.dto;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonInformationWithMedicalRecordByNameDTO06 {

    private String lastName;
    private String phone;
    private int age;
    private List<String> medications;
    private List<String> allergies;

    public PersonInformationWithMedicalRecordByNameDTO06(Person person, MedicalRecord medicalRecord){
        this.lastName = person.getLastName();
        this.phone = person.getPhone();
        this.age = medicalRecord.getAge();
        this.medications = medicalRecord.getMedications();
        this.allergies = medicalRecord.getAllergies();
    }



}
