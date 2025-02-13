package com.aston.Controllers;

import com.aston.Data.enums.*;
import com.aston.entities.Animal;
import com.aston.entities.AnimalBuilder;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class AnimalViewController {

        private static final Logger LOGGER = Logger.getLogger(AnimalViewController.class.getName());
        private static final Scanner SCANNER = new Scanner(System.in);

        public Animal UIDialogAnimal() {
            AnimalType type = chooseAnimalType();
            EyeColor color = chooseEyeColor();
            int weight = chooseWeight();
            boolean hasFur = chooseHasFur();

            AnimalBuilder builder = new AnimalBuilder();
            return builder.setupType(type)
                    .setupEyeColor(color)
                    .setupWeight(weight)
                    .setupFur(hasFur)
                    .build();
        }

        private AnimalType chooseAnimalType() {
            while (true) {
                try {
                    System.out.println("\nВведите тип животного:");
                    for (AnimalTypeChoice choice : AnimalTypeChoice.values()) {
                        System.out.println(choice.getDescription());
                    }
                    System.out.print("Ваш выбор: ");
                    int choice = Integer.parseInt(SCANNER.nextLine());
                    return AnimalTypeChoice.fromInt(choice).getAnimalType();
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Введите число от 1 до 4.");
                }
            }
        }

        private EyeColor chooseEyeColor() {
            while (true) {
                try {
                    System.out.println("\nВведите цвет глаз:");
                    for (EyeColorChoice choice : EyeColorChoice.values()) {
                        System.out.println(choice.getDescription());
                    }
                    System.out.print("Ваш выбор: ");
                    int choice = Integer.parseInt(SCANNER.nextLine());
                    return EyeColorChoice.fromInt(choice).getEyeColor();
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Введите число от 1 до 5.");
                }
            }
        }

        private int chooseWeight() {
            while (true) {
                try {
                    System.out.println("\nВведите вес животного (1 - 5000 кг):");
                    int weight = Integer.parseInt(SCANNER.nextLine());
                    if (weight >= 1 && weight <= 5000) {
                        return weight;
                    }
                    System.out.println("Вес должен быть в диапазоне от 1 до 5000 кг.");
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Введите целое число.");
                }
            }
        }

        private boolean chooseHasFur() {
            while (true) {
                try {
                    System.out.println("\nПризнак наличия шерсти:");
                    for (HasFurChoice choice : HasFurChoice.values()) {
                        System.out.println(choice.getDescription());
                    }
                    System.out.print("Ваш выбор: ");
                    int choice = Integer.parseInt(SCANNER.nextLine());
                    return HasFurChoice.fromInt(choice).hasFur();
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Введите число 1 или 2.");
                }
            }
        }
    }
