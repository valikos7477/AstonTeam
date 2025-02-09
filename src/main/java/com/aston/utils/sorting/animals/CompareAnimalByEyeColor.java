package com.aston.utils.sorting.animals;

import com.aston.entities.Animal;

public class CompareAnimalByEyeColor implements AnimalSortingRule {
    @Override
    public int doSortingByField(Animal current, Animal compareWith) {
        return Integer.compare(current.getEyeColor().compareTo(compareWith.getEyeColor()), 0);
    }
}
