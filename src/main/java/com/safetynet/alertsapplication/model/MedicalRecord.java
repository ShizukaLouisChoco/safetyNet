package com.safetynet.alertsapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord implements Serializable {

    private String firstName;

    private String lastName;

    private Date birthDate;

    private Medication medication;

    private Allergy allergy;

    public MedicalRecord update(MedicalRecord medicalRecord){
        this.setBirthDate(medicalRecord.getBirthDate());
        this.setMedication(medicalRecord.getMedication());
        this.setAllergy(medicalRecord.getAllergy());
        return this;
    }
}
