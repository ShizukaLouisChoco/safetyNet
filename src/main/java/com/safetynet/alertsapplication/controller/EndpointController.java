package com.safetynet.alertsapplication.controller;

import com.safetynet.alertsapplication.service.EndpointService;
import com.safetynet.alertsapplication.service.FireStationService;
import com.safetynet.alertsapplication.service.MedicalRecordService;
import com.safetynet.alertsapplication.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
     * @param stationNumber A String Station number
     * @return The list of person information
     * (full name + address + telephone number)
     * & number of adults and children (<=18 yo) who has same fire station number requested
     */
    @ResponseBody
    @GetMapping(value = "/firestation?stationNumber={station_number}")
    public List getFireStationListByFireStationNumber(@PathVariable("station_number")final String stationNumber){

        return endpointService.getFireStationListByFireStationNumber(stationNumber);
    }


    /**
     * Get - get a list of children who live in the address requested
     * @param address A String address
     * @return The list of children's information
     * (full name + age + family number).
     * if there's no child, return String empty
     */
    @ResponseBody
    @GetMapping(value = "/childAlert?address={address}")
    public List getChildAlertListByAddress(@PathVariable("address")final String address){

        return endpointService.getChildAlertListByAddress(address);
    }

    /**
     * Get - get a list of phone number registered by fire station number requested
     * @param fireStationNumber A String fire station number
     * @return The list of phone number
     */
    @ResponseBody
    @GetMapping(value = "/phoneAlert?firestation={firestation_number}")
    public List getPhoneAlertListByFireStationNumber(@PathVariable("firestation_number")final String fireStationNumber){
        return endpointService.getPhoneAlertListByFireStationNumber(fireStationNumber);
    }


    /**
     * Get - get a list of person info & fire station number by address requested
     * @param address A String  address
     * @return The list of person info
     * (lastName, phone number, age, medical record)
     * & fire station number
     */
    @ResponseBody
    @GetMapping(value = "/fire?address={address}")
    public List getFireListByAddress(@PathVariable("address")final String address){
       return endpointService.getFireListByAddress(address);
    }

     /**
     * Get - get a list of person info by a list of fire station number requested
     * @param fireStationNumbers A List fire station numbers
     * @return The list of person info
     * ( family name + phone number + age + medical record)
     */
    @ResponseBody
    @GetMapping(value = "/stations?stations={a _list_of_station_numbers}")
    public List getStationsListByListOfStationNumber(@PathVariable("a_list_of_station_numbers")final List fireStationNumbers){
        return endpointService.getStationsListByListOfStationNumber(fireStationNumbers);
    }


    /**
     * Get - get a list of person info by full name
     * @param firstName,lastName A String first name and last name
     * @return The list of person info
     * ( family name + address + age + mail address + medical record)
     */
    @ResponseBody
    @GetMapping(value = "/personInfo?firstName={firstName}&lastName={lastName}")
    public List getPersonInfoListByFirstNameAndLastName(@PathVariable("firstName")final String firstName,@PathVariable("lastName")final String lastName){
        return endpointService.getPersonInfoListByFirstNameAndLastName(firstName,lastName);
    }

    /**
     * Get - get a list of email by city
     * @param city A String city
     * @return The list of email
     */
    @ResponseBody
    @GetMapping(value = "/communityEmail?city={city}")
    public List getCommunityEmailListByCity(@PathVariable("city")final String city) {
        return endpointService.getCommunityEmailListByCity(city);
    }



}
