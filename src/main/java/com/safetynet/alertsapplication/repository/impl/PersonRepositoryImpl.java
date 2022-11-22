package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Optional<Person> findByFirstNameAndLastName(String firstName, String lastName) {
        return Optional.empty();
    }

    @Override
    public void deleteByFirstNameAndLastName(String firstName, String lastName) {

    }

    @Override
    public Person savePerson(Person person) {
        return null;
    }
}
