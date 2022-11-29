package com.safetynet.alertsapplication.controller;

import com.safetynet.alertsapplication.exception.MedicalRecordNotFoundException;
import com.safetynet.alertsapplication.model.MedicalRecord;
import com.safetynet.alertsapplication.service.MedicalRecordService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Log4j2
@RestController
public class MedicalRecordController {

    //log.info("MedicalRecordController");

    private final MedicalRecordService medicalRecordService;


    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    /**
     * Create - add a new medical Record
     * @param medicalRecord An object medical record
     * @return The medical record object saved
     */

    @PostMapping(value = "/medicalRecord")
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }
    /**
     * Update - Update an existing medical record
     * @param firstName & lastName - the firstName&lastName of the medical record to update
     * @return The medical record updated
     */

    @PutMapping("/medicalRecord?firstName={firstName}&lastName={lastName}")
    public MedicalRecord updateMedicalRecord(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName, @RequestBody MedicalRecord medicalRecord) throws MedicalRecordNotFoundException {

        return medicalRecordService.updateMedicalRecord(firstName, lastName, medicalRecord);
    }

    /**
     * Delete - Delete a medical record
     * @param firstName & lastName - The full name of the medical record to delete
     */
    @DeleteMapping("/medicalRecord?firstName={firstName}&lastName={lastName}")
    public void deletePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
        medicalRecordService.deleteMedicalRecord(firstName, lastName);
    }

    /**
     * GET - Get all medical records
     */
    @GetMapping("/medicalrecords")
    public List<MedicalRecord> getMedicalRecords() throws IOException {

        return medicalRecordService.getAllMedicalRecords();
    }

}
