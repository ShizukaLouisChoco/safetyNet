package com.safetynet.alertsapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireStation implements Serializable {

    private String address;

    private String stationNumber;

    public FireStation update(FireStation fireStation){
        this.setAddress(fireStation.getAddress());
        this.setStationNumber(fireStation.getStationNumber());
        return this;
    }
}
