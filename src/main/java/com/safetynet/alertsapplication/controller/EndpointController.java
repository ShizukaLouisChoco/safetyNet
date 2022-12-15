package com.safetynet.alertsapplication.controller;

import com.safetynet.alertsapplication.dto.*;
import com.safetynet.alertsapplication.service.EndpointService;
import com.safetynet.alertsapplication.service.FireStationService;
import com.safetynet.alertsapplication.service.MedicalRecordService;
import com.safetynet.alertsapplication.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Log4j2
@RestController
public class EndpointController {
    //log.info("EndpointController");

    private final EndpointService endpointService;
    private final PersonService personService;
    private final FireStationService fireStationService;

    private final MedicalRecordService medicalRecordService;

    public EndpointController(EndpointService endpointService, PersonService personService, FireStationService fireStationService, MedicalRecordService medicalRecordService) {
        this.endpointService = endpointService;
        this.personService = personService;
        this.fireStationService = fireStationService;
        this.medicalRecordService = medicalRecordService;
    }

    /**
     * Get - get a list of person information & number of adults and children (<=18 yo) who has same fire station number requested
     * @param station_number A String Station number
     * @return The list of person information
     * (full name + address + telephone number)
     * & number of adults and children (<=18 yo) who has same fire station number requested
     */
    //http://localhost:9000/firestation?stationNumber={station_number}
    @GetMapping(value = "firestation")
    public @ResponseBody PersonsInformationWithChildNumberDTO01 getPersonsInformationWithAdultAndChildNumberByFireStationNumber(@RequestParam("stationNumber") final String station_number){

        return endpointService.getPersonsInformationWithAdultAndChildNumberByStationNumber(station_number);
    }





    /**
     * Get - get a list of children who live in the address requested
     * @param address A String address
     * @return The list of children's information
     * (full name + age + family number).
     * if there's no child, return String empty
     */
    //http://localhost:9000/childAlert?address={address}

    @GetMapping(value = "/childAlert")
    public  @ResponseBody ChildInformationWithFamilyDTO02 getChildInformationByAddress(@RequestParam("address")final String address){

        return  endpointService.getChildInformationByAddress(address);
    }

    /**
     * Get - get a list of phone number registered by fire station number requested
     * @param fireStationNumber A String fire station number
     * @return The list of phone number
     * /phoneAlert?firestation={firestation_number}
     */
    @ResponseBody
    @GetMapping(value = "/phoneAlert")
    public List<String> getPhoneNumberListByFireStationNumber(@PathVariable("firestation_number")final String fireStationNumber){
        return endpointService.getPhoneNumberListByFireStationNumber(fireStationNumber);
    }


    /**
     * Get - Cette url doit retourner la liste des habitants vivant à l’adresse donnée ainsi que le numéro de la caserne
     * de pompiers la desservant. La liste doit inclure le nom, le numéro de téléphone, l'âge et les antécédents médicaux
     * (médicaments, posologie et allergies) de chaque personne.
     * @param address A String  address
     * @return The list of person info
     * (lastName, phone number, age, medical record)
     * & fire station number
     */
    @ResponseBody
    @GetMapping(value = "/fire?address={address}")
    public PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05 getPersonsInformationWithMedicalRecordsAndFirestationNumberByAddress(@PathVariable("address") final String address) {
        return endpointService.getPersonsInformationWithMedicalRecordsAndFirestationNumberByAddress(address);
    }

     /**
     * Get - get a list of person info by a list of fire station number requested
     * @param fireStationNumbers A List fire station numbers
     * @return The list of person info
     * ( family name + phone number + age + medical record)
     */
    @ResponseBody
    @GetMapping(value = "/stations?stations={a_list_of_station_numbers}")
    public List<PersonsInformationsWithMedicalRecordsByListOfStationNumberDTO04> getPersonsInformationWithMedicalRecordsByListOfStationNumber(@PathVariable("a_list_of_station_numbers")final List<String> fireStationNumbers){
        return endpointService.getPersonsInformationWithMedicalRecordsByListOfStationNumber(fireStationNumbers);
    }


    /**
     * Get - get a list of person info by full name
     * @param firstName,lastName A String first name and last name
     * @return The list of person info
     * ( family name + address + age + mail address + medical record)
     */
    @ResponseBody
    @GetMapping(value = "/personInfo?firstName={firstName}&lastName={lastName}")
    public PersonInformationWithMedicalRecordByNameDTO06 getPersonInformationWithMedicalRecordsByFirstNameAndLastName(@PathVariable("firstName")final String firstName, @PathVariable("lastName")final String lastName){
        return endpointService.getPersonInformationWithMedicalRecordsByFirstNameAndLastName(firstName,lastName);
    }

    /**
     * Get - get a list of email by city
     * @param city A String city
     * @return The list of email
     */
    //http://localhost:9000/communityEmail?city={city}
    @GetMapping(value="/communityEmail")
    public @ResponseBody List<String> getEmailListByCity(@RequestParam("city")final String city) throws IOException {
        return endpointService.getEmailListByCity(city);
    }

}
