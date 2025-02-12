package com.aston.uikit.controllers;

import com.aston.datatypes.enums.Gender;
import com.aston.entities.Human;
import com.aston.entities.HumanBuilder;
import java.util.Scanner;


public class HumanViewController {
    private String fullName;
    private Integer age;
    private Integer gender;

    public Human UIDialogHuman(){
        System.out.println("Введите имя человека: ");
        Scanner scanner = new Scanner(System.in);
        fullName = scanner.nextLine();

        while (true) {
            try {
                System.out.println("\nВведите возраст человека: ");
                String ageStr = scanner.nextLine();
                age = Integer.valueOf(ageStr);
                if (age >= 1 && age <= 100)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения. Введите числовое значение для возраста");
            }
        }

        while (true){
            try {
                System.out.println("\nВведите пол: \n1. Мужской\n2. Женский");
                String genderStr = scanner.nextLine();
                gender = Integer.valueOf(genderStr);
                if (gender == 1 || gender == 2)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения.");
                System.out.println("\nВведите пол: 1. Мужской 2. Женский");
            }
        }
        Gender g = (gender == 1) ? Gender.MALE : Gender.FEMALE;

        HumanBuilder builder = new HumanBuilder();
        return builder.setupFullName(fullName)
                .setupAge(age)
                .setupGender(g)
                .build();
    }

}
