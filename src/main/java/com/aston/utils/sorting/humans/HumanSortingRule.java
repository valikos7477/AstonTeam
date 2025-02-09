package com.aston.utils.sorting.humans;

import com.aston.entities.Human;

public interface HumanSortingRule {
    int doSortingByField(Human current, Human compareWith);
}
