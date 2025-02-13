package com.aston.Controllers;
import com.aston.Data.enums.Gender;
import com.aston.entities.Human;
import com.aston.entities.HumanBuilder;

import java.util.Scanner;

public class HumanViewController {

    public Human UIDialogHuman() {
        String fullName = promptForFullName();
        int age = promptForAge();
        Gender gender = promptForGender();

        HumanBuilder builder = new HumanBuilder();
        return builder.setupFullName(fullName)
                .setupAge(age)
                .setupGender(gender)
                .build();
    }

    private String promptForFullName() {
        System.out.println("Введите имя человека: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    private int promptForAge() {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("\nВведите возраст человека (от 1 до 100): ");
                String ageStr = scanner.nextLine();
                int age = Integer.parseInt(ageStr);

                if (age >= 1 && age <= 100) {
                    return age;
                } else {
                    System.out.println("Возраст должен быть от 1 до 100 лет. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите числовое значение для возраста.");
            }
        }
    }

    private Gender promptForGender() {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("\nВведите пол: \n1. Мужской\n2. Женский");
                String genderStr = scanner.nextLine();

                switch (genderStr) {
                    case "1":
                        return Gender.MALE;
                    case "2":
                        return Gender.FEMALE;
                    default:
                        System.out.println("Некорректный ввод. Введите 1 для мужского пола или 2 для женского.");
                }
            }
        }
    }
}
