package com.aston;

import com.aston.entities.*;
import com.aston.enums.AnimalType;
import com.aston.tools.CustomArrayList;

public class MainApp {
    public static void main(String[] args) {

        CustomArrayList<Sortable> list = new CustomArrayList<>();

        AnimalBuilder animalBuilder = new AnimalBuilder();
        for (int i = 0; i < 10; i++) {
            Animal animal = animalBuilder.randomBuild();
            list.add(animal);
        }

        Sortable[] array = list.toArray(new Sortable[list.size()]);
        for (int i = 0; i < list.size(); i++) {
            Sortable elem = list.get(i);
            array[i] = elem;
        }
    }
}
