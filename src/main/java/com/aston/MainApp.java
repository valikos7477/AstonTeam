package com.aston;


import com.aston.EnumsForApp.DataSourceChoice;
import com.aston.EnumsForApp.EntityChoice;
import com.aston.userio.DataSetGenerator;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {

    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                EntityChoice entityChoice = chooseEntity();
                if (entityChoice == EntityChoice.EXIT) {
                    System.exit(0);
                }

                DataSourceChoice dataSourceChoice = chooseDataSource();
                if (dataSourceChoice == DataSourceChoice.EXIT) {
                    System.exit(0);
                }

                String inputFileName = "";
                if (dataSourceChoice == DataSourceChoice.FILE) {
                    inputFileName = chooseFileName();
                }

                int numberOfElements = chooseNumberOfElements();

                String message = String.format("entity=%d&source=%d&num=%d&filename=%s",
                        entityChoice.ordinal(), dataSourceChoice.ordinal(), numberOfElements, inputFileName);

                List<Comparable> elements = DataSetGenerator.inputMessage(message);
                elements.forEach(System.out::println);

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "An error occurred: ", e);
                System.out.println("Произошла ошибка. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static EntityChoice chooseEntity() {
        while (true) {
            try {
                System.out.println("\nС чем будем работать:");
                for (EntityChoice choice : EntityChoice.values()) {
                    System.out.println(choice.getDescription());
                }
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                return EntityChoice.fromInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число от 0 до 3.");
            }
        }
    }

    private static DataSourceChoice chooseDataSource() {
        while (true) {
            try {
                System.out.println("\nВведите источник данных:");
                for (DataSourceChoice choice : DataSourceChoice.values()) {
                    System.out.println(choice.getDescription());
                }
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                return DataSourceChoice.fromInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число от 0 до 3.");
            }
        }
    }

    private static String chooseFileName() {
        while (true) {
            System.out.println("\nВведите имя файла:");
            String fileName = SCANNER.nextLine().toLowerCase();
            Path path = FileSystems.getDefault().getPath(fileName);
            if (Files.exists(path)) {
                return fileName;
            }
            System.out.println("Файл не существует. Пожалуйста, введите правильное имя файла.");
        }
    }

    private static int chooseNumberOfElements() {
        while (true) {
            try {
                System.out.println("\nВведите количество генерируемых элементов:");
                int numberOfElements = Integer.parseInt(SCANNER.nextLine());
                if (numberOfElements > 0) {
                    return numberOfElements;
                }
                System.out.println("Количество элементов должно быть больше 0.");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }
    }
}