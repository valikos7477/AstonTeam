package com.aston.utils;

import com.aston.datatypes.collections.CustomArrayList;
import com.aston.datatypes.enums.Gender;
import com.aston.entities.Animal;
import com.aston.entities.AnimalBuilder;
import com.aston.entities.Human;
import com.aston.entities.HumanBuilder;

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
