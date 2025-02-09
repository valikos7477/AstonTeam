package com.aston.utils.sorting.animals;

import com.aston.entities.Animal;

public class CompareAnimalByType implements AnimalSortingRule {
    @Override
    public int doSortingByField(Animal current, Animal compareWith) {
        if (current.getAnimalType().compareTo(compareWith.getAnimalType()) < 0 ) {
            return -1;
        }

        if (current.getAnimalType().compareTo(compareWith.getAnimalType()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
