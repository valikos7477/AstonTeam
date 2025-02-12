package com.aston.EnumsForApp;

public enum EntityChoice {
    EXIT("0. Выход из программы"),
    HUMAN("1. Люди"),
    ANIMAL("2. Животные"),
    BOX("3. Бочки");

    private final String description;

    EntityChoice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EntityChoice fromInt(int choice) {
        switch (choice) {
            case 0: return EXIT;
            case 1: return HUMAN;
            case 2: return ANIMAL;
            case 3: return BOX;
            default: throw new IllegalArgumentException("Неверный выбор сущности: " + choice);
        }
    }
}
