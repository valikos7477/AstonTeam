package com.aston.strategy.humans;

import com.aston.entities.Human;

public class CompareByName implements HumanSortingRule {
    @Override
    public int doSortingByField(Human current, Human compareWith) {
        return Integer.compare(current.getFullName().compareTo(compareWith.getFullName()), 0);
    }
}
