import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class TravProfDB {
    int numTravelers, currentTravelerIndex;
    String fileName;
    ArrayList<TravProf> travelerList;

    public TravProfDB(String fileName) {
        this.numTravelers = 0;
        this.currentTravelerIndex = -1;
        this.travelerList = new ArrayList<TravProf>();

        initializeDataBase(fileName);
        findFirstProfile()
    }

    public void insertNewProfile(TravProf profile) {
        this.travelerList.add(profile);
    }

    public boolean deleteProfile(String travAgentID, String lastName) {
        // Returns true if TravProf with travAgentID and lastName is found and deleted
        for (int i = 0; i < this.travelerList.length; i++) {
            TravProf curr = this.travelerList[i];
            if (curr.gettraveAgentID() == travAgentID & curr.getLastName() == lastName) {
                this.travelerList.remove(i);
                return true;
            }
        }
        return false;
    }

    public TravProf findProfile(String travAgentID, String lastName) {
        for (int i = 0; i < this.travelerList.length; i++) {
            TravProf curr = this.travelerList[i];
            if (curr.gettraveAgentID() == travAgentID & curr.getLastName() == lastName) {
                return curr;
            }
        }
        return null;
    }

    public TravProf findFirstProfile() {
        this.currentTravelerIndex = 0;
        return this.travelerList.get(this.currentTravelerIndex);
    }

    public TravProf findNextProfile() {
        this.currentTravelerIndex++;
        return this.travelerList.get(this.currentTravelerIndex);
    }

    private initializeDataBase(String fileName) {
        Scanner s = new Scanner(new File(fileName));
        while (s.hasNextLine()){
            insertNewProfile(s.nextLine());
        }
        //update this.numTravelers
    }
}
