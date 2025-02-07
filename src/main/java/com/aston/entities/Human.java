package com.aston.entities;

import com.aston.enums.Gender;

public class Human implements Sortable {
    private String fullName;
    private Integer age;
    private Gender gender;

    @Override
    public void sortByFirstField() {

    }

    @Override
    public void sortBySecondField() {

    }

    @Override
    public void sortByThirdField() {

    }

    @Override
    public String toString() {
        return "Human{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


}
