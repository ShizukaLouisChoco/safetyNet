package com.safetynet.alertsapplication.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AllData {
    private List<Person> persons = new ArrayList<>();
    private List<FireStation> firestations = new ArrayList<>();
    private List<MedicalRecord> medicalrecords = new ArrayList<>();
}