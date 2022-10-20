import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;

public class FileOutput {

    public static void writePersonToFile(Person client, LocalDate visitingDate, Path outFile) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(outFile.toString(), true))){
            writer.println(client.getName() + ", " + client.getSsn() + ", besökte gymmet " + visitingDate);
        }
        catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("Det gick inte att skriva till filen");
            e.printStackTrace();
            System.exit(0);
        }
        catch (Exception e) {
            System.out.println("Något gick fel!");
            e.printStackTrace();
            System.exit(0);
        }
    }
}