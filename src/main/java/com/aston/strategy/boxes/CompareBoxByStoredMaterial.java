package com.aston.strategy.boxes;

import com.aston.entities.Box;

public class CompareBoxByStoredMaterial implements BoxSortingRule {
    @Override
    public int doSortingByField(Box current, Box compareWith) {
        return Integer.compare(current.getStoredMaterial().compareTo(compareWith.getStoredMaterial()), 0);
    }
}
