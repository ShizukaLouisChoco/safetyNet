package com.safetynet.alertsapplication.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FireStationNotFoundException extends Exception {
    // to avoid warning
    private static final long serialVersionUID = 1L;
}
