package com.aston.utils.sorting.humans;

import com.aston.entities.Human;

public class CompareByName implements HumanSortingRule {
    @Override
    public int doSortingByField(Human current, Human compareWith) {
        if (current.getFullName().compareTo(compareWith.getFullName()) < 0 ) {
            return -1;
        }

        if (current.getFullName().compareTo(compareWith.getFullName()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
