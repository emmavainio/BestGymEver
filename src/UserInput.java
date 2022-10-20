import javax.swing.*;

public class UserInput {

    public static String getClientInfo(String userMockInput, boolean isTest) {

        if (isTest) {
            if (userMockInput != null)
                return userMockInput;
            else
                return null;
        }
        else {
            return JOptionPane.showInputDialog("Skriv in namn eller personnummer");
        }
    }
}
