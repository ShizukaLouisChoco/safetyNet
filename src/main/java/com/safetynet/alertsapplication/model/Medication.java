package com.safetynet.alertsapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication implements Serializable {

    private List Medications;

    public Medication update (Medication medication){
        this.setMedications(medication.getMedications());
        return this;
    }
}
