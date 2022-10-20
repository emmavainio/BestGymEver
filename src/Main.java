import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Main {

    boolean isTest = false;
    boolean clientFound = false;
    Path inputFile = Paths.get("src/Customers.txt");
    Path outputFile = Paths.get("src/ClientTracker.txt");
    public Main () {

        //Läsa in användardata still en sträng KLAR
        //Läsa av fil och skapa lista med personer KLAR
        //Iterera över listan och kolla om strängen finns i något av objekten KLAR
            //Om strängen inte finns > meddealnde om att anv inte finns.
            //Om strängen finns:
                //Säkerställ att betalningsdatum är senare än ett år KLAR
                    //Om nej: meddela att betalningsdatum är för mer än ett år sedan
                    //Om ja: skriv ut datum och person till fil KLAR!

        //Ta in data om input/output filnamn och lägg i ifsats om dom "finns" gå vidare.

        while (true) {
            String clientInfo = UserInput.getClientInfo("notTest", isTest);
            if (clientInfo == null)
                System.exit(0);

            List<Person> allClients = FileInput.readDataFromFileAddToList(inputFile);

            Person client = Iterator.iterateListToFindClient(clientInfo, allClients);
            if (client == null)
                JOptionPane.showMessageDialog(null, "Kunden finns inte!");
            else
                clientFound = true;

            if (clientFound) {
                boolean hasPaidLessThanAYearAgo = DateComparator.isLessThanOneYearAgo(LocalDate.now(), client.paymentDate);
                if (hasPaidLessThanAYearAgo)
                    FileOutput.writePersonToFile(client, LocalDate.now(), outputFile);
                else
                    JOptionPane.showMessageDialog(null, client.getName() +
                            " har inte betalat årsavgiften");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}