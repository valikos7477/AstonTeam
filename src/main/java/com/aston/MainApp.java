package com.aston;

import com.aston.entities.*;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("*****************");
        AnimalBuilder animalBuilder = new AnimalBuilder();
        for (int i = 0; i < 100; i++) {
            Animal animal = animalBuilder.randomBuild();
            System.out.println(animal);
        }

        System.out.println("*****************");
        BoxBuilder boxBuilder = new BoxBuilder();
        for (int i = 0; i < 100; i++) {
            Box box = boxBuilder.randomBuild();
            System.out.println(box);
        }

        System.out.println("*****************");
        HumanBuilder humanBuilder = new HumanBuilder();
        for (int i = 0; i < 100; i++) {
            Human human = humanBuilder.randomBuild();
            System.out.println(human);
        }

        //        Animal animal1 = animalBuilder.setupType(AnimalType.BIRD)
//                .setupEyeColor(EyeColor.BLACK)
//                .setupWeight(123)
//                .setupFur(false)
//                .build();
//        System.out.println(animal1);

    }
}
