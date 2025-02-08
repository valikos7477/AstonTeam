package com.aston.entities;
import com.aston.enums.Gender;

public class Human implements Sortable {
    private final String fullName;
    private final int age;
    private final Gender gender;

    private Human(Builder builder){
        this.fullName=builder.fullName;
        this.age=builder.age;
        this.gender=builder.gender;
    }

    public String getFullName(){
        return fullName;
    }
    public int getAge(){
        return age;
    }
    public Gender getGender(){
        return gender;
    }

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

public static class Builder {
    private int age;
    private String fullName;
    private Gender gender;


    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public Builder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Builder gender(Gender gender) {
        this.gender = gender;
        return this;
        }
        public Human build(){
        return new Human(this);
        }
    }
}

