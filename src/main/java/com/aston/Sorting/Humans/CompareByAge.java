package com.aston.Sorting.Humans;

import com.aston.entities.Human;

public class CompareByAge implements HumanSortingRule {
    @Override
    public int sortByField(Human humanCurrent, Human compareWith) {
        return Integer.compare(humanCurrent.getAge().compareTo(compareWith.getAge()), 0);
    }
}
