package com.safetynet.alertsapplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalRecord implements Serializable {

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "MM/dd/yyyy", timezone = "Europe/Paris")
    private LocalDate birthdate;

    private List<String> medications;

    private List<String> allergies;

    public MedicalRecord update(MedicalRecord medicalrecord){
        this.birthdate = medicalrecord.getBirthdate();
        this.medications = medicalrecord.getMedications();
        this.allergies = medicalrecord.getAllergies();
        return medicalrecord;
    }
}
