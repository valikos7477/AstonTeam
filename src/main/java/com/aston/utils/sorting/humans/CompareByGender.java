package com.aston.utils.sorting.humans;

import com.aston.entities.Human;

public class CompareByGender implements HumanSortingRule {
    @Override
    public int doSortingByField(Human current, Human compareWith) {
        return Integer.compare(current.getGender().compareTo(compareWith.getGender()), 0);
    }
}
