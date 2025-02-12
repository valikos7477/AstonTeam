package com.aston.Sorting.Boxes;


import com.aston.entities.Box;

public class CompareByStoredMaterial implements BoxSorting {
    @Override
    public Integer sort(Box current, Box willBe) {
        return Integer.compare(current.getStoredMaterial().compareTo(willBe.getStoredMaterial()),0);
    }
}
