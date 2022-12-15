package com.safetynet.alertsapplication.dto;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

@Data
public class PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05 {

    List<PersonInfo> persons;
    String fireStationNumber;

    public PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05(List<PersonInformationWithMedicalRecordsForAllDTO> personList, String fireStationNumber){
        persons = personList
                .stream()
                .map(p->new PersonInfo(p))
                .toList();
        this.fireStationNumber = fireStationNumber;
    }
    @Data
    class PersonInfo{
        private String lastName;
        private String phone;
        private int age;
        private List<String> medications;
        private List<String> allergies;

     public PersonInfo(PersonInformationWithMedicalRecordsForAllDTO person){
         this.lastName = person.getLastName();
         this.phone = person.getPhone();
         this.age = person.getAge();
         this.medications = person.getMedications();
         this.allergies = person.getAllergies();
     }
    }


}
