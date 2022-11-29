package com.safetynet.alertsapplication.repository;

import com.safetynet.alertsapplication.model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface PersonRepository {
    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName) throws IOException;

    void deleteByFirstNameAndLastName(String firstName, String lastName);

    Person savePerson(Person person);

    List<Person> getAllPerson() throws IOException;
}
