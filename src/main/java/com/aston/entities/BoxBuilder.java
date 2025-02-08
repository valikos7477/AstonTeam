package com.aston.entities;

import com.aston.enums.BoxMaterial;
import com.aston.enums.StoredMaterial;
import com.aston.utils.RandomTools;

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
        return box;
    }

    public Box randomBuild() {
        Box box = new Box();
        box.setBoxMaterial(RandomTools.getRandomBoxMaterial());
        box.setStoredMaterial(RandomTools.getRandomStoredMaterial());
        box.setVolume(RandomTools.randInt(1, 1000));
        return box;
    }
}
