package com.aston.utils;

import java.util.List;

public abstract class SortingEngine {
    public static <T extends Comparable<T>> void insertSorting (List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int j = i - 1;
            while(j >= 0 && current.compareTo(list.get(j)) < 0) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, current);
        }
    }
}
