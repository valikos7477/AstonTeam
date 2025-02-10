package com.aston.utils;

import com.aston.entities.Animal;
import com.aston.entities.Box;
import com.aston.entities.Human;
import com.aston.tools.CustomArrayList;
import com.aston.utils.sorting.animals.AnimalSortingRule;
import com.aston.utils.sorting.boxes.BoxSortingRule;
import com.aston.utils.sorting.humans.HumanSortingRule;

import java.util.List;

public abstract class SortingEngine {
    public static <T extends Comparable<T>> void insertSorting (List<T> list) {
    //public static <T extends Comparable<T>> void insertSorting (CustomArrayList<T> list) {
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

    public static void changeHumansSortingOrder (List<Comparable> list, HumanSortingRule newStrategy) {
        list.forEach( elem -> {
            ((Human)elem).setupSortingStrategy(newStrategy);
        });
    }

    public static void changeAnimalsSortingOrder (List<Comparable> list, AnimalSortingRule newStrategy) {
        list.forEach( elem -> {
            ((Animal)elem).setupSortingStrategy(newStrategy);
        });
    }

    public static void changeBoxesSortingOrder (List<Comparable> list, BoxSortingRule newStrategy) {
        list.forEach( elem -> {
            ((Box)elem).setupSortingStrategy(newStrategy);
        });
    }
}
