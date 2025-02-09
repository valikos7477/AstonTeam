package com.aston.utils.sorting.animals;

import com.aston.entities.Animal;

public class CompareAnimalByWeight implements AnimalSortingRule {
    @Override
    public int doSortingByField(Animal current, Animal compareWith) {
        if (current.getWeight() < compareWith.getWeight()) {
            return -1;
        }

        if (current.getWeight() > compareWith.getWeight()) {
            return 1;
        }

        return 0;
    }
}
