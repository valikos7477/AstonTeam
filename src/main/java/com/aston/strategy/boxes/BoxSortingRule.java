package com.aston.strategy.boxes;

import com.aston.entities.Box;

public interface BoxSortingRule {
    int doSortingByField(Box current, Box compareWith);
}
