package com.aston.utils;

import com.aston.datatypes.enums.SortingMode;
import com.aston.entities.Animal;
import com.aston.entities.Box;
import com.aston.entities.Human;
import com.aston.strategy.animals.AnimalSortingRule;
import com.aston.strategy.animals.CompareAnimalByEyeColor;
import com.aston.strategy.animals.CompareAnimalByType;
import com.aston.strategy.animals.CompareAnimalByWeight;
import com.aston.strategy.boxes.BoxSortingRule;
import com.aston.strategy.boxes.CompareBoxByMaterial;
import com.aston.strategy.boxes.CompareBoxByStoredMaterial;
import com.aston.strategy.boxes.CompareBoxByVolume;
import com.aston.strategy.humans.CompareByAge;
import com.aston.strategy.humans.CompareByGender;
import com.aston.strategy.humans.CompareByName;
import com.aston.strategy.humans.HumanSortingRule;

import java.util.List;

public abstract class SortingEngine {

    private static void changeHumansSortingOrder (List list, HumanSortingRule newStrategy) {
        list.forEach( elem -> {
            ((Human)elem).setupSortingStrategy(newStrategy);
        });
    }

    private static void changeAnimalsSortingOrder (List list, AnimalSortingRule newStrategy) {
        list.forEach( elem -> {
            ((Animal)elem).setupSortingStrategy(newStrategy);
        });
    }

    private static void changeBoxesSortingOrder (List list, BoxSortingRule newStrategy) {
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
            SortingEngine.changeAnimalsSortingOrder(list, new CompareAnimalByEyeColor());
        } else if (mode == SortingMode.ANIMAL_TYPE) {
            SortingEngine.changeAnimalsSortingOrder(list, new CompareAnimalByType());
        } else if (mode == SortingMode.ANIMAL_WEIGHT) {
            SortingEngine.changeAnimalsSortingOrder(list, new CompareAnimalByWeight());
        } else if (mode == SortingMode.BOX_VOLUME) {
            SortingEngine.changeBoxesSortingOrder(list, new CompareBoxByVolume());
        } else if (mode == SortingMode.BOX_MATERIAL) {
            SortingEngine.changeBoxesSortingOrder(list, new CompareBoxByMaterial());
        } else {
            SortingEngine.changeBoxesSortingOrder(list, new CompareBoxByStoredMaterial());
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
