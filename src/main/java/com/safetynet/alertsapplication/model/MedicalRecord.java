package com.safetynet.alertsapplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalRecord implements Serializable {

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "MM/dd/yyyy", timezone = "Europe/Paris")
    private Date birthdate;

    private List<String> medications;

    private List<String> allergies;

    public MedicalRecord update(MedicalRecord medicalrecord){
        this.birthdate = medicalrecord.getBirthdate();
        this.medications = medicalrecord.getMedications();
        this.allergies = medicalrecord.getAllergies();
        return medicalrecord;
    }
}
