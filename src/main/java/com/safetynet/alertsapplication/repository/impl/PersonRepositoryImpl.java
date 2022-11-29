package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.dao.DataStorage;
import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final DataStorage dataStorage;

    public PersonRepositoryImpl(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }


    public static PersonRepositoryImpl createPersonRepositoryImpl(DataStorage dataStorage) {
        return new PersonRepositoryImpl(dataStorage);
    }

    @Override
    public Optional<Person> findByFirstNameAndLastName(String firstName, String lastName) throws IOException {

        //full name -> address + city + zip + phone number + email(person.txt)


        return Optional.empty();
    }

    @Override
    public void deleteByFirstNameAndLastName(String firstName, String lastName) {

    }

    @Override
    public Person savePerson(Person person) {
        return null;
    }

    @Override
    public List<Person> getAllPerson() throws IOException {
        return dataStorage.getPersons();
    }
}
