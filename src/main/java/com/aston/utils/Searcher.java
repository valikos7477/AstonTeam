package com.aston.utils;

import com.aston.Data.enums.Sorter;

import java.util.Collections;
import java.util.List;


public abstract class Searcher {

    /**
     * Поиск элемента в списке с использованием бинарного поиска.
     *
     * @param list Список элементов, в котором выполняется поиск.
     * @param key  Элемент, который нужно найти.
     * @param mode Режим сортировки (по возрастанию или убыванию).
     * @return Индекс элемента в списке или -1, если элемент не найден.
     */
    public static <T extends Comparable<T>> int search(List<T> list, T key, Sorter mode) {
        if (list == null || list.isEmpty()) {
            return -1; // Если список пуст, возвращаем -1
        }

        // Сортируем список в соответствии с выбранным режимом
        SortingEngine.sort(list, mode);

        // Используем встроенный бинарный поиск для нахождения элемента
        int index = Collections.binarySearch(list, key, mode.getComparator());

        // Если индекс отрицательный, элемент не найден
        return index >= 0 ? index : -1;
    }
}

