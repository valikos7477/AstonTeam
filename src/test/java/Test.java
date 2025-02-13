import org.junit.Before;

import static org.junit.Assert.*;
import com.aston.Data.enums.EntityType;
import com.aston.Data.enums.SortingMode;
import com.aston.entities.*;
import com.aston.utils.FileOperations;
import com.aston.utils.SearchEngine;

import java.util.List;

public class Test {

    private List<Comparable> humans;
    private List<Comparable> animals;
    private List<Comparable> boxes;

    @Before
    public void setUp() {
        // Загрузка данных из файлов перед каждым тестом
        humans = FileOperations.loadFromFile(EntityType.HUMAN,  1000, "src/main/resources/humans.txt" );
        animals = FileOperations.loadFromFile(EntityType.ANIMAL, 1000, "src/main/resources/animals.txt");
        boxes = FileOperations.loadFromFile(EntityType.BOX, 1000, "src/main/resources/boxes.txt");
    }

    @org.junit.Test
    public void testSearchEngineForHumans() {
        // Создание тестовых объектов
        Human elvisPresley = HumanBuilder.create().setupFullName("дина петрова").build();
        Human michael = HumanBuilder.create().setupFullName("юрий дроздов").build();

        // Поиск и проверка результатов
        int elvisIndex = SearchEngine.search(humans, elvisPresley, SortingMode.HUMAN_NAME);
        int michaelIndex = SearchEngine.search(humans, michael, SortingMode.HUMAN_NAME);

        // Проверки
        assertNotEquals("Элвис Пресли должен быть найден в коллекции", -1, elvisIndex);
        assertNotEquals("Михаил Кузубов должен быть найден в коллекции", -1, michaelIndex);
    }

    @org.junit.Test
    public void testSearchEngineForAnimals() {
        // Создание тестовых объектов
        Animal animal1 = AnimalBuilder.create().setupWeight(3481).build();
        Animal animal2 = AnimalBuilder.create().setupWeight(1234).build();

        // Поиск и проверка результатов
        int animal1Index = SearchEngine.search(animals, animal1, SortingMode.ANIMAL_WEIGHT);
        int animal2Index = SearchEngine.search(animals, animal2, SortingMode.ANIMAL_WEIGHT);

        // Проверки
        assertNotEquals("Животное с весом 3481 должно быть найдено в коллекции", -1, animal1Index);
        assertEquals("Животное с весом 1234 не должно быть найдено в коллекции", -1, animal2Index);
    }

    @org.junit.Test
    public void testSearchEngineForBoxes() {
        // Создание тестовых объектов
        Box box1 = BoxBuilder.create().setupVolume(850).build();
        Box box2 = BoxBuilder.create().setupVolume(2234).build();

        // Поиск и проверка результатов
        int box1Index = SearchEngine.search(boxes, box1, SortingMode.BOX_VOLUME);
        int box2Index = SearchEngine.search(boxes, box2, SortingMode.BOX_VOLUME);

        // Проверки
        assertNotEquals("Бокс с объемом 850 должен быть найден в коллекции", -1, box1Index);
        assertEquals("Бокс с объемом 2234 не должен быть найден в коллекции", -1, box2Index);
    }
}