package com.aston.entities;

import com.aston.enums.AnimalType;
import com.aston.enums.EyeColor;
import com.aston.utils.RandomTools;

public class AnimalBuilder {
    private AnimalType type;
    private EyeColor color;
    private Integer weight;
    private Boolean isFur;

    public AnimalBuilder setupType(AnimalType type) {
        this.type = type;
        return this;
    }

    public AnimalBuilder setupEyeColor(EyeColor color) {
        this.color = color;
        return this;
    }

    public AnimalBuilder setupWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public AnimalBuilder setupFur(Boolean isFur) {
        this.isFur = isFur;
        return this;
    }

    public Animal build() {
        Animal animal = new Animal();
        animal.setAnimalType(type);
        animal.setEyeColor(color);
        animal.setWeight(weight);
        animal.setFur(isFur);
        return animal;
    }

    public Animal randomBuild() {
        Animal animal = new Animal();

        animal.setAnimalType(RandomTools.getRandomAnimalType());
        animal.setEyeColor(RandomTools.getRandomEyeColor());
        animal.setWeight(RandomTools.randInt(1, 5000));
        animal.setFur(RandomTools.randBoolean());
        return animal;
    }
}
