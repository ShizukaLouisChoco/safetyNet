package com.safetynet.alertsapplication.service;

import java.util.List;

public interface EndpointService {
    List getFireStationListByFireStationNumber(String stationNumber);

    List getChildAlertListByAddress(String address);

    List getPhoneAlertListByFireStationNumber(String fireStationNumber);

    List getFireListByAddress(String address);

    List getStationsListByListOfStationNumber(List fireStationNumbers);

    List getPersonInfoListByFirstNameAndLastName(String firstName, String lastName);

    List getCommunityEmailListByCity(String city);
}
