package com.aston.utils;

import com.aston.datatypes.collections.CustomArrayList;
import com.aston.datatypes.enums.*;
import com.aston.entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileOperations {

    public static class FileHandler {
        static int validateFileString(String s) {
            return 0;
        }

        static Human buildHuman(String paramStr) {
            HumanBuilder humanBuilder = new HumanBuilder();
            String[] params = paramStr.split(";");
            String fullName = params[0].split("=")[1];
            Integer age = Integer.valueOf(params[1].split("=")[1]);
            String genderStr = params[2].split("=")[1];
            Gender gender = genderStr.equals("male") ? Gender.MALE : Gender.FEMALE;
            return humanBuilder.setupFullName(fullName)
                    .setupAge(age)
                    .setupGender(gender)
                    .build();
        }

        static Animal buildAnimal(String paramStr) {
            AnimalBuilder animalBuilder = new AnimalBuilder();
            String[] params = paramStr.split(";");

            String animalTypeStr = params[0].split("=")[1];
            AnimalType animalType = animalTypeStr.equals("mammal") ? AnimalType.MAMMAL
                    : animalTypeStr.equals("amphibians") ? AnimalType.AMPHIBIANS
                    : animalTypeStr.equals("reptiles") ? AnimalType.REPTILES
                    : AnimalType.BIRD;

            String eyeColorStr = params[1].split("=")[1];
            EyeColor eyeColor = eyeColorStr.equals("red") ? EyeColor.RED
                    : eyeColorStr.equals("green") ? EyeColor.GREEN
                    : eyeColorStr.equals("black") ? EyeColor.BLACK
                    : eyeColorStr.equals("grey") ? EyeColor.GREY
                    : EyeColor.BLUE;

            String weightStr = params[2].split("=")[1];
            Integer weight = Integer.valueOf(weightStr);

            String isFurStr = params[3].split("=")[1];
            Boolean isFur = isFurStr.equals("true") ? true : false;
            return animalBuilder.setupType(animalType)
                    .setupEyeColor(eyeColor)
                    .setupWeight(weight)
                    .setupFur(isFur)
                    .build();
        }

        static Box buildBox(String paramStr) {
            BoxBuilder boxBuilder = new BoxBuilder();
            String[] params = paramStr.split(";");
            String boxMaterialStr = params[0].split("=")[1];
            BoxMaterial boxMaterial = boxMaterialStr.equals("wood") ? BoxMaterial.WOOD
                    : boxMaterialStr.equals("metal") ? BoxMaterial.METAL
                    : BoxMaterial.PLASTIC;


            String boxStoredMaterialStr = params[1].split("=")[1];
            StoredMaterial boxStoredMaterial = boxStoredMaterialStr.equals("beer") ? StoredMaterial.BEER
                    : boxStoredMaterialStr.equals("wine") ? StoredMaterial.WINE
                    : boxStoredMaterialStr.equals("fish") ? StoredMaterial.FISH
                    : boxStoredMaterialStr.equals("gas") ? StoredMaterial.GAS
                    : StoredMaterial.OIL;

            String volumeStr = params[2].split("=")[1];
            Integer volume = Integer.valueOf(volumeStr);

            return boxBuilder.setupBoxMaterial(boxMaterial)
                    .setupStoredMaterial(boxStoredMaterial)
                    .setupVolume(volume)
                    .build();
        }
    }
    public static List<Comparable> loadFromFile(String inputFileName) {
        List<Comparable> elements = new CustomArrayList<>();

        try {
            File file = new File(inputFileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    line = line.toLowerCase();
                    int flag = FileHandler.validateFileString(line);

                    if (flag == 0) {
                        String typeOfObject = line.split("#")[0];
                        String objectsParams = line.split("#")[1];

                        if (typeOfObject.equals("human")) {
                            Human human = FileHandler.buildHuman(objectsParams);
                            elements.add(human);
                        } else if (typeOfObject.equals("animal")) {
                            Animal animal = FileHandler.buildAnimal(objectsParams);
                            elements.add(animal);
                        }
                        else if (typeOfObject.equals("box")) {
                            Box box = FileHandler.buildBox(objectsParams);
                            elements.add(box);
                        }
                        else {
                            continue;
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e ) {
            e.printStackTrace();
        }

        return elements;
    }

    public static void saveToFile(List<Comparable> elements,
                                  String outFileName,
                                  Boolean isAppend) {
        try {
            File output = new File(outFileName);
            FileWriter writer = new FileWriter(output, isAppend);
            elements.stream().forEach(element -> {
                try {
                    writer.write(element.toString() + '\n');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
