package com.safetynet.alertsapplication.service;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> getPerson(final String firstName, final String lastName);
    Person savePerson(Person person);
    Person updatePerson(String firstName, String lastName, Person person) throws PersonNotFoundException;
    void deletePerson(String firstName, String lastName);
}
