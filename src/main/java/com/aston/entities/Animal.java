package com.aston.entities;

import com.aston.enums.AnimalType;
import com.aston.enums.EyeColor;

public class Animal implements Sortable {
    private AnimalType animalType;
    private EyeColor eyeColor;
    private Integer weight;
    private Boolean isFur;

    @Override
    public void sortByFirstField() {

    }

    @Override
    public void sortBySecondField() {

    }

    @Override
    public void sortByThirdField() {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalType=" + animalType +
                ", eyeColor=" + eyeColor +
                ", weight=" + weight +
                ", isFur=" + isFur +
                '}';
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setFur(Boolean fur) {
        isFur = fur;
    }
}
