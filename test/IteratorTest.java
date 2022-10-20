import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IteratorTest {

    Client c1 = new Client("Emma Vainio", "1234567890", "2021-01-01");
    Client c2 = new Client("Rakel Vainio", "2345678901", "2022-01-01");
    Client c3 = new Client("Oleg Vainio", "3456789012", "2019-01-01");

    List<Client> allClients = Arrays.asList(c1, c2, c3);

    String userInputCorrectName = "EMMA Vainio";
    String userInputIncorrectName = "Greger Vainio";
    String userInputCorrectSsn = "3456789012";
    String userInputIncorrectSsn = "1432157895";

    @Test
    public void iterateListToFindClientTest() {
        assert (Objects.equals(Iterator.iterateListToFindClient(userInputCorrectName, allClients), c1));
        assert (!Objects.equals(Iterator.iterateListToFindClient(userInputCorrectName, allClients), c2));
        assert(Iterator.iterateListToFindClient(userInputIncorrectName, allClients) == null);

        assert (Objects.equals(Iterator.iterateListToFindClient(userInputCorrectSsn, allClients), c3));
        assert (!Objects.equals(Iterator.iterateListToFindClient(userInputCorrectSsn, allClients), c2));
        assert(Iterator.iterateListToFindClient(userInputIncorrectSsn, allClients) == null);

    }
}
