package com.safetynet.alertsapplication.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapplication.model.AllData;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;


public interface DataStorage {

    List<Person> getPersons() ;

    List<FireStation> getFireStations() ;

    List<MedicalRecord> getMedicalRecords() ;

    }
