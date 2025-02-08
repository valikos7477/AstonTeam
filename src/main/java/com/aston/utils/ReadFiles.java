package com.aston.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.aston.entities.Animal;
import com.aston.entities.Human;
import com.aston.entities.Box;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadFiles {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String HUMAN_FILE_PATH = "src/source/data/Human.json";
    private static final String ANIMAL_FILE_PATH = "src/source/data/Animal.json";
    private static final String BOX_FILE_PATH = "src/source/data/Box.json";

    public static List<Human> readHumans(String HUMAN_FILE_PATH) {
        try {
            return objectMapper.readValue(new File(HUMAN_FILE_PATH), new TypeReference<List<Human>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Animal> readAnimals(String ANIMAL_FILE_PATH) {
        try {
            return objectMapper.readValue(new File(ANIMAL_FILE_PATH), new TypeReference<List<Animal>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Box> readBox(String BOX_FILE_PATH) {
        try {
            return objectMapper.readValue(new File(BOX_FILE_PATH), new TypeReference<List<Box>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
