package com.aston.Sorting.Humans;


import com.aston.entities.Human;

public class CompareByGender implements HumanSortingRule {

    @Override
    public int sortByField(Human humanCurrent, Human compareWith) {
        return Integer.compare(humanCurrent.getGender().compareTo(compareWith.getGender()),0);
    }
}
