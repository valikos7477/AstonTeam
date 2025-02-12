package com.aston.Data.enums;

public enum StoredMaterial {
    BEER, WINE, FISH, GAS, OIL;

    public static StoredMaterial fromString(String value) {
        switch (value.toLowerCase()) {
            case "beer": return BEER;
            case "wine": return WINE;
            case "fish": return FISH;
            case "gas": return GAS;
            case "oil": return OIL;
            default: throw new IllegalArgumentException("Unknown stored material: " + value);
        }
    }
}
