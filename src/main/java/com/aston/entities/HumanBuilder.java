package com.aston.entities;

import com.aston.Data.enums.Gender;
import com.aston.utils.Randomer;
import com.aston.Sorting.Humans.CompareByName;

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
        human.setupSortingStrategy(new CompareByName());
        return human;
    }

    public Human randomBuild() {
        Human human = new Human();
        human.setAge(Randomer.randInt(1, 100));
        Gender gender = Randomer.randGender();
        human.setGender(gender);
        human.setupSortingStrategy(new CompareByName());

        String name = (gender == Gender.MALE) ? Randomer.getRandomMaleName() : Randomer.getRandomFemaleName();

        human.setFullName(name.toLowerCase());

        return human;
    }
}