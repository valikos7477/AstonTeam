package com.aston.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.aston.entities.Sortable;
import com.aston.tools.CustomArrayList;

public abstract class FileOperations {

    public static void saveToFile(CustomArrayList<Sortable> elements, String outFileName, Boolean isAppend) {
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
