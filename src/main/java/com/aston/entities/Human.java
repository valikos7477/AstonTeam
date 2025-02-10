package com.aston.entities;

import com.aston.datatypes.enums.Gender;
import com.aston.strategy.humans.HumanSortingRule;

public class Human implements Comparable {
    private String fullName;
    private Integer age;
    private Gender gender;

    private HumanSortingRule strategy;

    public void setupSortingStrategy(HumanSortingRule strategy) {
        this.strategy = strategy;
    }

    @Override
    public int compareTo(Object o) {
        Human obj = (Human) o;
        return strategy.doSortingByField(this, obj);
    }

    @Override
    public String toString() {
        return "HUMAN#" +
                "fullName=" + fullName  +
                ";age=" + age +
                ";gender=" + gender;
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

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
