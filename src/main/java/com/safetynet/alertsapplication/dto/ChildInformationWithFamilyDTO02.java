package com.safetynet.alertsapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChildInformationWithFamilyDTO02 {

    private List<Child> children;
    private List<Family> familyMembers;

    public ChildInformationWithFamilyDTO02(List<PersonInformationWithMedicalRecordsForAllDTO> personList) {
        children = personList
                .stream()
                .filter(c -> c.isMinor())
                .map(c -> new Child(c))
                .toList();

        familyMembers = personList
                .stream()
                .filter(c -> !c.isMinor())
                .map(c -> new Family(c))
                .toList();
    }


    @Data
    static class Child {
        private String firstName;
        private String lastName;
        private int age;

        public Child(PersonInformationWithMedicalRecordsForAllDTO child) {
            this.firstName = child.getFirstName();
            this.lastName = child.getLastName();
            this.age = child.getAge();
        }
    }

    @Data
    static class Family {
        private String firstName;
        private String lastName;

        public Family(PersonInformationWithMedicalRecordsForAllDTO family) {
            this.firstName = family.getFirstName();
            this.lastName = family.getLastName();
        }
    }
}
