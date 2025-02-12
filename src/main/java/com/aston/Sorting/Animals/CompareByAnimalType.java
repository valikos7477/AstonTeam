package com.aston.Sorting.Animals;

import com.aston.entities.Animal;

public class CompareByAnimalType implements AnimalSorting{
    @Override
    public Integer sort(Animal animalCurrent, Animal willBe) {
        return Integer.compare(animalCurrent.getAnimalType().compareTo(willBe.getAnimalType()), 0);
    }
}
