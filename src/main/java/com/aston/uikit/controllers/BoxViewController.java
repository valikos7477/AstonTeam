package com.aston.uikit.controllers;

import com.aston.datatypes.enums.AnimalType;
import com.aston.datatypes.enums.BoxMaterial;
import com.aston.datatypes.enums.Gender;
import com.aston.datatypes.enums.StoredMaterial;
import com.aston.entities.Box;
import com.aston.entities.BoxBuilder;
import com.aston.entities.Human;
import com.aston.entities.HumanBuilder;

import java.util.Scanner;

public class BoxViewController {
    private BoxMaterial material;
    private StoredMaterial stored;
    private Integer volume;

    public Box UIDialogBox() {
        Scanner scanner = new Scanner(System.in);
        Integer boxMaterial;
        Integer storedMaterial;

        //-------Материал бочки-----
        while (true){
            try {
                System.out.println("\nВведите материал бочки: \n1. Дерево\n2. Метал\n3. Пластик");
                String boxMaterialStr = scanner.nextLine();
                boxMaterial = Integer.valueOf(boxMaterialStr);
                if (boxMaterial >= 1 && boxMaterial <= 3)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения.");
                System.out.println("\nВведите материал бочки: 1. Дерево, 2. Метал, 3. Пластик");
            }
        }
        material =  (boxMaterial == 1) ? BoxMaterial.WOOD :
                    (boxMaterial == 2) ? BoxMaterial.METAL : BoxMaterial.PLASTIC;

        //-------Хранимый материал-----
        while (true){
            try {
                System.out.println("\nВведите хранимый материал: \n1. Пиво\n2. Вино\n3. Рыба\n4. Газ\n5. Нефть");
                String storedMaterialStr = scanner.nextLine();
                storedMaterial = Integer.valueOf(storedMaterialStr);

                if (storedMaterial >= 1 && storedMaterial <= 5)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения.");
                System.out.println("\nВведите хранимый материал: 1. Пиво, 2. Вино, 3. Рыба, 4. Газ, 5. Нефть");
            }
        }
        stored =  (storedMaterial == 1) ? StoredMaterial.BEER :
                  (storedMaterial == 2) ? StoredMaterial.WINE :
                          (storedMaterial == 3) ? StoredMaterial.FISH :
                                  (storedMaterial == 4) ? StoredMaterial.GAS : StoredMaterial.OIL;

        //----------Объем бочки-----
        while (true) {
            try {
                System.out.println("\nВведите объем бочки (1- 3000 куб.метров): ");
                String volumeStr = scanner.nextLine();
                volume = Integer.valueOf(volumeStr);
                if (volume >= 1 && volume <= 3000)
                    break;
            } catch (NumberFormatException exception) {
                System.out.println("\nНекорректный ввод значения. Введите числовое значение объема бочки: 1- 3000 куб.метров");
            }
        }

        BoxBuilder builder = new BoxBuilder();
        return builder.setupBoxMaterial(material)
                      .setupStoredMaterial(stored)
                      .setupVolume(volume)
                      .build();
    }
}
