package com.safetynet.alertsapplication.controller;

import com.safetynet.alertsapplication.exception.FireStationNotFoundException;
import com.safetynet.alertsapplication.model.FireStation;
import com.safetynet.alertsapplication.service.FireStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class FireStationController {

    private final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }


    /**
     * Create - add a fire station
     * @param fireStation An object fireStation
     * @return The fireStation object saved
     */

    @PostMapping(value = "/firestation")
    public FireStation createFireStation(@RequestBody FireStation fireStation) {
        return fireStationService.saveFireStation(fireStation);
    }

    /**
     * Update - Update an existing fire station
     * @param address - the address of the fire station to update
     * @return The fire station updated
     */

    @PutMapping("/firestation?address={address}")
    public FireStation updateFireStation(@PathVariable("address") final String address, @RequestBody FireStation fireStation) throws FireStationNotFoundException {

        return fireStationService.updateFireStation(address, fireStation);
    }

    /**
     * Delete - Delete a fire station
     * @param address - The address of the fire station to delete
     */
    @DeleteMapping("/firestation?address={address}")
    public void deleteFireStationn(@PathVariable("address") final String address) {
        fireStationService.deleteFireStation(address);
    }
}
