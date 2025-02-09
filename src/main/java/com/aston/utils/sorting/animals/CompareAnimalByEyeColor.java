package com.aston.utils.sorting.animals;

import com.aston.entities.Animal;

public class CompareAnimalByEyeColor implements AnimalSortingRule {
    @Override
    public int doSortingByField(Animal current, Animal compareWith) {
        if (current.getEyeColor().compareTo(compareWith.getEyeColor()) < 0 ) {
            return -1;
        }

        if (current.getEyeColor().compareTo(compareWith.getEyeColor()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
