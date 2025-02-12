package com.aston.Data.enums;

public enum AnimalType {
    MAMMAL, AMPHIBIANS, REPTILES, BIRD;

    public static AnimalType fromString(String value) {
        switch (value.toLowerCase()) {
            case "mammal": return MAMMAL;
            case "amphibians": return AMPHIBIANS;
            case "reptiles": return REPTILES;
            case "bird": return BIRD;
            default: throw new IllegalArgumentException("Unknown animal type: " + value);
        }
    }
}