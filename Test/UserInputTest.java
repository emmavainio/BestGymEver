import org.junit.jupiter.api.Test;

public class UserInputTest {

    String userInput = "Emma Vainio";
    String noUserInput = null;
    boolean isTest = true;

    @Test
    public void getUserInputTest() {
        assert (UserInput.getClientInfo(userInput, isTest).equals("Emma Vainio"));
        assert (UserInput.getClientInfo(noUserInput, isTest) == null);

    }
}
