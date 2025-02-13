package com.aston.uikit.manipulators;

import java.util.List;

public abstract class AbstractDataManipulator {
    protected List<Comparable> elements;

    public AbstractDataManipulator(List<Comparable> elements) {
        this.elements = elements;
    }

    public List<Comparable> getElements() {
        return elements;
    }

    public abstract void manipulateCollection();
}
