package com.aston.utils.sorting.boxes;

import com.aston.entities.Box;

public interface BoxSortingRule {
    int doSortingByField(Box current, Box compareWith);
}
