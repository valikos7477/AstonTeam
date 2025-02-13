package com.aston.Data.enums;

public enum AnimalTypeChoice {
        MAMMAL(1, "1. Млекопитающее", AnimalType.MAMMAL),
        AMPHIBIAN(2, "2. Амфибия", AnimalType.AMPHIBIANS),
        REPTILE(3, "3. Рептилия", AnimalType.REPTILES),
        BIRD(4, "4. Птица", AnimalType.BIRD);

        private final int choice;
        private final String description;
        private final AnimalType animalType;

        AnimalTypeChoice(int choice, String description, AnimalType animalType) {
            this.choice = choice;
            this.description = description;
            this.animalType = animalType;
        }

        public String getDescription() {
            return description;
        }

        public AnimalType getAnimalType() {
            return animalType;
        }

        public static AnimalTypeChoice fromInt(int choice) {
            for (AnimalTypeChoice type : AnimalTypeChoice.values()) {
                if (type.choice == choice) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Неверный выбор типа животного: " + choice);
        }
    }

