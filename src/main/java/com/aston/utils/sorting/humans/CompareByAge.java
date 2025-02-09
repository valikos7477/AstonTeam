package com.aston.utils.sorting.humans;

import com.aston.entities.Human;

public class CompareByAge implements HumanSortingRule {
    @Override
    public int doSortingByField(Human current, Human compareWith) {
        if (current.getAge().compareTo(compareWith.getAge()) < 0 ) {
            return -1;
        }

        if (current.getAge().compareTo(compareWith.getAge()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
