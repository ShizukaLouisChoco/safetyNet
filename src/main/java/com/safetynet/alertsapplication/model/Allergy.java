package com.safetynet.alertsapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allergy {

    private List allergies;

    public Allergy update (Allergy allergy){
        this.setAllergies(allergy.getAllergies());
        return this;
    }
}
