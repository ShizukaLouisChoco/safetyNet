package com.safetynet.alertsapplication.service;

import com.safetynet.alertsapplication.dto.*;

import java.io.IOException;
import java.util.List;

public interface EndpointService {
    PersonsInformationWithChildNumberDTO01 getPersonsInformationWithAdultAndChildNumberByStationNumber(String fireStationNumber);

    ChildInformationWithFamilyDTO02 getChildInformationByAddress(String address);

    List getPhoneAlertListByFireStationNumber(String fireStationNumber);

    List getFireListByAddress(String address);

    abstract List<PersonsInformationsWithMedicalRecordsByListOfStationNumberDTO04> getPersonsInformationWithMedicalRecordsByListOfStationNumber(List<String> fireStationNumbers);

    PersonInformationWithMedicalRecordByNameDTO06 getPersonInformationWithMedicalRecordsByFirstNameAndLastName(String firstName, String lastName);

    List getEmailListByCity(String city) throws IOException;


    PersonsInformationWithMedicalRecordsAndFireStationNumberDTO05 getPersonsInformationWithMedicalRecordsAndFirestationNumberByAddress(String address);
}
