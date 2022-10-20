import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {

    public static List<Person> readDataFromFileAddToList(Path p) {
        List<Person> allPeople = new ArrayList<>();
        String firstLine = "";
        String secondLine = "";
        String[] personDataPartsFirstLine;

        try(Scanner sc = new Scanner(p)){
            while (sc.hasNextLine()){
                firstLine = sc.nextLine();
                personDataPartsFirstLine = firstLine.split(",");
                if (sc.hasNextLine())
                    secondLine = sc.nextLine();
                allPeople.add(new Person(personDataPartsFirstLine[1].trim(), personDataPartsFirstLine[0],
                        secondLine));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return allPeople;
    }
}
