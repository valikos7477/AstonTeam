package com.aston;

import java.util.List;
import java.util.Scanner;

import com.aston.datatypes.enums.SortingMode;
import com.aston.entities.*;
import com.aston.datatypes.collections.CustomArrayList;
import com.aston.strategy.humans.CompareByAge;
import com.aston.utils.FileOperations;
import com.aston.utils.OperationRunner;
import com.aston.utils.SearchEngine;
import com.aston.utils.SortingEngine;


public class MainApp {
    public static void main(String[] args) {
        int entityChoice;
        int loadFromChoice;
        int numberOfElements;
        OperationRunner runner = new OperationRunner();

        while (true) {
            try {
                System.out.println("\nС чем будем работать:\n 1. Люди\n 2. Животные\n 3. Бочки\n 0. Выход\n");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ваш выбор: ");
                String entityChoiceStr = scanner.nextLine().toLowerCase();
                entityChoice = Integer.valueOf(entityChoiceStr);
            } catch (NumberFormatException e) {
                System.out.println("\nНекорректный ввод значения. Введите значение от 1 до 3, для выхода - 0");
                continue;
            }
            if (entityChoice == 0) break;
            if (entityChoice < 0 || entityChoice > 3) {
                System.out.println("\nНекорректный ввод значения. Введите значение от 1 до 3, для выхода - 0");
                continue;
            }

            try {
                System.out.println("\nМетод ввода данных:\n 1. Ручной\n 2. Автоматизированный\n 3. Из файла\n 0. Выход\n");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ваш выбор: ");
                String loadFromStr = scanner.nextLine().toLowerCase();
                loadFromChoice = Integer.valueOf(loadFromStr);
            } catch (NumberFormatException e) {
                System.out.println("\nНекорректный ввод значения. Введите значение от 1 до 3, для выхода - 0");
                continue;
            }

            if (loadFromChoice == 0) break;
            if (loadFromChoice < 0 || loadFromChoice > 3) {
                System.out.println("\nНекорректный ввод значения. Введите значение от 1 до 3, для выхода - 0");
                continue;
            }

            try {
                System.out.println("\nВведите количество элементов для ввода:\n");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Количество элементов для ввода: ");
                String numberOfElementsStr = scanner.nextLine().toLowerCase();
                numberOfElements = Integer.valueOf(numberOfElementsStr);
            } catch (NumberFormatException e) {
                System.out.println("\nНекорректный ввод значения. Введите целочисленное значение");
                continue;
            }
        }






















//        System.out.println("\n-------------");
//        List<Comparable> elements = FileOperations.loadFromFile("examples_humans.txt");
//        SortingEngine.sort(elements, SortingMode.HUMAN_AGE);
//        System.out.println("\n==========");
//        elements.forEach(System.out::println);

//        List<Comparable> animals = new CustomArrayList<>();
//        AnimalBuilder animalBuilder = new AnimalBuilder();
//        for (int i = 0; i < 1000; i++) {
//            Animal animal = animalBuilder.randomBuild();
//            animals.add(animal);
//        }

//        FileOperations.saveToFile(animals, "examples_animals.txt", false);

        //
//        SortingEngine.sort(humans, SortingMode.HUMAN_AGE);
//        System.out.println("\n==========");
//        humans.forEach(System.out::println);
//
//        SortingEngine.sort(humans, SortingMode.HUMAN_GENDER);
//        System.out.println("\n==========");
//        humans.forEach(System.out::println);


//        System.out.println("\n-------------");
//        List<Comparable> animals = FileOperations.loadFromFile("animals.txt");
//        animals.forEach(System.out::println);
//
//        SortingEngine.sort(animals, SortingMode.ANIMAL_TYPE);
//        System.out.println("\n==========");
//        animals.forEach(System.out::println);



//        List<Comparable> animals = new CustomArrayList<>();
//        AnimalBuilder animalBuilder = new AnimalBuilder();
//        for (int i = 0; i < 10; i++) {
//            Animal animal = animalBuilder.randomBuild();
//            animals.add(animal);
//        }
//
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите вес животного: ");
//        String weight = scanner.nextLine().toLowerCase();
//
//
//        AnimalBuilder animalBuilder2 = new AnimalBuilder();
//        Animal animal = animalBuilder2.setupWeight(Integer.valueOf(weight)).build();
//        int result = SearchEngine.search(animals, animal, SortingMode.ANIMAL_WEIGHT);
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);
//        System.out.println(animal + " - }}}" + result);

//        SortingEngine.sort(animals, SortingMode.ANIMAL_WEIGHT);
//        System.out.println("\n*************");
//        animals.forEach(System.out::println);
//
//        SortingEngine.sort(animals, SortingMode.ANIMAL_TYPE);
//        System.out.println("\n--------------");
//        animals.forEach(System.out::println);
//
//        SortingEngine.sort(animals, SortingMode.ANIMAL_WEIGHT);
//        System.out.println("\n==========");
//        animals.forEach(System.out::println);
//
//        FileOperations.saveToFile(animals, "animals.txt", false);
//
//        System.out.println("\n-------------");
//        List<Comparable> humans = FileOperations.loadFromFile("humans.txt");
//        SortingEngine.sort(humans, SortingMode.HUMAN_NAME);
//        System.out.println("\n==========");
//        humans.forEach(System.out::println);
//
//        SortingEngine.sort(humans, SortingMode.HUMAN_AGE);
//        System.out.println("\n==========");
//        humans.forEach(System.out::println);

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите возраст: ");
//        String age = scanner.nextLine().toLowerCase();
//
//        HumanBuilder humanBuilder = new HumanBuilder();
//        Human human = humanBuilder.setupAge(Integer.valueOf(age)).build();
//
//        int result = SearchEngine.search(humans, human, SortingMode.HUMAN_AGE);
//        System.out.println(human+ " - }}}" + result);

        //
//        System.out.println("+++++");
//        humans.forEach(System.out::println);

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
