package com.aston.userio;

import com.aston.datatypes.collections.CustomArrayList;
import com.aston.datatypes.enums.EntityType;
import com.aston.utils.FileOperations;
import com.aston.utils.RandomTools;
import java.util.List;

public abstract class DataSetGenerator {
    private static  List<Comparable> elements;

    public static List<Comparable> inputMessage(String message) {
        List<Comparable> list = new CustomArrayList<>();

        String[] octets = message.split("&");

        String entityStr = octets[0].split("=")[1];
        Integer entity = Integer.valueOf(entityStr);

        String sourceStr = octets[1].split("=")[1];
        Integer source = Integer.valueOf(sourceStr);

        String numberStr = octets[2].split("=")[1];
        Integer numberOfElements = Integer.valueOf(numberStr);

        String[] fileName = octets[3].split("=");
        String inputFileName = (fileName.length == 2) ? fileName[1] : "";

        // - Manual input
        //-->>>>

        // - Random input
        if (source == 2) {
           list =  (entity == 1) ? RandomTools.getRandomHumanMany(numberOfElements) :
                   (entity == 2) ? RandomTools.getRandomAnimalMany(numberOfElements) :
                                   RandomTools.getRandomBoxMany(numberOfElements);
        }
        // - Input from file
        if (source == 3) {
            list =  (entity == 1) ? FileOperations.loadFromFile(inputFileName, EntityType.HUMAN, numberOfElements) :
                    (entity == 2) ? FileOperations.loadFromFile(inputFileName, EntityType.ANIMAL, numberOfElements) :
                                    FileOperations.loadFromFile(inputFileName, EntityType.BOX, numberOfElements);
        }
        return list;
    }
}
