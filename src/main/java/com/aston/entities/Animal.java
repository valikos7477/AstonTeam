package com.aston.entities;

import com.aston.enums.AnimalType;
import com.aston.enums.EyeColor;

public class Animal implements Sortable {
    private final AnimalType animalType;
    private final EyeColor eyeColor;
    private final Integer weight;
    private final Boolean isFur;

    private Animal(Builder builder) {
        this.animalType = builder.animalType;
        this.eyeColor = builder.eyeColor;
        this.weight = builder.weight;
        this.isFur = builder.isFur;
    }

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

    public static class Builder{
        private AnimalType animalType;
        private EyeColor eyeColor;
        private int weight;
        private Boolean isFur;



        public Builder setAnimalType(AnimalType animalType){
            this.animalType=animalType;
            return this;
        }  public Builder setEyeColor(EyeColor eyeColor){
            this.eyeColor=eyeColor;
            return this;
        }  public Builder setWeight (int weight){
            this.weight=weight;
            return this;
        }  public Builder setIsFur(Boolean isFur){
            this.isFur=isFur;
            return this;
        }

        public Animal build(){
            return new Animal(this);
        }

    }

}