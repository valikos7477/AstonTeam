package com.aston.entities;

import com.aston.Data.enums.AnimalType;
import com.aston.Data.enums.EyeColor;
import com.aston.Sorting.Animals.AnimalSorting;


public class Animal implements Comparable {
    private AnimalType animalType;
    private EyeColor eyeColor;
    private Integer weight;
    private Boolean isFur;

    private AnimalSorting strategy;

    @Override
    public int compareTo(Object o) {
        Animal obj = (Animal) o;
        return strategy.sort(this, obj);
    }

    public void setupSortingStrategy(AnimalSorting strategy) {
        this.strategy = strategy;
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

    public AnimalType getAnimalType() {
        return animalType;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ANIMAL#" +
                "animalType=" + animalType +
                ";eyeColor=" + eyeColor +
                ";weight=" + weight +
                ";isFur=" + isFur;
    }
}
