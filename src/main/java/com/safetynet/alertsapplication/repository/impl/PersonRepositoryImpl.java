package com.safetynet.alertsapplication.repository.impl;

import com.safetynet.alertsapplication.dao.DataStorage;
import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final DataStorage dataStorage;

    public PersonRepositoryImpl(DataStorage dataStorageImpl) {
        this.dataStorage = dataStorageImpl;
    }


    public static PersonRepositoryImpl createPersonRepositoryImpl(DataStorage dataStorageImpl) {
        return new PersonRepositoryImpl(dataStorageImpl);
    }

    @Override
    public Optional<Person> findByFirstNameAndLastName(String firstName, String lastName) {
       return getAllPerson()
               .stream()
               .filter(allPersons -> allPersons.getFirstName().equals(firstName) && allPersons.getLastName().equals(lastName))
               .findFirst();
    }

    @Override
    public void deleteByFirstNameAndLastName(String firstName, String lastName) {
        findByFirstNameAndLastName(firstName,lastName).ifPresent(p->removePerson(p));

    }

    private void removePerson(Person person) {
        dataStorage.getData().getPersons().remove(person);
    }

    @Override
    public Person savePerson(Person person) {
        if (findByFirstNameAndLastName(person.getFirstName(), person.getLastName()).isPresent()) {
            throw new IllegalArgumentException("Person exists");
        }
        getAllPerson().add(person);
        return person;
    }

    @Override
    public void updatePerson(Person updatedPerson) throws PersonNotFoundException{
        var existingPerson = findByFirstNameAndLastName(updatedPerson.getFirstName(), updatedPerson.getLastName())
                .orElseThrow(()-> new PersonNotFoundException());
        var index = getAllPerson().indexOf(existingPerson);
            getAllPerson().add(index, updatedPerson);
    }

    @Override
    public List<Person> getAllPerson() {
        return dataStorage.getData().getPersons();
    }

    @Override
    public Stream<Person> getAllByAddress(String address){
        return  dataStorage.getPersons()
                .stream()
                .filter(p -> p.getAddress().equals(address));
    }
    @Override
    public Stream<Person> getPersonByAddressList(List<String> fireStationAddressList) {
        return dataStorage
                .getPersons()
                .stream()
                .filter(p ->  fireStationAddressList.contains(p.getAddress()));
    }

    @Override
    public Stream<Person> getPersonByCity(String city) {
        return dataStorage
                .getPersons()
                .stream()
                .filter(f -> f.getCity().equals(city));
    }
}
