package com.aston.Data.enums;

import java.util.Comparator;

public enum SortingMode {
    ANIMAL_TYPE,
    ANIMAL_EYE_COLOR,
    ANIMAL_WEIGHT,
    BOX_MATERIAL,
    BOX_STORED_MATERIAL,
    BOX_VOLUME,
    HUMAN_NAME,
    HUMAN_AGE,
    HUMAN_GENDER,

    ASCENDING(Comparator.naturalOrder()),

    DESCENDING(Comparator.reverseOrder());

    private Comparator<?> comparator;

    SortingMode(Comparator<?> comparator) {
        this.comparator = comparator;
    }

    SortingMode() {

    }

    @SuppressWarnings("unchecked")
    public <T> Comparator<T> getComparator() {
        return (Comparator<T>) comparator;
    }
}
