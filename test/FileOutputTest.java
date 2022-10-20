import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FileOutputTest {

    String todaysDateAsString = LocalDate.now().toString();
    Person client = new Person("Emma Vainio", "1234567890", todaysDateAsString);
    Path outFile = Paths.get("Test/ClientTrackerTest.txt");
    @Test
    public void writePersonToFileTest() {

        FileOutput.writePersonToFile(client, outFile);
        assertEquals(1, countLinesInFile(outFile));
        assertNotEquals(2, countLinesInFile(outFile));

        assertEquals("Emma Vainio, 1234567890, besökte gymmet " + todaysDateAsString, readLineInFile(outFile));
        assertNotEquals("Emma Vainio, besökte gymmet 2022", readLineInFile(outFile));

        //Testar att metoden appendar och inte skriver över
        FileOutput.writePersonToFile(client, outFile);
        assertEquals(2, countLinesInFile(outFile));
        assertNotEquals(1, countLinesInFile(outFile));

        //raderar filen så att testet kan köras på nytt
        deleteFile(outFile);

    }

    public int countLinesInFile(Path fileToCount){
        int lines = 0;
        try (BufferedReader reader = Files.newBufferedReader(fileToCount)) {
            while (reader.readLine() != null)
                lines++;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lines;
    }

    public String readLineInFile(Path fileToRead) {
        String stringInFile = "";
        try (Scanner sc = new Scanner(fileToRead)) {
            while (sc.hasNextLine())
                stringInFile = sc.nextLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return stringInFile;
    }
    public void deleteFile(Path fileToDelete) {
        try {
            Files.delete(fileToDelete);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
