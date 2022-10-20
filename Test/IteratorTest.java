import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IteratorTest {

    Person p1 = new Person("Emma Vainio", "1234567890", "2021-01-01");
    Person p2 = new Person("Rakel Vainio", "2345678901", "2022-01-01");
    Person p3 = new Person("Oleg Vainio", "3456789012", "2019-01-01");

    List<Person> allClients = Arrays.asList(p1, p2, p3);

    String userInputCorrectName = "EMMA Vainio";
    String userInputIncorrectName = "Greger Vainio";
    String userInputCorrectSsn = "3456789012";
    String userInputIncorrectSsn = "1432157895";

    @Test
    public void iterateListToFindClientTest() {
        assert (Objects.equals(Iterator.iterateListToFindClient(userInputCorrectName, allClients), p1));
        assert (!Objects.equals(Iterator.iterateListToFindClient(userInputCorrectName, allClients), p2));

        assert(Iterator.iterateListToFindClient(userInputIncorrectName, allClients) == null);

        assert (Objects.equals(Iterator.iterateListToFindClient(userInputCorrectSsn, allClients), p3));
        assert (!Objects.equals(Iterator.iterateListToFindClient(userInputCorrectSsn, allClients), p2));

        assert(Iterator.iterateListToFindClient(userInputIncorrectSsn, allClients) == null);

    }
}
