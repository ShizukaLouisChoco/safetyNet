package com.safetynet.alertsapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonNotFoundException extends Exception {
    // to avoid warning
    private static final long serialVersionUID = 1L;

    }
