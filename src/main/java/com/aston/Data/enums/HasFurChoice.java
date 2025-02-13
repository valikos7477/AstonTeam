package com.aston.Data.enums;

public enum HasFurChoice {
    YES(1, "1. Есть", true),
    NO(2, "2. Отсутствует", false);

    private final int choice;
    private final String description;
    private final boolean hasFur;

    HasFurChoice(int choice, String description, boolean hasFur) {
        this.choice = choice;
        this.description = description;
        this.hasFur = hasFur;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasFur() {
        return hasFur;
    }

    public static HasFurChoice fromInt(int choice) {
        for (HasFurChoice fur : HasFurChoice.values()) {
            if (fur.choice == choice) {
                return fur;
            }
        }
        throw new IllegalArgumentException("Неверный выбор наличия шерсти: " + choice);
    }
}
