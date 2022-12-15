package com.safetynet.alertsapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireStation implements Serializable {

    private String address;

    private String station;

    public FireStation update(FireStation fireStation){
        this.address = fireStation.getAddress();
        this.station = fireStation.getStation();
        return fireStation;
    }
}
