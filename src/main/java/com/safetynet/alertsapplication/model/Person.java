package com.safetynet.alertsapplication.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String zip;

    private String phone;

    private String email;

    public Person update(Person person){
        this.setAddress(person.getAddress());
        this.setCity(person.getCity());
        this.setZip(person.getZip());
        this.setPhone(person.getPhone());
        this.setEmail(person.getEmail());
        return this;
    }


}
