package com.aston.Sorting.Animals;

import com.aston.entities.Animal;

public class CompareByWeight implements AnimalSorting{


    @Override
    public Integer sort(Animal animalCurrent, Animal willBe) {
        return Integer.compare(animalCurrent.getWeight().compareTo(willBe.getWeight()), 0);
    }
}
