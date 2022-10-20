import java.util.List;

public class Iterator {

    public static Person iterateListToFindClient (String userInput, List<Person> allClients) {
        userInput = userInput.trim();

        for (Person p: allClients) {
            if (userInput.equalsIgnoreCase(p.getName()) || userInput.equalsIgnoreCase(p.getSsn()))
                return p;
        }
        return null;
    }
}
