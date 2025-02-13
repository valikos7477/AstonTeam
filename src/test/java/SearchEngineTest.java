import org.junit.Test;
import org.junit.Assert;
import java.util.List;
import com.aston.datatypes.enums.EntityType;
import com.aston.datatypes.enums.SortingMode;
import com.aston.entities.*;
import com.aston.utils.FileOperations;
import com.aston.utils.SearchEngine;


public class SearchEngineTest {
    @Test
    public void searchEngineHuman() {
        String fileName = "src/main/resources/humans.txt";
        List<Comparable> humans = FileOperations.loadFromFile(fileName, EntityType.HUMAN,1000);
        HumanBuilder builder = new HumanBuilder();

        Human elvisPresley =  builder.setupFullName("элвис пресли")
                                .build();
        Human michael =  builder.setupFullName("михаил кузубов")
                                .build();
        int elvisFlag = SearchEngine.search(humans, elvisPresley, SortingMode.HUMAN_NAME);
        Assert.assertNotEquals(elvisFlag, -1);

        int michaelFlag = SearchEngine.search(humans, michael, SortingMode.HUMAN_NAME);
        Assert.assertNotEquals(michaelFlag, -1);
    }

    @Test
    public void searchEngineAnimal() {
        String fileName = "src/main/resources/animals.txt";
        List<Comparable> animals = FileOperations.loadFromFile(fileName, EntityType.ANIMAL,1000);
        AnimalBuilder builder = new AnimalBuilder();

        Animal animal1 =  builder.setupWeight(3481)
                            .build();
        Animal animal2 =  builder.setupWeight(1234)
                            .build();

        int animal1Flag = SearchEngine.search(animals, animal1, SortingMode.ANIMAL_WEIGHT);
        Assert.assertNotEquals(animal1Flag, -1);

        int animal2Flag = SearchEngine.search(animals, animal2, SortingMode.ANIMAL_WEIGHT);
        Assert.assertEquals(animal2Flag, -1);
    }

    @Test
    public void searchEngineBox() {
        String fileName = "src/main/resources/boxes.txt";
        List<Comparable> boxes = FileOperations.loadFromFile(fileName, EntityType.BOX,1000);
        BoxBuilder builder = new BoxBuilder();

        Box box1 =  builder.setupVolume(850)
                        .build();
        Box box2 =  builder.setupVolume(2234)
                        .build();

        int box1Flag = SearchEngine.search(boxes, box1, SortingMode.BOX_VOLUME);
        Assert.assertNotEquals(box1Flag, -1);

        int box2Flag = SearchEngine.search(boxes, box2, SortingMode.BOX_VOLUME);
        Assert.assertEquals(box2Flag, -1);
    }
}
