package com.safetynet.alertsapplication.service;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> getPerson(final String firstName, final String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName,lastName);
    }


    @Override
    public Person savePerson(Person person) {
        return personRepository.savePerson(person);
    }

    @Override
    public Person updatePerson(String firstName, String lastName, Person person) throws PersonNotFoundException {
        String msg = "No person with that name exists";
        final var currentPerson = getPerson(firstName, lastName)
                .orElseThrow(() -> new PersonNotFoundException());

        final var updatedPerson = currentPerson.update(person);

        return personRepository.savePerson(updatedPerson);
    }

    @Override
    public void deletePerson(String firstName, String lastName) {
        personRepository.deleteByFirstNameAndLastName(firstName,lastName);

    }
}
