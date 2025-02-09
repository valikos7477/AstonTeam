package com.aston.utils.sorting.animals;

import com.aston.entities.Animal;

public class CompareAnimalByWeight implements AnimalSortingRule {
    @Override
    public int doSortingByField(Animal current, Animal compareWith) {
        return Integer.compare(current.getWeight().compareTo(compareWith.getWeight()), 0);
    }
}
