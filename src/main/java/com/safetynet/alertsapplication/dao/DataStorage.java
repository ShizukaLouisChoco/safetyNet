package com.safetynet.alertsapplication.dao;

import com.safetynet.alertsapplication.model.AllData;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.model.Person;

import java.util.List;


public interface DataStorage {
    AllData getData();

    List<Person> getPersons() ;

    List<FireStation> getFireStations() ;

    List<MedicalRecord> getMedicalRecords() ;

    }
