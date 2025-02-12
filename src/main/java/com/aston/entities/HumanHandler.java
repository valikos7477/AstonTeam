package com.aston.entities;

import com.aston.entities.Human;
import com.aston.entities.HumanBuilder;
import com.aston.Data.enums.Gender;

public class HumanHandler {
    public static Human buildHuman(String paramStr) {
        String[] params = paramStr.split(";");
        String fullName = params[0].split("=")[1];
        int age = Integer.parseInt(params[1].split("=")[1]);
        Gender gender = Gender.fromString(params[2].split("=")[1]);

        return new HumanBuilder()
                .setupFullName(fullName)
                .setupAge(age)
                .setupGender(gender)
                .build();
    }
}
