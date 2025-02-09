package com.aston.utils.sorting.boxes;

import com.aston.entities.Box;

public class CompareBoxByMaterial implements BoxSortingRule {
    @Override
    public int doSortingByField(Box current, Box compareWith) {
        return Integer.compare(current.getBoxMaterial().compareTo(compareWith.getBoxMaterial()), 0);
    }
}
