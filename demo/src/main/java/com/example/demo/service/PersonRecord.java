package com.example.demo.service;

import java.util.StringJoiner;

public class PersonRecord {

    private String firstName, lastName, gender;

    public PersonRecord(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonRecord.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("gender='" + gender + "'")
                .toString();
    }
}
