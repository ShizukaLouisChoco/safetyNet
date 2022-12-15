package com.safetynet.alertsapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonsInformationWithChildNumberDTO01 {
    private List<PersonInfo> persons;

    private Long childNumber;

    public PersonsInformationWithChildNumberDTO01(List<PersonInformationWithMedicalRecordsForAllDTO> personsList) {
        this.persons = personsList
                .stream()
                .map(p -> new PersonInfo(p))
                .toList();
        this.childNumber = personsList
                .stream()
                .filter( p -> p.isMinor())
                .count();
    }

    @Data
    class PersonInfo {
        private String firstName;
        private String lastName;
        private String address;
        private String phone;

        public PersonInfo(PersonInformationWithMedicalRecordsForAllDTO person) {
            this.firstName = person.getFirstName();
            this.lastName = person.getLastName();
            this.address = person.getAddress();
            this.phone = person.getPhone();
        }
    }
}
