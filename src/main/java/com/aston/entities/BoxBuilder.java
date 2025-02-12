package com.aston.entities;

import com.aston.Data.enums.BoxMaterial;
import com.aston.Data.enums.StoredMaterial;
import com.aston.utils.Randomer;
import com.aston.Sorting.Boxes.CompareByVolume;

public class BoxBuilder {
    private BoxMaterial boxMaterial;
    private StoredMaterial storedMaterial;
    private Integer volume;

    public BoxBuilder setupBoxMaterial(BoxMaterial boxMaterial) {
        this.boxMaterial = boxMaterial;
        return this;
    }

    public BoxBuilder setupStoredMaterial(StoredMaterial storedMaterial) {
        this.storedMaterial = storedMaterial;
        return this;
    }

    public BoxBuilder setupVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public Box build() {
        Box box = new Box();
        box.setBoxMaterial(boxMaterial);
        box.setStoredMaterial(storedMaterial);
        box.setVolume(volume);
        box.setupSortingStrategy(new CompareByVolume());
        return box;
    }

    public Box randomBuild() {
        Box box = new Box();
        box.setBoxMaterial(Randomer.getRandomBoxMaterial());
        box.setStoredMaterial(Randomer.getRandomStoredMaterial());
        box.setVolume(Randomer.randInt(1, 1000));
        box.setupSortingStrategy(new CompareByVolume());
        return box;
    }
}
