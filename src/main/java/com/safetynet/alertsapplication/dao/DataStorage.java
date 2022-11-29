package com.safetynet.alertsapplication.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapplication.model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

import lombok.Getter;

import com.safetynet.alertsapplication.model.*;

@Component
@Log4j2
public class DataStorage {

    @Getter
    private final Data data;

    public DataStorage() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new ClassPathResource("data.json").getFile();
        //log.info("File address = " + file.getAbsolutePath());
        this.data = objectMapper.readValue(file, Data.class);
    }

    public List<Person> getPersons() {
        //log.info("Get all persons");
        return data.getPersons();
    }
    public List<FireStation> getFireStations() {
        //log.info("Get all fire stations");
        return data.getFirestations();
    }

    public List<MedicalRecord> getMedicalRecords() {
        //log.info("Get all medical records");
        return data.getMedicalrecords();
    }



}
