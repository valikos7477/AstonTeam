package com.aston.Sorting.Boxes;

import com.aston.entities.Box;

public class CompareByMaterials implements BoxSorting{

    @Override
    public Integer sort(Box current, Box willBe) {
        return Integer.compare(current.getBoxMaterial().compareTo(willBe.getBoxMaterial()),0);
    }
}
