package com.aston;

import java.util.List;

import com.aston.entities.*;
import com.aston.datatypes.collections.CustomArrayList;
import com.aston.utils.FileOperations;
import com.aston.utils.SortingEngine;


public class MainApp {
    public static void main(String[] args) {
        List<Comparable> humans = new CustomArrayList<>();
        HumanBuilder humanBuilder = new HumanBuilder();
        for (int i = 0; i < 100; i++) {
            Human human = humanBuilder.randomBuild();
            humans.add(human);
        }

        SortingEngine.insertSorting(humans);
        System.out.println("\n*************");
        humans.forEach(System.out::println);
        FileOperations.saveToFile(humans, "humans.txt", false);




//        SortingEngine.changeHumansSortingOrder(humans, new CompareByAge());
//        SortingEngine.insertSorting(humans);
//        FileOperations.saveToFile(humans, "humans.txt", true);
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Введите вес животного: ");
//        String animalWeight = scanner.nextLine().toLowerCase();
//
//        Animal animal2 = animalBuilder.setupWeight(Integer.valueOf(animalWeight)).build();
//
//        int result2 = SearchEngine.search(animals, animal2);
//        System.out.println(animal2 + " - }}}" + result2);
//
//        SortingEngine.changeAnimalsSortingOrder(animals, new CompareAnimalByEyeColor());
//        SortingEngine.insertSorting(animals);
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);
//
//        SortingEngine.changeAnimalsSortingOrder(animals, new CompareAnimalByType());
//        SortingEngine.insertSorting(animals);
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);
//
//        SortingEngine.changeAnimalsSortingOrder(animals, new CompareAnimalByWeight());
//        SortingEngine.insertSorting(animals);
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);

//        Human human  = (Human) humans.get(3);
//        int result = SearchEngine.search(humans, human);
//        System.out.println(human + " - >>>" + result);
//
//        String f1 = human.getFullName();
//        Integer f2 = human.getAge();
//        Gender f3 = human.getGender();
//
//        Human human2 = humanBuilder.setupFullName(f1)
//                .build();
//
//        int result2 = SearchEngine.search(humans, human2);
//        System.out.println(human2 + " - }}}" + result2);

        //        List<Comparable> animals = new ArrayList<>();
//        AnimalBuilder animalBuilder = new AnimalBuilder();
//        for (int i = 0; i < 5; i++) {
//            Animal animal = animalBuilder.randomBuild();
//            animal.setupSortingStrategy(new CompareAnimalByType());
//            animals.add(animal);
//        }
//
//        SortingEngine.insertSorting(animals);
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);

//
//        List<Comparable> boxes = new ArrayList<>();
//        BoxBuilder boxBuilder = new BoxBuilder();
//        for (int i = 0; i < 10; i++) {
//            Box box = boxBuilder.randomBuild();
//            box.setupSortingStrategy(new CompareBoxByMaterial());
//            boxes.add(box);
//        }
//
//        SortingEngine.insertSorting(boxes);
//        System.out.println("\n*************");
//        boxes.forEach(System.out::println);
//
//        List<Comparable> humans = new ArrayList<>();
//        HumanBuilder humanBuilder = new HumanBuilder();
//        for (int i = 0; i < 10; i++) {
//            Human human = humanBuilder.randomBuild();
//            human.setupSortingStrategy(new CompareByName());
//            humans.add(human);
//        }
//
//        SortingEngine.insertSorting(humans);
//        System.out.println("\n*************");
//        humans.forEach(System.out::println);
    }
}
