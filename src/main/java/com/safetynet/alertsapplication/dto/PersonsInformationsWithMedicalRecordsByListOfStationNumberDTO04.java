package com.safetynet.alertsapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonsInformationsWithMedicalRecordsByListOfStationNumberDTO04 {
    private List<PersonInfo> personInfo;
    private String address;

    public PersonsInformationsWithMedicalRecordsByListOfStationNumberDTO04(List<PersonInformationWithMedicalRecordsForAllDTO> personList, List<String> address){
    personInfo = personList
            .stream()
            .filter(p -> p.getAddress().contains(address.toString()))
            .map(p -> new PersonInfo(p))
            .toList();

    this.address = address
            .stream()
            .iterator().next();
    ;
    }

@Data
 class PersonInfo{
     private String lastName;
     private String address;
     private int age;
     private String phone;
     private String email;
     private List<String> medications;
     private List<String> allergies;

     public PersonInfo(PersonInformationWithMedicalRecordsForAllDTO person){
         this.lastName = person.getLastName();
         this.address = person.getAddress();
         this.age = person.getAge();
         this.phone = person.getPhone();
         this.email = person.getEmail();
         this.medications = person.getMedications();
         this.allergies = person.getAllergies();
     }
 }
}
