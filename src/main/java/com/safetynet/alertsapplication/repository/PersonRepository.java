package com.safetynet.alertsapplication.repository;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface PersonRepository {
    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteByFirstNameAndLastName(String firstName, String lastName);


    void updatePerson(Person updatedPerson);

    Person savePerson(Person person);

    List<Person> getAllPerson() throws IOException;
}
