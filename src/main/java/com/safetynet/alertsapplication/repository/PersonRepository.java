package com.safetynet.alertsapplication.repository;

import com.safetynet.alertsapplication.model.Person;

import java.util.Optional;


public interface PersonRepository {
    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteByFirstNameAndLastName(String firstName, String lastName);

    Person savePerson(Person person);
}
