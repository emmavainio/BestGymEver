import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FileInputTest {

    Path inFile = Paths.get("Test/CustomersTest.txt");

    @Test
    public void readFileAddPeopleToList() {
        List<Person> people = FileInput.readDataFromFileAddToList(inFile);
        assertEquals(3, people.size());
        assertNotEquals(5, people.size());
        assertEquals("Alhambra Aromes", people.get(0).getName());
        assertNotEquals("Bear Belle", people.get(0).getName());
    }

}
