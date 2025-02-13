package com.aston.Data.enums;


public enum EyeColorChoice {
    RED(1, "1. Красный", EyeColor.RED),
    GREEN(2, "2. Зеленый", EyeColor.GREEN),
    BLACK(3, "3. Черный", EyeColor.BLACK),
    GREY(4, "4. Серый", EyeColor.GREY),
    BLUE(5, "5. Голубой", EyeColor.BLUE);

    private final int choice;
    private final String description;
    private final EyeColor eyeColor;

    EyeColorChoice(int choice, String description, EyeColor eyeColor) {
        this.choice = choice;
        this.description = description;
        this.eyeColor = eyeColor;
    }

    public String getDescription() {
        return description;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public static EyeColorChoice fromInt(int choice) {
        for (EyeColorChoice color : EyeColorChoice.values()) {
            if (color.choice == choice) {
                return color;
            }
        }
        throw new IllegalArgumentException("Неверный выбор цвета глаз: " + choice);
    }
}