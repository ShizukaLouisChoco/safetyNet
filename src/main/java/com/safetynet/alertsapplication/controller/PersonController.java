package com.safetynet.alertsapplication.controller;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Create - add a new person
     *
     * @param person An object person
     * @return The person object saved
     */
    @PostMapping(value = "/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    /**
     * Update - Update an existing person
     *
     * @param firstName & lastName - the firstName&lastName of the person to update
     * @param
     */
    @PutMapping("/person?firstName={firstName}&lastName={lastName}")
    public Person updatePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName, @RequestBody Person person) throws PersonNotFoundException {

        return personService.updatePerson(firstName, lastName, person);
    }

    /**
     * Delete - Delete a person
     *
     * @param firstName & lastName - The fullname of the person to delete
     */
    @DeleteMapping("/person?firstName={firstName}&lastName={lastName}")
    public void deletePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
        personService.deletePerson(firstName, lastName);
    }



}