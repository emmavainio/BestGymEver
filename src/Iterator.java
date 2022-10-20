import java.util.List;

public class Iterator {

    public static Person iterateListToFindClient (String userInput, List<Person> allClients) {

        for (Person p: allClients) {
            if (userInput.trim().equalsIgnoreCase(p.getName()) || userInput.trim().equalsIgnoreCase(p.getSsn()))
                return p;
        }
        return null;
    }
}
