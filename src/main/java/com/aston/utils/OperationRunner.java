package com.aston.utils;

import com.aston.datatypes.collections.CustomArrayList;
import com.aston.datatypes.enums.EntityChoice;
import com.aston.datatypes.enums.LoadingModeChoice;
import com.aston.entities.*;

import java.util.List;

public class OperationRunner {
    private EntityChoice entityChoice;
    private LoadingModeChoice loadingMode;
    private Integer numberOfElements;

    public OperationRunner setEntityChoice(int choice) {
        entityChoice = (choice == 1) ? EntityChoice.HUMAN_SELECTED
                : (choice == 2) ? EntityChoice.ANIMAL_SELECTED
                : EntityChoice.BOX_SELECTED;
        return this;
    }

    public OperationRunner setLoadingMode(int choice) {
        loadingMode = (choice == 1) ? LoadingModeChoice.HANDY
                : (choice == 2) ? LoadingModeChoice.RANDOM
                : LoadingModeChoice.FROM_FILE;
        return this;
    }

    public OperationRunner setNumberOfElements(int number) {
        numberOfElements = number;
        return this;
    }

    public List<Comparable> loadData() {
        List<Comparable> elements = new CustomArrayList<>();

        if (loadingMode == LoadingModeChoice.RANDOM) {
            if (entityChoice == EntityChoice.ANIMAL_SELECTED) {
                AnimalBuilder animalBuilder = new AnimalBuilder();
                for (int i = 0; i < numberOfElements; i++) {
                    Animal animal = animalBuilder.randomBuild();
                    elements.add(animal);
                }
            } else if (entityChoice == EntityChoice.HUMAN_SELECTED) {
                HumanBuilder humanBuilder = new HumanBuilder();
                for (int i = 0; i < numberOfElements; i++) {
                    Human human = humanBuilder.randomBuild();
                    elements.add(human);
                }
            } else {
                BoxBuilder boxBuilder = new BoxBuilder();
                for (int i = 0; i < numberOfElements; i++) {
                    Box box = boxBuilder.randomBuild();
                    elements.add(box);
                }
            }
        }
        return elements;
    }
}
