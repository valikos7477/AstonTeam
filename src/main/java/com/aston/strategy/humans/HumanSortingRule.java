package com.aston.strategy.humans;

import com.aston.entities.Human;

public interface HumanSortingRule {
    int doSortingByField(Human current, Human compareWith);
}
