package com.aston.uikit.controllers;

import com.aston.datatypes.enums.AnimalType;
import com.aston.datatypes.enums.EyeColor;
import com.aston.entities.Animal;
import com.aston.entities.AnimalBuilder;
import java.util.Scanner;


public class AnimalViewController {
    private Integer animalType;
    private Integer eyeColor;
    private Integer weight;
    private Integer isFur;

    public Animal UIDialogAnimal() {
        AnimalType type;
        EyeColor color;
        Integer weight;
        Integer isFur;

        Scanner scanner = new Scanner(System.in);

        //-------Тип животного-----
        while (true){
            try {
                System.out.println("\nВведите тип животного: \n1. Млекопитающее\n2. Амфибия\n3. Рептилия\n4. Птица");
                String animalTypeStr = scanner.nextLine();
                animalType = Integer.valueOf(animalTypeStr);
                if (animalType >= 1 && animalType <= 4)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения.");
                System.out.println("\nВведите тип животного: 1. Млекопитающее 2. Амфибия 3. Htgnbkbz 4. Птица");
            }
        }
        type =  (animalType == 1) ? AnimalType.MAMMAL :
                (animalType == 2) ? AnimalType.AMPHIBIANS :
                (animalType == 3) ? AnimalType.REPTILES : AnimalType.BIRD;

        //-----Цвет глаз----
        while (true){
            try {
                System.out.println("\nВведите цвет глаз: \n1. Красный\n2. Зеленый\n3. Черный\n4. Серый\n5. Голубой");
                String eyeColorStr = scanner.nextLine();
                eyeColor = Integer.valueOf(eyeColorStr);
                if (eyeColor >= 1 && eyeColor <= 5)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения.");
                System.out.println("\nВведите цвет глаз: 1. Красный 2. Зеленый 3. Черный 4. Серый 5. Голубой");
            }
        }
        color =  (eyeColor == 1) ? EyeColor.RED :
                 (eyeColor == 2) ? EyeColor.GREEN :
                         (eyeColor == 3) ? EyeColor.BLACK : (eyeColor == 4) ? EyeColor.GREY : EyeColor.BLUE ;

        //------Вес животного-----
        while (true) {
            try {
                System.out.println("\nВведите вес животного: ");
                String weightStr = scanner.nextLine();
                weight = Integer.valueOf(weightStr);
                if (weight >= 1 && weight <= 5000)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения. Введите числовое значение для веса животного (1 - 5000 кг)");
            }
        }

        //---Признак наличия шерсти-----
        while (true) {
            try {
                System.out.println("\nПризнак наличия шерсти: 1. Есть, 2. Отсутствует");
                String furStr = scanner.nextLine();
                isFur = Integer.valueOf(furStr);
                if (isFur == 1 ||  isFur == 2)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения. Признак наличия шерсти: 1. Есть, 2. Отсутствует");
            }
        }

        boolean fur =  (isFur == 1) ? true : false;

        AnimalBuilder builder = new AnimalBuilder();
        return builder.setupType(type)
                .setupEyeColor(color)
                .setupWeight(weight)
                .setupFur(fur)
                .build();
    }
}
