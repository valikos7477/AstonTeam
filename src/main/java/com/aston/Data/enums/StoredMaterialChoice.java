package com.aston.Data.enums;

public enum StoredMaterialChoice {
    BEER(1, "1. Пиво", StoredMaterial.BEER),
    WINE(2, "2. Вино", StoredMaterial.WINE),
    FISH(3, "3. Рыба", StoredMaterial.FISH),
    GAS(4, "4. Газ", StoredMaterial.GAS),
    OIL(5, "5. Нефть", StoredMaterial.OIL);

    private final int choice;
    private final String description;
    private final StoredMaterial storedMaterial;

    StoredMaterialChoice(int choice, String description, StoredMaterial storedMaterial) {
        this.choice = choice;
        this.description = description;
        this.storedMaterial = storedMaterial;
    }

    public String getDescription() {
        return description;
    }

    public StoredMaterial getStoredMaterial() {
        return storedMaterial;
    }

    public static StoredMaterialChoice fromInt(int choice) {
        for (StoredMaterialChoice material : StoredMaterialChoice.values()) {
            if (material.choice == choice) {
                return material;
            }
        }
        throw new IllegalArgumentException("Неверный выбор хранимого материала: " + choice);
    }
}