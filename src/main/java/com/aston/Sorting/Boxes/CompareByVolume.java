package com.aston.Sorting.Boxes;

import com.aston.entities.Box;

public class CompareByVolume implements BoxSorting{

    @Override
    public Integer sort(Box current, Box willBe) {
        return Integer.compare(current.getVolume().compareTo(willBe.getVolume()),0);
    }
}
