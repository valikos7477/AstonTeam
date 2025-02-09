package com.aston.utils.sorting.animals;

import com.aston.entities.Animal;

public class CompareAnimalByType implements AnimalSortingRule {
    @Override
    public int doSortingByField(Animal current, Animal compareWith) {
        return Integer.compare(current.getAnimalType().compareTo(compareWith.getAnimalType()), 0);
    }
}
