package com.aston;

import java.util.Arrays;
import java.util.List;

import com.aston.entities.Sortable;
import com.aston.utils.SortingEngine;
import com.aston.tools.CustomArrayList;

public class MainApp {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,34,2,200,124,44,22,325,200,200 };

        SortingEngine.insertSorting(array);
        List<Integer> arrayAsList = Arrays.asList(array);
        arrayAsList.stream().forEach(System.out::println);

        List<Sortable> list = new CustomArrayList<>();


    }
}
