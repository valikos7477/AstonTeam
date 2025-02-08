package com.aston;

import com.aston.entities.*;
import com.aston.tools.CustomArrayList;

public class MainApp {
    public static void main(String[] args) {
        CustomArrayList<Sortable> list = new CustomArrayList<>();

        AnimalBuilder animalBuilder = new AnimalBuilder();
        for (int i = 0; i < 100; i++) {
            Animal animal = animalBuilder.randomBuild();
            list.add(animal);
        }

        BoxBuilder boxBuilder = new BoxBuilder();
        for (int i = 0; i < 1000; i++) {
            Box box = boxBuilder.randomBuild();
            list.add(box);
        }

        HumanBuilder humanBuilder = new HumanBuilder();
        for (int i = 0; i < 1000; i++) {
            Human human = humanBuilder.randomBuild();
            list.add(human);
        }

        System.out.println("---------");
        System.out.println(list.size());

        System.out.println("###################");
        list.forEach(System.out::println);
    }
}
