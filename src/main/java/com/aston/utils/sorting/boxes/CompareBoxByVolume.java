package com.aston.utils.sorting.boxes;

import com.aston.entities.Box;

public class CompareBoxByVolume implements BoxSortingRule {
    @Override
    public int doSortingByField(Box current, Box compareWith) {
        if (current.getVolume() < compareWith.getVolume()) {
            return -1;
        }

        if (current.getVolume() > compareWith.getVolume()) {
            return 1;
        }

        return 0;
    }
}
