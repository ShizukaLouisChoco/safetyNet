package com.safetynet.alertsapplication.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalRecordNotFoundException extends Exception {
    // to avoid warning
    private static final long serialVersionUID = 1L;

}
