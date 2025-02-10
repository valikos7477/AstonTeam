package com.aston.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class FileOperations {

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
