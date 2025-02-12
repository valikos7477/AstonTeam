package com.aston.utils;

import com.aston.Data.tools.newArrayList;
import com.aston.Data.enums.*;
import com.aston.entities.*;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileOperations {

    private static final Logger LOGGER = Logger.getLogger(FileOperations.class.getName());

    public static List<Comparable> loadFromFile(EntityType mixed, int numberOfElements, String inputFileName) {
        List<Comparable> elements = new newArrayList<>();

        File file = new File(inputFileName);
        if (!file.exists()) {
            LOGGER.log(Level.SEVERE, "File not found: " + inputFileName);
            return elements;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (FileHandler.validateFileString(line) == 0) {
                    String[] parts = line.split("#");
                    if (parts.length != 2) {
                        LOGGER.log(Level.WARNING, "Invalid line format: " + line);
                        continue;
                    }

                    String typeOfObject = parts[0];
                    String objectsParams = parts[1];

                    switch (typeOfObject) {
                        case "human":
                            elements.add(HumanHandler.buildHuman(objectsParams));
                            break;
                        case "animal":
                            elements.add(AnimalHandler.buildAnimal(objectsParams));
                            break;
                        case "box":
                            elements.add(BoxHandler.buildBox(objectsParams));
                            break;
                        default:
                            LOGGER.log(Level.WARNING, "Unknown object type: " + typeOfObject);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file: " + inputFileName, e);
        }

        return elements;
    }

    public static void saveToFile(List<Comparable> elements, String outFileName, boolean isAppend) {
        try (FileWriter writer = new FileWriter(outFileName, isAppend)) {
            for (Comparable element : elements) {
                writer.write(element.toString() + '\n');
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing to file: " + outFileName, e);
            throw new RuntimeException("Failed to save file", e);
        }
    }
}