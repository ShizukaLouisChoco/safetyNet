package com.safetynet.alertsapplication.service.impl;

import com.safetynet.alertsapplication.service.EndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EndpointServiceImpl implements EndpointService {

    //log.info("EndpointServiceImpl");
    /**
    * @return The list of person information
    * (full name + address + telephone number)
    * & number of adults and children (<=18 yo) who has same fire station number requested
     */
    @Override
    public List getFireStationListByFireStationNumber(String stationNumber) {
        return null;
    }

    /**
     * @return The list of children's information
     * (full name + age + family number).
     * if there's no child, return String empty
     */
    @Override
    public List getChildAlertListByAddress(String address) {
        return null;
    }

    /**
     * @return The list of phone number
     */
    @Override
    public List getPhoneAlertListByFireStationNumber(String fireStationNumber) {
        return null;
    }

    /**
     * @return The list of person info
     * (lastName, phone number, age, medical record)
     * & fire station number
     */
    @Override
    public List getFireListByAddress(String address) {
        return null;
    }

    /**
     * @return The list of person info
     * ( family name + phone number + age + medical record)
     */
    @Override
    public List getStationsListByListOfStationNumber(List fireStationNumbers) {
        return null;
    }

    /**
     * @return The list of person info
     * ( family name + address + age + mail address + medical record)
     */
    @Override
    public List getPersonInfoListByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    /**
     * @return The list of email
     */
    @Override
    public List getCommunityEmailListByCity(String city) {
        return null;
    }

}
