package com.aston.strategy.boxes;

import com.aston.entities.Box;

public class CompareBoxByVolume implements BoxSortingRule {
    @Override
    public int doSortingByField(Box current, Box compareWith) {
        return Integer.compare(current.getVolume().compareTo(compareWith.getVolume()), 0);
    }
}
