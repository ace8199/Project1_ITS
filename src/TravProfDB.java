import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TravProfDB {
    int numTravelers, currentTravelerIndex;
    String fileName;
    TravProf[] travelerList;

    public TravProfDB(String fileName) {
        initializeDataBase(fileName);
        findFirstProfile()
    }

    public insertNewProfile(TravProf profile) {

    }

    private initializeDataBase(String fileName) {
        Scanner s = new Scanner(new File(fileName));
        while (s.hasNextLine()){
            insertNewProfile(s.nextLine());
        }
    }
}
