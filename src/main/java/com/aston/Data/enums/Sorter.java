package com.aston.Data.enums;

import java.util.Comparator;

public enum Sorter {

        ASCENDING(Comparator.naturalOrder()),

        DESCENDING(Comparator.reverseOrder());

        private final Comparator<?> comparator;

        Sorter(Comparator<?> comparator) {
            this.comparator = comparator;
        }

        @SuppressWarnings("unchecked")
        public <T> Comparator<T> getComparator() {
            return (Comparator<T>) comparator;
        }
    }




