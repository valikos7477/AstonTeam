package com.aston.entities;

import com.aston.entities.Animal;
import com.aston.Data.enums.AnimalType;
import com.aston.Data.enums.EyeColor;
import com.aston.entities.Animal;
import com.aston.entities.AnimalBuilder;

public class AnimalHandler {
    public static Animal buildAnimal(String paramStr) {
        String[] params = paramStr.split(";");
        AnimalType animalType = AnimalType.fromString(params[0].split("=")[1]);
        EyeColor eyeColor = EyeColor.fromString(params[1].split("=")[1]);
        int weight = Integer.parseInt(params[2].split("=")[1]);
        boolean isFur = Boolean.parseBoolean(params[3].split("=")[1]);

        return new AnimalBuilder()
                .setupType(animalType)
                .setupEyeColor(eyeColor)
                .setupWeight(weight)
                .setupFur(isFur)
                .build();
    }
}
