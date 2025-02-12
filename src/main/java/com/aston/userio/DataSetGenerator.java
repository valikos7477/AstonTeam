package com.aston.userio;

import com.aston.Data.tools.newArrayList;
import com.aston.Data.enums.EntityType;
import com.aston.utils.FileOperations;
import com.aston.utils.Randomer;
import java.util.List;

public abstract class DataSetGenerator {

    public enum SourceType {
        MANUAL(1),
        RANDOM(2),
        FILE(3);

        private final int value;

        SourceType(int value) {
            this.value = value;
        }

        public static SourceType fromValue(int value) {
            for (SourceType type : SourceType.values()) {
                if (type.value == value) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid source type value: " + value);
        }
    }

    public static List<Comparable> inputMessage(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        String[] octets = message.split("&");
        if (octets.length < 4) {
            throw new IllegalArgumentException("Invalid message format");
        }

        int entity = Integer.parseInt(octets[0].split("=")[1]);
        int sourceValue = Integer.parseInt(octets[1].split("=")[1]);
        int numberOfElements = Integer.parseInt(octets[2].split("=")[1]);
        String inputFileName = (octets[3].split("=").length == 2) ? octets[3].split("=")[1] : "";

        SourceType source = SourceType.fromValue(sourceValue);
        EntityType entityType = EntityType.fromValue(entity);

        List<Comparable> list = new newArrayList<>();

        switch (source) {
            case RANDOM:
                list = generateRandomData(entityType, numberOfElements);
                break;
            case FILE:
                list = loadDataFromFile(entityType, numberOfElements, inputFileName);
                break;
            case MANUAL:
                // Handle manual input logic here
                break;
            default:
                throw new IllegalArgumentException("Unsupported source type: " + source);
        }

        return list;
    }

    private static List<Comparable> generateRandomData(EntityType entityType, int numberOfElements) {
        switch (entityType) {
            case HUMAN:
                return Randomer.getRandomAnimalMany(numberOfElements);
            case ANIMAL:
                return Randomer.getRandomAnimalMany(numberOfElements);
            case BOX:
                return Randomer.getRandomBoxMany(numberOfElements);
            default:
                throw new IllegalArgumentException("Unsupported entity type: " + entityType);
        }
    }

    private static List<Comparable> loadDataFromFile(EntityType entityType, int numberOfElements, String inputFileName) {
        if (inputFileName == null || inputFileName.isEmpty()) {
            throw new IllegalArgumentException("Input file name cannot be null or empty");
        }
        return FileOperations.loadFromFile(EntityType.MIXED, numberOfElements, inputFileName);
    }
}