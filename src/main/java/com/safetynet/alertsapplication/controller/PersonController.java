package com.safetynet.alertsapplication.controller;

import com.safetynet.alertsapplication.exception.PersonNotFoundException;
import com.safetynet.alertsapplication.model.Person;
import com.safetynet.alertsapplication.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Log4j2
@RestController
public class PersonController {
    //log.info("PersonController");
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Create - add a new person
     * @param person An object person
     * @return The person object saved
     */
    @PostMapping(value = "/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    /**
     * Update - Update an existing person
     * @param firstName & lastName - the firstName&lastName of the person to update
     * @return The person updated
     */
    @PutMapping("/person?firstName={firstName}&lastName={lastName}")
    public Person updatePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName, @RequestBody Person person) throws PersonNotFoundException, IOException {

        return personService.updatePerson(firstName, lastName, person);
    }

    /**
     * Delete - Delete a person
     * @param firstName & lastName - The full name of the person to delete
     */
    @DeleteMapping("/person?firstName={firstName}&lastName={lastName}")
    public void deletePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
        personService.deletePerson(firstName, lastName);
    }

    /**
     * GET - Get all person
     */
    @GetMapping("/persons")
    public List<Person> getPersons() throws IOException{
       return personService.getAllPerson();
    }

}