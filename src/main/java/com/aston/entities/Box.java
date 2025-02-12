package com.aston.entities;

import com.aston.Data.enums.BoxMaterial;
import com.aston.Data.enums.StoredMaterial;
import com.aston.Sorting.Boxes.BoxSorting;

public class Box implements Comparable {
    private BoxMaterial boxMaterial;
    private StoredMaterial storedMaterial;
    private Integer volume;

    private BoxSorting strategy;

    public void setupSortingStrategy(BoxSorting strategy) {
        this.strategy = strategy;
    }

    @Override
    public int compareTo(Object o) {
        Box obj = (Box) o;
        return strategy.sort(this, obj);
    }

    @Override
    public String toString() {
        return "BOX#" +
                "boxMaterial=" + boxMaterial +
                ";storedMaterial=" + storedMaterial +
                ";volume=" + volume;
    }

    public void setBoxMaterial(BoxMaterial boxMaterial) {
        this.boxMaterial = boxMaterial;
    }

    public void setStoredMaterial(StoredMaterial storedMaterial) {
        this.storedMaterial = storedMaterial;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public BoxMaterial getBoxMaterial() {
        return boxMaterial;
    }

    public StoredMaterial getStoredMaterial() {
        return storedMaterial;
    }

    public Integer getVolume() {
        return volume;
    }
}