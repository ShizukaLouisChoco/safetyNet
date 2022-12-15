package com.safetynet.alertsapplication.dto;

import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonInformationWithMedicalRecordsForAllDTO {
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private String phone;
    private String email;
    private List<String> medications;
    private List<String> allergies;

    public PersonInformationWithMedicalRecordsForAllDTO(Person person , MedicalRecord medicalRecord){
        this.lastName = person.getLastName();
        this.firstName = person.getFirstName();
        this.address = person.getAddress();
        this.age = medicalRecord.getAge();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.medications = medicalRecord.getMedications();
        this.allergies = medicalRecord.getAllergies();
    }

    public boolean isMinor(){
        return age < 18;
    }
}
