package com.aston.entities;

import com.aston.enums.BoxMaterial;
import com.aston.enums.StoredMaterial;

public class Box implements Sortable {
    private BoxMaterial boxMaterial;
    private StoredMaterial storedMaterial;
    private Integer volume;



    @Override
    public void sortByFirstField() {

    }

    @Override
    public void sortBySecondField() {

    }

    @Override
    public void sortByThirdField() {

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
}
