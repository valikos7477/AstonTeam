package com.aston.Data.enums;

public enum BoxMaterial {
    WOOD, METAL, PLASTIC;

    public static BoxMaterial fromString(String value) {
        switch (value.toLowerCase()) {
            case "wood": return WOOD;
            case "metal": return METAL;
            case "plastic": return PLASTIC;
            default: throw new IllegalArgumentException("Unknown box material: " + value);
        }
    }
}