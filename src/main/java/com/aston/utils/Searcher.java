package com.aston.utils;

import com.aston.Data.enums.SortingMode;
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
    public static <T extends Comparable<T>> int search(List<T> list, T key, SortingMode mode) {
        if (list == null || list.isEmpty()) {
            return -1; // Если список пуст, возвращаем -1
        }

        // Сортируем список в соответствии с выбранным режимом
        SortingEngine.sort(list, mode);

        // Создаем объект BinarySearch и выполняем поиск
        BinarySearch<T> binarySearch = new BinarySearch<>(list, mode.getComparator());
        int index = binarySearch.search(key);

        // Если индекс отрицательный, элемент не найден
        return index >= 0 ? index : -1;
    }
}

