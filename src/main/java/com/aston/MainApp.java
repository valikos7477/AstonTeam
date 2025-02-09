package com.aston;

import java.util.List;
import java.util.ArrayList;
import com.aston.entities.*;
import com.aston.utils.SortingEngine;
import com.aston.utils.sorting.animals.*;
import com.aston.utils.sorting.boxes.*;
import com.aston.utils.sorting.humans.*;


public class MainApp {
    public static void main(String[] args) {
        List<Comparable> animals = new ArrayList<>();
        AnimalBuilder animalBuilder = new AnimalBuilder();
        for (int i = 0; i < 10; i++) {
            Animal animal = animalBuilder.randomBuild();
            animal.setupSortingStrategy(new CompareAnimalByType());
            animals.add(animal);
        }

        SortingEngine.insertSorting(animals);
        System.out.println("\n*************");
        animals.forEach(System.out::println);

        List<Comparable> boxes = new ArrayList<>();
        BoxBuilder boxBuilder = new BoxBuilder();
        for (int i = 0; i < 10; i++) {
            Box box = boxBuilder.randomBuild();
            box.setupSortingStrategy(new CompareBoxByMaterial());
            boxes.add(box);
        }

        SortingEngine.insertSorting(boxes);
        System.out.println("\n*************");
        boxes.forEach(System.out::println);

        List<Comparable> humans = new ArrayList<>();
        HumanBuilder humanBuilder = new HumanBuilder();
        for (int i = 0; i < 10; i++) {
            Human human = humanBuilder.randomBuild();
            human.setupSortingStrategy(new CompareByName());
            humans.add(human);
        }

        SortingEngine.insertSorting(humans);
        System.out.println("\n*************");
        humans.forEach(System.out::println);
    }
}
