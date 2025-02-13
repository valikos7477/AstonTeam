package com.aston.entities;

import com.aston.Data.enums.AnimalType;
import com.aston.Data.enums.EyeColor;
import com.aston.Sorting.Animals.CompareByAnimalType;
import com.aston.utils.Randomer;
import com.aston.Sorting.Animals.CompareByWeight;

public class AnimalBuilder {
    private AnimalType type;
    private EyeColor color;
    private Integer weight;
    private Boolean isFur;


    public static AnimalBuilder create() {
        return new AnimalBuilder();
    }
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
        animal.setupSortingStrategy(new CompareByWeight());
        return animal;
    }

    public Animal randomBuild() {
        Animal animal = new Animal();

        animal.setAnimalType(Randomer.getRandomAnimalType());
        animal.setEyeColor(Randomer.getRandomEyeColor());
        animal.setWeight(Randomer.randInt(1, 5000));
        animal.setFur(Randomer.randBoolean());
        animal.setupSortingStrategy(new CompareByWeight());
        return animal;
    }
}