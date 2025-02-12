package com.aston.Sorting.Animals;

import com.aston.entities.Animal;

public class CompareByFur implements AnimalSorting{
    @Override
    public Integer sort(Animal animalCurrent, Animal willBe) {
        return Integer.compare(animalCurrent.getFur().compareTo(willBe.getFur()),0);
    }
}
