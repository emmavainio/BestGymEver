import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    Path inputFile = Paths.get("src/Customers.txt");
    Path outputFile = Paths.get("src/ClientTracker.txt");

    public Main() {

        while(true) {
            String clientInfo = JOptionPane.showInputDialog("Skriv in namn eller personnummer");
            if(clientInfo == null)
                System.exit(0);

            List<Client> allClients = FileInput.readDataFromFileAddToList(inputFile);

            Client client = Iterator.iterateListToFindClient(clientInfo, allClients);
            boolean clientFound = false;
            if(client == null)
                JOptionPane.showMessageDialog(null, "Kunden finns inte!");
            else
                clientFound = true;

            if(clientFound) {
                boolean hasPaidLessThanAYearAgo = DateComparator.isLessThanOneYearAgo(client.getPaymentDate());

                if (hasPaidLessThanAYearAgo) {
                    FileOutput.writeClientToFile(client, outputFile);
                    JOptionPane.showMessageDialog(null, client.getName() +
                            " har lagts till i PT-filen");
                }
                else
                    JOptionPane.showMessageDialog(null, client.getName() +
                            " har inte betalat √•rsavgiften");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}