package com.aston.Data.enums;

public enum Gender {
    MALE, FEMALE;

    public static Gender fromString(String value) {
        return value.equalsIgnoreCase("male") ? MALE : FEMALE;
    }
}