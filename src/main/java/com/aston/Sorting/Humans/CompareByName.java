package com.aston.Sorting.Humans;

import com.aston.entities.Human;

public class CompareByName implements HumanSortingRule{
    @Override
    public int sortByField(Human humanCurrent, Human compareWith) {
        return Integer.compare(humanCurrent.getFullName().compareTo(compareWith.getFullName()), 0);
    }
}
