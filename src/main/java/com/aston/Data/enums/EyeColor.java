package com.aston.Data.enums;

public enum EyeColor {
    RED, GREEN, BLACK, GREY, BLUE;

    public static EyeColor fromString(String value) {
        switch (value.toLowerCase()) {
            case "red": return RED;
            case "green": return GREEN;
            case "black": return BLACK;
            case "grey": return GREY;
            case "blue": return BLUE;
            default: throw new IllegalArgumentException("Unknown eye color: " + value);
        }
    }
}