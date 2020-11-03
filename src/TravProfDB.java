import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TravProfDB {
    int numTravelers, currentTravelerIndex;
    String dbName;
    ArrayList<TravProf> travelerList;


    public TravProfDB(String fileName) throws IOException, ClassNotFoundException {
        this.numTravelers = 0;
        this.currentTravelerIndex = -1;
        this.dbName = fileName;
        this.travelerList = new ArrayList<TravProf>();

        findFirstProfile();
    }

    public void insertNewProfile(TravProf profile) {
        this.travelerList.add(profile);
    }

    public boolean deleteProfile(String travAgentID, String lastName) {
        // Returns true if TravProf with travAgentID and lastName is found and deleted
        for (int i = 0; i < this.travelerList.size(); i++) {
            TravProf curr = this.travelerList.get(i);
            if (curr.gettravAgentID().equals(travAgentID) & curr.getLastName().equals(lastName)) {
                this.travelerList.remove(i);
                return true;
            }
        }
        return false;
    }

    public TravProf findProfile(String travAgentID, String lastName) {
        for (int i = 0; i < this.travelerList.size(); i++) {
            TravProf curr = this.travelerList.get(i);
            if (curr.gettravAgentID().equals(travAgentID) & curr.getLastName().equals(lastName)) {
                return curr;
            }
        }
        return null;
    }

    public TravProf findFirstProfile() {
        this.currentTravelerIndex = 0;
        if (this.currentTravelerIndex < this.travelerList.size()){
            return this.travelerList.get(this.currentTravelerIndex);
        }
        return null;
    }

    public TravProf findNextProfile() {
        this.currentTravelerIndex++;
        if (this.currentTravelerIndex < this.travelerList.size()){
            return this.travelerList.get(this.currentTravelerIndex);
        }
        return null;
    }
    void writeAllTravProf() throws IOException{                              // Save
        FileOutputStream outputStream = new FileOutputStream(dbName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(travelerList);
        objectOutputStream.close();
    }
    void initializeDataBase() throws IOException, ClassNotFoundException {     // Load
        FileInputStream inputStream = new FileInputStream(this.dbName);

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            this.travelerList = (ArrayList<TravProf>)objectInputStream.readObject();
            objectInputStream.close();
        } catch (EOFException eofex) {
            //do nothing
        } catch (IOException ioex) {
            throw ioex;
        }
    }
}
