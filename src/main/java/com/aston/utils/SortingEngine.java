package com.aston.utils;

import com.aston.Data.enums.SortingMode;
import com.aston.entities.Animal;
import com.aston.entities.Box;
import com.aston.entities.Human;
import com.aston.Sorting.Animals.AnimalSorting;
import com.aston.Sorting.Animals.CompareByEyeColor;
import com.aston.Sorting.Animals.CompareByAnimalType;
import com.aston.Sorting.Animals.CompareByWeight;
import com.aston.Sorting.Boxes.BoxSorting;
import com.aston.Sorting.Boxes.CompareByMaterials;
import com.aston.Sorting.Boxes.CompareByStoredMaterial;
import com.aston.Sorting.Boxes.CompareByVolume;
import com.aston.Sorting.Humans.CompareByAge;
import com.aston.Sorting.Humans.CompareByGender;
import com.aston.Sorting.Humans.CompareByName;
import com.aston.Sorting.Humans.HumanSortingRule;

import java.util.List;

public abstract class SortingEngine {

    private static void changeHumansSortingOrder (List list, HumanSortingRule newStrategy) {
        list.forEach( elem -> {
            ((Human)elem).setupSortingStrategy(newStrategy);
        });
    }

    private static void changeAnimalsSortingOrder (List list,  AnimalSorting newStrategy) {
        list.forEach( elem -> {
            ((Animal)elem).setupSortingStrategy(newStrategy);
        });
    }

    private static void changeBoxesSortingOrder (List list, BoxSorting newStrategy) {
        list.forEach( elem -> {
            ((Box)elem).setupSortingStrategy(newStrategy);
        });
    }

    public static <T extends Comparable<T>> void sort(List<T> list, SortingMode mode) {
        //public static <T extends Comparable<T>> void insertSorting (CustomArrayList<T> list) {

        if (mode == SortingMode.HUMAN_NAME) {
            SortingEngine.changeHumansSortingOrder(list, new CompareByName());
        } else if (mode == SortingMode.HUMAN_AGE) {
            SortingEngine.changeHumansSortingOrder(list, new CompareByAge());
        } else if (mode == SortingMode.HUMAN_GENDER) {
            SortingEngine.changeHumansSortingOrder(list, new CompareByGender());
        } else if (mode == SortingMode.ANIMAL_EYE_COLOR) {
            SortingEngine.changeAnimalsSortingOrder(list, new CompareByEyeColor());
        } else if (mode == SortingMode.ANIMAL_TYPE) {
            SortingEngine.changeAnimalsSortingOrder(list, new CompareByAnimalType());
        } else if (mode == SortingMode.ANIMAL_WEIGHT) {
            SortingEngine.changeAnimalsSortingOrder(list, new CompareByWeight());
        } else if (mode == SortingMode.BOX_VOLUME) {
            SortingEngine.changeBoxesSortingOrder(list, new CompareByVolume());
        } else if (mode == SortingMode.BOX_MATERIAL) {
            SortingEngine.changeBoxesSortingOrder(list, new CompareByMaterials());
        } else {
            SortingEngine.changeBoxesSortingOrder(list, new CompareByStoredMaterial());
        }

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