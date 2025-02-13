package com.aston.Controllers;

import com.aston.Data.enums.BoxMaterial;
import com.aston.Data.enums.BoxMaterialChoice;
import com.aston.Data.enums.StoredMaterial;
import com.aston.Data.enums.StoredMaterialChoice;
import com.aston.entities.Box;
import com.aston.entities.BoxBuilder;

import java.util.Scanner;
import java.util.logging.Logger;

public class BoxViewController {

    private static final Logger LOGGER = Logger.getLogger(BoxViewController.class.getName());
    private static final Scanner SCANNER = new Scanner(System.in);

    public Box UIDialogBox() {
        BoxMaterial material = chooseBoxMaterial();
        StoredMaterial stored = chooseStoredMaterial();
        int volume = chooseVolume();

        BoxBuilder builder = new BoxBuilder();
        return builder.setupBoxMaterial(material)
                .setupStoredMaterial(stored)
                .setupVolume(volume)
                .build();
    }

    private BoxMaterial chooseBoxMaterial() {
        while (true) {
            try {
                System.out.println("\nВведите материал бочки:");
                for (BoxMaterialChoice choice : BoxMaterialChoice.values()) {
                    System.out.println(choice.getDescription());
                }
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                return BoxMaterialChoice.fromInt(choice).getBoxMaterial();
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число от 1 до 3.");
            }
        }
    }

    private StoredMaterial chooseStoredMaterial() {
        while (true) {
            try {
                System.out.println("\nВведите хранимый материал:");
                for (StoredMaterialChoice choice : StoredMaterialChoice.values()) {
                    System.out.println(choice.getDescription());
                }
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                return StoredMaterialChoice.fromInt(choice).getStoredMaterial();
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число от 1 до 5.");
            }
        }
    }

    private int chooseVolume() {
        while (true) {
            try {
                System.out.println("\nВведите объем бочки (1 - 3000 куб.метров):");
                int volume = Integer.parseInt(SCANNER.nextLine());
                if (volume >= 1 && volume <= 3000) {
                    return volume;
                }
                System.out.println("Объем должен быть в диапазоне от 1 до 3000 куб.метров.");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }
    }
}