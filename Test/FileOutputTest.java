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

    @Test
    public void writePersonToFileTest() {
        Person client = new Person("Emma Vainio", "1234567890", "2021-10-20");
        Path outFile = Paths.get("Test/ClientTrackerTest.txt");
        LocalDate testDate = LocalDate.of(2022, 10, 19);

        FileOutput.writePersonToFile(client, testDate, outFile);
        assertEquals(1, countLinesInFile(outFile));
        assertNotEquals(2, countLinesInFile(outFile));

        assertEquals("Emma Vainio, 1234567890, besökte gymmet 2022-10-19", readLinesInFile(outFile));
        assertNotEquals("Emma Vainio, besökte gymmet 2022", readLinesInFile(outFile));

        //Testar att metoden writePersonToFile appendar och inte skriver över
        FileOutput.writePersonToFile(client, testDate, outFile);
        assertEquals(2, countLinesInFile(outFile));
        assertNotEquals(1, countLinesInFile(outFile));

        //Ta bort all info i filen så att testerna kan köras på nytt utan att det ställer till det
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

    public String readLinesInFile(Path fileToRead) {
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
}
