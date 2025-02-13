package com.aston.utils;

import com.aston.datatypes.collections.CustomArrayList;
import com.aston.datatypes.enums.*;
import com.aston.entities.*;

import java.io.*;
import java.util.List;

public abstract class FileOperations {

    public static class FileHandler {

        static boolean validateHumanString(String line) {
            line = line.toLowerCase();
            String typeOfObject;
            String objectsParams;
            String ageStr;
            String genderStr;

            try {
                typeOfObject = line.split("#")[0];
                objectsParams = line.split("#")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            if (typeOfObject.compareTo("human") != 0) {
                return false;
            }

            try {
                ageStr = objectsParams.split(";")[1].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            try {
                Integer.valueOf(ageStr);
            } catch (NumberFormatException e) {
                return false;
            }

            try {
                genderStr = objectsParams.split(";")[2].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            if ((genderStr.compareTo("male") != 0) && (genderStr.compareTo("female") !=0)) {
                return false;
            }

            return true;
        }

        static boolean validateAnimalString(String line) {
            line = line.toLowerCase();
            String typeOfObject;
            String objectsParams;

            String animalTypeStr;
            String eyeColorStr;
            String animalWeightStr;
            String isFurStr;

            try {
                typeOfObject = line.split("#")[0];
                objectsParams = line.split("#")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            if (typeOfObject.compareTo("animal") != 0) {
                return false;
            }

            //------Animal type--------
            try {
                animalTypeStr = objectsParams.split(";")[0].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
            if ((animalTypeStr.compareTo("mammal") != 0) &&
                    (animalTypeStr.compareTo("amphibians") != 0) &&
                    (animalTypeStr.compareTo("reptiles") != 0) &&
                    (animalTypeStr.compareTo("bird") != 0)) {
                return false;
            }

            //--------Eye color--------
            try {
                eyeColorStr = objectsParams.split(";")[1].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
            if ((eyeColorStr.compareTo("red") != 0) &&
                    (eyeColorStr.compareTo("green") != 0) &&
                    (eyeColorStr.compareTo("black") != 0) &&
                    (eyeColorStr.compareTo("grey") != 0) &&
                    (eyeColorStr.compareTo("blue") != 0)) {
                return false;
            }

            //-------weight------
            try {
                animalWeightStr = objectsParams.split(";")[2].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            try {
                Integer.valueOf(animalWeightStr);
            } catch (NumberFormatException e) {
                return false;
            }

            //---------is Fur-------
            try {
                isFurStr = objectsParams.split(";")[3].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
            if ((isFurStr.compareTo("true") != 0) &&
                    (isFurStr.compareTo("false") != 0)) {
                return false;
            }

            return true;
        }

        static boolean validateBoxString(String line) {
            line = line.toLowerCase();
            String typeOfObject;
            String objectsParams;

            String boxMaterialStr;
            String storedMaterialStr;
            String boxVolumeStr;

            try {
                typeOfObject = line.split("#")[0];
                objectsParams = line.split("#")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            if (typeOfObject.compareTo("box") != 0) {
                return false;
            }

            //------Box material--------
            try {
                boxMaterialStr = objectsParams.split(";")[0].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
            if ((boxMaterialStr.compareTo("wood") != 0) &&
                    (boxMaterialStr.compareTo("metal") != 0) &&
                    (boxMaterialStr.compareTo("plastic") != 0)) {
                return false;
            }

            //--------Stored in box material--------
            try {
                storedMaterialStr = objectsParams.split(";")[1].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
            if ((storedMaterialStr.compareTo("beer") != 0) &&
                    (storedMaterialStr.compareTo("wine") != 0) &&
                    (storedMaterialStr.compareTo("fish") != 0) &&
                    (storedMaterialStr.compareTo("gas") != 0) &&
                    (storedMaterialStr.compareTo("oil") != 0)) {
                return false;
            }

            //-------volume------
            try {
                boxVolumeStr = objectsParams.split(";")[2].split("=")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            try {
                Integer.valueOf(boxVolumeStr);
            } catch (NumberFormatException e) {
                return false;
            }

            return true;
        }

        static boolean validateFileString(String line, EntityType entityType) {
            boolean check = false;

            switch (entityType) {
                case BOX:
                    check = validateBoxString(line);
                    break;
                case HUMAN:
                    check = validateHumanString(line);
                    break;
                case ANIMAL:
                    check = validateAnimalString(line);
                    break;
                default:
                    check = false;
                    break;
            }
            return check;
        }

        static Human buildHumanFromFileString(String paramStr) {
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

        static Animal buildAnimalFromFileString(String paramStr) {
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

        static Box buildBoxFromFileString(String paramStr) {
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

    public static List<Comparable> loadFromFile(String inputFileName,
                                                EntityType entityType,
                                                Integer linesToRead) {
        Integer readLineNum = 0;
        List<Comparable> elements = new CustomArrayList<>();

        try {
            File file = new File(inputFileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (line != null && (readLineNum < linesToRead)) {
                    line = line.toLowerCase();
                    boolean flag = FileHandler.validateFileString(line, entityType);

                    if (flag == true) {
                        String typeOfObject = line.split("#")[0];
                        String objectsParams = line.split("#")[1];

                        if (typeOfObject.equals("human")) {
                            Human human = FileHandler.buildHumanFromFileString(objectsParams);
                            elements.add(human);
                        } else if (typeOfObject.equals("animal")) {
                            Animal animal = FileHandler.buildAnimalFromFileString(objectsParams);
                            elements.add(animal);
                        }
                        else if (typeOfObject.equals("box")) {
                            Box box = FileHandler.buildBoxFromFileString(objectsParams);
                            elements.add(box);
                        }
                        else {
                            continue;
                        }
                        readLineNum++;
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e ) {
            e.printStackTrace();
        }

        System.out.println("\n\nРаспарсил из файла: " + inputFileName + " " + readLineNum + " элементов: " + elements.size() + "\n");
        return elements;
    }

    public static void saveToFile(List<Comparable> elements,
                                  String outFileName,
                                  Boolean isAppend) throws IOException {

        File output = new File(outFileName);
        FileWriter writer = new FileWriter(output, isAppend);
        elements.stream().forEach(element -> {
            try {
                writer.write(element.toString() + '\n');
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        writer.flush();
        writer.close();

    }
}
