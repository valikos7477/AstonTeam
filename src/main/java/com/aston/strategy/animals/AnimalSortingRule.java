package com.aston.strategy.animals;

import com.aston.entities.Animal;

public interface AnimalSortingRule {
    int doSortingByField(Animal current, Animal compareWith);
}

