package com.aston.utils;

import java.util.Random;
import com.aston.datatypes.enums.*;

public abstract class RandomTools {
    public static AnimalType getRandomAnimalType() {
        Random rand = new Random();
        int limitAnimalType = AnimalType.values().length;
        int randomAnimalType = rand.nextInt(limitAnimalType);
        return AnimalType.values()[randomAnimalType];
    }

    public static EyeColor getRandomEyeColor() {
        Random rand = new Random();
        int limitEyeColor = EyeColor.values().length;
        int randomEyeColor = rand.nextInt(limitEyeColor);
        return EyeColor.values()[randomEyeColor];
    }

    public static BoxMaterial getRandomBoxMaterial() {
        Random rand = new Random();
        int limitBoxMaterial = BoxMaterial.values().length;
        int randomBoxMaterial = rand.nextInt(limitBoxMaterial);
        return BoxMaterial.values()[randomBoxMaterial];
    }

    public static StoredMaterial getRandomStoredMaterial() {
        Random rand = new Random();
        int limitStoredMaterial = StoredMaterial.values().length;
        int randomStoredMaterial = rand.nextInt(limitStoredMaterial);
        return StoredMaterial.values()[randomStoredMaterial];
    }

    public static String getRandomMaleName() {
        String[] firstNames = new String[] {
                "Иван", "Сергей", "Петр", "Дмитрий",
                "Виктор", "Андрей", "Константин", "Виталий",
                "Алексей", "Евгений", "Олег", "Александр",
                "Кирил", "Владислав", "Владимир", "Николай",
                "Максим", "Юрий", "Павел", "Михаил",
        };

        String[] secondNames = new String[] {
                "Тремарев", "Карпов", "Терехин", "Резников",
                "Кузькин", "Дорожкин", "Лихачев", "Субботин",
                "Макаров", "Набоков", "Трубинов", "Веселов",
                "Сапожников", "Светляев", "Воропаев", "Кузубов",
                "Кожин", "Лунин", "Дроздов", "Агеев",
        };

        int firstNameIndex = randInt(0, firstNames.length);
        int secondNameIndex = randInt(0, secondNames.length);
        return firstNames[firstNameIndex] + " " + secondNames[secondNameIndex];
    }

    public static String getRandomFemaleName() {
        String[] firstNames = new String[] {
                "Полина", "Екатерина", "Анна", "Елизавета",
                "Елена", "Ирина", "Анастасия", "Людмила",
                "Моника", "Клара", "Ольга", "Татьяна",
                "Полина", "Екатерина", "Анна", "Елизавета",
                "Дина", "Алина", "Аделина", "Барбара",
        };

        String[] secondNames = new String[] {
                "Ткачева", "Иванова", "Петрова", "Сидорова",
                "Ларионова", "Фетисова", "Градова", "Зуева",
                "Даньшина", "Карасева", "Баранова", "Ларина",
                "Ветрова", "Тарасова", "Воронова", "Панарина",
                "Рублева", "Сотникова", "Киреева", "Борисова",
        };

        int firstNameIndex = randInt(0, firstNames.length);
        int secondNameIndex = randInt(0, secondNames.length);
        return firstNames[firstNameIndex] + " " + secondNames[secondNameIndex];
    }

    public static int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static Gender randGender() {
        return randInt(1, 100) % 2 == 0 ? Gender.MALE : Gender.FEMALE;
    }

    public static boolean randBoolean() {
        return randInt(1, 100) % 2 == 0;
    }
}

