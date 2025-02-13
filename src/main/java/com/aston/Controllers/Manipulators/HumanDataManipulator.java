package com.aston.Controllers.Manipulators;

import com.aston.Controllers.Manipulators.AbstractDataManipulator;
import com.aston.Data.enums.SortingMode;
import com.aston.utils.FileOperations;
import com.aston.utils.SortingEngine;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HumanDataManipulator extends AbstractDataManipulator {
    public HumanDataManipulator(List<Comparable> elements) {
        super(elements);
    }

    private void showMenu() {
        System.out.println("\n*******************************************");
        System.out.println("1. Сортировка по полю 'Имя'");
        System.out.println("2. Сортировка по полю 'Возраст'");
        System.out.println("3. Сортировка по полю 'Пол'");
        System.out.println("4. Сохранить во внешний файл");
        System.out.println("0. Выход в главное меню");
    }

    @Override
    public void manipulateCollection() {
        Scanner scanner = new Scanner(System.in);
        Integer actionChoice = 0;

        while (true) {
            while(true) {
                try {
                    showMenu();
                    System.out.println("\nВаш выбор: ");
                    String actionChoiceStr = scanner.nextLine();
                    actionChoice = Integer.valueOf(actionChoiceStr);
                    if (actionChoice >= 0 && actionChoice <= 4)
                        break;
                } catch (NumberFormatException exception) {
                    System.out.println("\nНекорректный ввод значения. Введите целочисленное значение от 0 до 4");
                }
            }

            if (actionChoice == 0) break;

            if (actionChoice == 1) {
                SortingEngine.sort(elements, SortingMode.HUMAN_NAME);
            } else if (actionChoice == 2) {
                SortingEngine.sort(elements, SortingMode.HUMAN_AGE);
            } else if (actionChoice == 3) {
                SortingEngine.sort(elements, SortingMode.HUMAN_GENDER);
            }
            else {
                System.out.println("\nВведите имя файла для выгрузки: ");
                String outputFileName = scanner.nextLine();
                FileOperations.saveToFile(elements,outputFileName, true);
                //                FileOperations.saveToFile(elements,outputFileName, true);
            }
            System.out.println("******ТЕКУЩЕЕ СОСТОЯНИЕ КОЛЛЕКЦИИ**********");
            elements.forEach(System.out::println);
        }
    }
}