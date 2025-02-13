package com.aston.Data.enums;

import com.aston.Data.enums.BoxMaterial;

public enum BoxMaterialChoice {
    WOOD(1, "1. Дерево", BoxMaterial.WOOD),
    METAL(2, "2. Метал", BoxMaterial.METAL),
    PLASTIC(3, "3. Пластик", BoxMaterial.PLASTIC);

    private final int choice;
    private final String description;
    private final BoxMaterial boxMaterial;

    BoxMaterialChoice(int choice, String description, BoxMaterial boxMaterial) {
        this.choice = choice;
        this.description = description;
        this.boxMaterial = boxMaterial;
    }

    public String getDescription() {
        return description;
    }

    public BoxMaterial getBoxMaterial() {
        return boxMaterial;
    }

    public static BoxMaterialChoice fromInt(int choice) {
        for (BoxMaterialChoice material : BoxMaterialChoice.values()) {
            if (material.choice == choice) {
                return material;
            }
        }
        throw new IllegalArgumentException("Неверный выбор материала бочки: " + choice);
    }
}