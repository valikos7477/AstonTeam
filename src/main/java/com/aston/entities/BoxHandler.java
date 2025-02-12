package com.aston.entities;

import com.aston.entities.Box;
import com.aston.entities.BoxBuilder;
import com.aston.Data.enums.BoxMaterial;
import com.aston.Data.enums.StoredMaterial;

public class BoxHandler {
    public static Box buildBox(String paramStr) {
        String[] params = paramStr.split(";");
        BoxMaterial boxMaterial = BoxMaterial.fromString(params[0].split("=")[1]);
        StoredMaterial storedMaterial = StoredMaterial.fromString(params[1].split("=")[1]);
        int volume = Integer.parseInt(params[2].split("=")[1]);

        return new BoxBuilder()
                .setupBoxMaterial(boxMaterial)
                .setupStoredMaterial(storedMaterial)
                .setupVolume(volume)
                .build();
    }
}