package com.aston.utils.sorting.boxes;

import com.aston.entities.Box;

public class CompareBoxByStoredMaterial implements BoxSortingRule {
    @Override
    public int doSortingByField(Box current, Box compareWith) {
        if (current.getStoredMaterial().compareTo(compareWith.getStoredMaterial()) < 0 ) {
            return -1;
        }

        if (current.getStoredMaterial().compareTo(compareWith.getStoredMaterial()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
