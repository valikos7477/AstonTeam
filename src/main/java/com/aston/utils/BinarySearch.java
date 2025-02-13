package com.aston.utils;

import java.util.Comparator;
import java.util.List;


public class BinarySearch<T extends Comparable<T>> {
    private final List<T> list;
    private final Comparator<T> comparator;

    // Конструктор, который сохраняет список и компаратор
    public BinarySearch(List<T> list, Comparator<T> comparator) {
        this.list = list;
        this.comparator = comparator;
    }

    // Метод бинарного поиска
    public int search(T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = list.get(mid);

            // Используем компаратор для сравнения
            int cmp = comparator.compare(midVal, key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -1; // Элемент не найден
    }
}