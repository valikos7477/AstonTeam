package com.aston.utils.sorting.humans;

import com.aston.entities.Human;

public class CompareByAge implements HumanSortingRule {
    @Override
    public int doSortingByField(Human current, Human compareWith) {
        return Integer.compare(current.getAge().compareTo(compareWith.getAge()), 0);
    }
}
