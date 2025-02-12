package com.aston.utils;

import java.util.concurrent.ThreadLocalRandom;
import com.aston.Data.enums.*;

public abstract class Randomer {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static AnimalType getRandomAnimalType() {
        return getRandomEnumValue(AnimalType.values());
    }

    public static EyeColor getRandomEyeColor() {
        return getRandomEnumValue(EyeColor.values());
    }

    public static BoxMaterial getRandomBoxMaterial() {
        return getRandomEnumValue(BoxMaterial.values());
    }

    public static StoredMaterial getRandomStoredMaterial() {
        return getRandomEnumValue(StoredMaterial.values());
    }

    public static String getRandomMaleName() {
        return getRandomName(
                new String[] {
                        "Иван", "Сергей", "Петр", "Дмитрий", "Виктор", "Андрей", "Константин", "Виталий",
                        "Алексей", "Евгений", "Олег", "Александр", "Кирил", "Владислав", "Владимир", "Николай",
                        "Максим", "Юрий", "Павел", "Михаил"
                },
                new String[] {
                        "Тремарев", "Карпов", "Терехин", "Резников", "Кузькин", "Дорожкин", "Лихачев", "Субботин",
                        "Макаров", "Набоков", "Трубинов", "Веселов", "Сапожников", "Светляев", "Воропаев", "Кузубов",
                        "Кожин", "Лунин", "Дроздов", "Агеев"
                }
        );
    }

    public static String getRandomFemaleName() {
        return getRandomName(
                new String[] {
                        "Полина", "Екатерина", "Анна", "Елизавета", "Елена", "Ирина", "Анастасия", "Людмила",
                        "Моника", "Клара", "Ольга", "Татьяна", "Дина", "Алина", "Аделина", "Барбара"
                },
                new String[] {
                        "Ткачева", "Иванова", "Петрова", "Сидорова", "Ларионова", "Фетисова", "Градова", "Зуева",
                        "Даньшина", "Карасева", "Баранова", "Ларина", "Ветрова", "Тарасова", "Воронова", "Панарина",
                        "Рублева", "Сотникова", "Киреева", "Борисова"
                }
        );
    }

    public static int randInt(int min, int max) {
        return RANDOM.nextInt(min, max);
    }

    public static Gender randGender() {
        return RANDOM.nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }

    public static boolean randBoolean() {
        return RANDOM.nextBoolean();
    }

    private static <T extends Enum<?>> T getRandomEnumValue(T[] values) {
        return values[RANDOM.nextInt(values.length)];
    }

    private static String getRandomName(String[] firstNames, String[] secondNames) {
        String firstName = firstNames[RANDOM.nextInt(firstNames.length)];
        String secondName = secondNames[RANDOM.nextInt(secondNames.length)];
        return firstName + " " + secondName;
    }
}
