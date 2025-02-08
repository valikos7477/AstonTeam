package com.aston.entities;

import com.aston.enums.BoxMaterial;
import com.aston.enums.StoredMaterial;

public class Box implements Sortable {

    private final BoxMaterial boxMaterial;
    private final StoredMaterial storedMaterial;
    private final int volume;

    private Box(Builder builder) {
        this.boxMaterial = builder.boxMaterial;
        this.storedMaterial = builder.storedMaterial;
        this.volume = builder.volume;
    }



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
        return "Box{" +
                "boxMaterial=" + boxMaterial +
                ", storedMaterial=" + storedMaterial +
                ", volume=" + volume +
                '}';
    }

    public static class Builder{
        private  BoxMaterial boxMaterial;
        private  StoredMaterial storedMaterial;
        private  int volume;

        public Builder setBoxMaterial(BoxMaterial boxMaterial){
            this.boxMaterial=boxMaterial;
            return this;
        }
        public Builder setStoredMaterial(StoredMaterial storedMaterial){
            this.storedMaterial=storedMaterial;
            return this;
        }
        public Builder setVolume(int volume){
            this.volume=volume;
            return this;
        }

        public Box build(){
            return new Box(this);
        }
    }
}
