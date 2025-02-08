package com.aston.entities;

import com.aston.enums.Gender;
import com.aston.utils.RandomTools;

public class HumanBuilder {
    private String fullName;
    private Integer age;
    private Gender gender;

    public HumanBuilder setupFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public HumanBuilder setupAge(Integer age) {
        this.age = age;
        return this;
    }

    public HumanBuilder setupGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Human build() {
        Human human = new Human();
        human.setFullName(fullName);
        human.setAge(age);
        human.setGender(gender);
        return human;
    }

    public Human randomBuild() {
        Human human = new Human();
        human.setAge(RandomTools.randInt(1, 100));
        Gender gender = RandomTools.randGender();
        human.setGender(gender);

        String name;
        if (gender == Gender.MALE) {
            name = RandomTools.getRandomMaleName();
        }
        else {
            name = RandomTools.getRandomFemaleName();
        }
        human.setFullName(name);

        return human;
    }
}
