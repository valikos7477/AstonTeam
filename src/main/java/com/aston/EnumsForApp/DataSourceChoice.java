package com.aston.EnumsForApp;

public enum DataSourceChoice {
    EXIT("0. Выход из программы"),
    MANUAL("1. Ручной ввод"),
    RANDOM("2. Рандом"),
    FILE("3. Файл");

    private final String description;

    DataSourceChoice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static DataSourceChoice fromInt(int choice) {
        switch (choice) {
            case 0: return EXIT;
            case 1: return MANUAL;
            case 2: return RANDOM;
            case 3: return FILE;
            default: throw new IllegalArgumentException("Неверный выбор источника данных: " + choice);
        }
    }
}
