package com.aston;

import com.aston.uikit.DataSetGenerator;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        //------Infinity loop---------
        for (;;) {
            Integer entityChoice = 0;
            Integer dataSourceChoice = 0;
            Integer numberOfElements = 0;
            String inputFileName = "";

            //------выбираем с чем работать------
            while (true) {
                try {
                    System.out.println("\nС чем будем работать:\n 1. Люди\n 2. Животные\n 3. Бочки\n 0. Выход из программы\n");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ваш выбор: ");
                    String entityChoiceStr = scanner.nextLine().toLowerCase();
                    entityChoice = Integer.valueOf(entityChoiceStr);

                    if (entityChoice >= 0 && entityChoice <= 3) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nНекорректный ввод значения. Введите значение от 1 до 3, для выхода - 0");
                }
            }
            if (entityChoice == 0) System.exit(0);

            //------выбираем источник ввода------
            while (true) {
                try {
                    System.out.println("\nВведите источник данных: ");
                    System.out.println("1. Ручной ввод\n2. Рандом\n3. Файл\n0. Выход из программы\n");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ваш выбор: ");
                    String inputSourceSrc = scanner.nextLine().toLowerCase();
                    dataSourceChoice = Integer.valueOf(inputSourceSrc);

                    if (dataSourceChoice >= 0 && dataSourceChoice <= 3) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nНекорректный ввод значения. Введите значение от 1 до 3, для выхода - 0");
                }
            }
            if (dataSourceChoice == 0) System.exit(0);
            if (dataSourceChoice == 3) {
                while (true) {
                    System.out.println("\nВведите имя файла: ");
                    Scanner scanner = new Scanner(System.in);
                    String fileName = scanner.nextLine().toLowerCase();

                    Path path = FileSystems.getDefault().getPath(fileName);
                    if (!Files.exists(path)) {
                        System.out.println("\nФайл не существует");
                    }
                    else {
                        inputFileName = fileName;
                        break;
                    }
                }
            }

            //------выбираем количество элементов------
            while (true) {
                try {
                    System.out.println("\nВведите количество генерируемых элементов: ");
                    Scanner scanner = new Scanner(System.in);
                    String numOfElementsStr = scanner.nextLine().toLowerCase();
                    numberOfElements = Integer.valueOf(numOfElementsStr);
                } catch (NumberFormatException e) {
                    System.out.println("\nВведите целочисленное значение");
                }
                if (numberOfElements > 0) break;
            }

            String message = "entity=" + entityChoice +
                             "&source=" + dataSourceChoice +
                             "&num=" + numberOfElements +
                             "&filename=" + inputFileName;

            List<Comparable> elems = DataSetGenerator.inputMessage(message);
            elems.forEach(System.out::println);
        }
    }
}
