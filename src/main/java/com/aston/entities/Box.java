package com.aston.entities;

import com.aston.enums.BoxMaterial;
import com.aston.enums.StoredMaterial;
import com.aston.utils.sorting.boxes.BoxSortingRule;

public class Box implements Comparable {
    private BoxMaterial boxMaterial;
    private StoredMaterial storedMaterial;
    private Integer volume;

    private BoxSortingRule strategy;

    public void setupSortingStrategy(BoxSortingRule strategy) {
        this.strategy = strategy;
    }

    @Override
    public int compareTo(Object o) {
        Box obj = (Box) o;
        return strategy.doSortingByField(this, obj);
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
