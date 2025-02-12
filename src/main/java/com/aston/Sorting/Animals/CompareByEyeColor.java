package com.aston.Sorting.Animals;

import com.aston.entities.Animal;

public class CompareByEyeColor implements AnimalSorting{
    @Override
    public Integer sort(Animal animalCurrent, Animal willBe) {
        return Integer.compare(animalCurrent.getEyeColor().compareTo(willBe.getEyeColor()),0);
    }
}
