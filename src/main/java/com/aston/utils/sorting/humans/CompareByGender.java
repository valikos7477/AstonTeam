package com.aston.utils.sorting.humans;

import com.aston.entities.Human;

public class CompareByGender implements HumanSortingRule {
    @Override
    public int doSortingByField(Human current, Human compareWith) {
        if (current.getGender().compareTo(compareWith.getGender()) < 0 ) {
            return -1;
        }

        if (current.getGender().compareTo(compareWith.getGender()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
