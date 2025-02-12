package com.aston.Sorting.Humans;

import com.aston.entities.Human;

public interface HumanSortingRule {
    int sortByField(Human humanCurrent, Human compareWith);
}
