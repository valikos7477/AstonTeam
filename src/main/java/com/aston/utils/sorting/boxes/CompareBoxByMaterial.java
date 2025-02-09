package com.aston.utils.sorting.boxes;

import com.aston.entities.Box;

public class CompareBoxByMaterial implements BoxSortingRule {
    @Override
    public int doSortingByField(Box current, Box compareWith) {
        if (current.getBoxMaterial().compareTo(compareWith.getBoxMaterial()) < 0 ) {
            return -1;
        }

        if (current.getBoxMaterial().compareTo(compareWith.getBoxMaterial()) > 0 ) {
            return 1;
        }

        return 0;
    }
}
