import java.io.IOException;
import java.util.Scanner;

public class TravProfInterface {

    static TravProfDB db;

    public TravProfInterface(String dbFile) throws IOException, ClassNotFoundException {
        db = new TravProfDB(dbFile);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //menu options
        TravProfInterface inter = new TravProfInterface("ITS_DB");

        boolean run = true;
        while(run) {
            System.out.println("Welcome to the ITS");
            System.out.println("Please enter the number that corresponds with the menu options");
            System.out.println("(1) Enter a New TravProf");
            System.out.println("(2) Delete a traveler by Name and travelAgentID");
            System.out.println("(3) Find and display a TravProf by Name and travAgentID");
            System.out.println("(4) TravProf Modifications");
            System.out.println("(5) Display all profiles");
            System.out.println("(6) Write to database");
            System.out.println("(7) Initialize database");
            System.out.println("(0) Exit");

            run = getUserChoice();
        }
    }

    public static boolean getUserChoice() throws IOException, ClassNotFoundException{
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int option = Integer.parseInt(line);

        switch (option) {
            case 0:
                return false;
            case 1:
                return createNewTravProf();
            case 2:
                return deleteTravProf();
            case 3:
                return findTravProf();
            case 4:
                return UpdateTravProf();
            case 5:
                return displayAllTravProf();
            case 6:
                return writeToDB();
            case 7:
                return initDB();
            default: {
                System.out.print("Invalid option");
                return true;
            }
        }
    }

    public static boolean deleteTravProf(){
        String[] profile = promptProfile();
        boolean deleted = TravProfInterface.db.deleteProfile(profile[0], profile[1]);
        if (deleted) {
            System.out.println("Deleted.");
        }
        else {
            System.out.println("Profile doesn't exist.");
        }
        return true;
    }

    public static boolean findTravProf(){
        String[] profile = promptProfile();
        TravProf tp = TravProfInterface.db.findProfile(profile[0], profile[1]);
        if (tp != null) {
            displayTravProf(tp);
        }
        else {
            System.out.println("Profile doesn't exist.");
        }
        return true;
    }
    public static boolean UpdateTravProf(){
        String[] profile = promptProfile();
        TravProf tp = TravProfInterface.db.findProfile(profile[0], profile[1]);
        if (tp != null) {
            System.out.println("What would you like to update?");
            System.out.println("(1) Address");
            System.out.println("(2) Phone");
            System.out.println("(3) Travel Type");
            System.out.println("(4) Trip Cost");
            System.out.println("(5) Payment Type");
            System.out.println("(6) Medical Contact's Name");
            System.out.println("(7) Medical Contact's Phone #");
            System.out.println("(8) Illnesses");
            System.out.println("(9) Allergies");

            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            int option = Integer.parseInt(line);

            while (option < 1 | option > 9) {
                System.out.println("Invalid option");
                option = Integer.parseInt(in.nextLine());
            }

            String newInfo = "";
            MedCond medInfo = tp.getMedCondInfo();

            switch (option) {
                case 1: {
                    System.out.println("What's the new info?");
                    newInfo = in.nextLine();
                    tp.updateAddress(newInfo);
                    return true;
                }
                case 2: {
                    System.out.println("What's the new info?");
                    newInfo = in.nextLine();
                    tp.updatePhone(newInfo);
                    return true;
                }
                case 3: {
                    System.out.println("New Travel Type? (1) Business (2) Pleasure");
                    option = Integer.parseInt(in.nextLine());
                    switch (option){
                        case 1: newInfo = "Business"; break;
                        case 2: newInfo = "Pleasure"; break;
                        default: {
                            System.out.println("Invalid!");
                            System.out.println("New Travel Type? (1) Business (2) Pleasure");
                            option = Integer.parseInt(in.nextLine());
                        }
                    }

                    tp.updateTravelType(newInfo);
                    return true;
                }
                case 4: {
                    System.out.println("What's the new info?");
                    newInfo = in.nextLine();
                    float newcost = Float.valueOf(newInfo);
                    tp.updateTripCost(newcost);
                    return true;
                }
                case 5: {
                    System.out.println("New Payment Type? (1) Credit (2) Check (3) Debit (4) Invoice");
                    option = Integer.parseInt(in.nextLine());
                    switch (option){
                        case 1: newInfo = "Credit"; break;
                        case 2: newInfo = "Check"; break;
                        case 3: newInfo = "Debit"; break;
                        case 4: newInfo = "Invoice"; break;
                        default: {
                            System.out.println("Invalid!");
                            System.out.println("New Payment Type? (1) Credit (2) Check (3) Debit (4) Invoice");
                            option = Integer.parseInt(in.nextLine());
                        }
                    }
                    tp.updatePaymentType(newInfo);
                    return true;
                }
                case 6: {
                    System.out.println("What's the new info?");
                    newInfo = in.nextLine();
                    medInfo.updateMdContact(newInfo);
                    return true;
                }
                case 7: {
                    System.out.println("What's the new info?");
                    newInfo = in.nextLine();
                    medInfo.updateMdPhone(newInfo);
                    return true;
                }
                case 8: {
                    System.out.println("New Illness Type? (1) none (2) heart (3) diabetes (4) asthma (5) other");
                    option = Integer.parseInt(in.nextLine());
                    switch (option){
                        case 1: newInfo = "none"; break;
                        case 2: newInfo = "heart"; break;
                        case 3: newInfo = "diabetes"; break;
                        case 4: newInfo = "asthma"; break;
                        case 5: newInfo = "other"; break;
                        default: {
                            System.out.println("Invalid!");
                            System.out.println("New Illness Type? (1) none (2) heart (3) diabetes (4) asthma (5) other");
                            option = Integer.parseInt(in.nextLine());
                        }
                    }
                    medInfo.updateIllType(newInfo);
                    return true;
                }
                case 9: {
                    System.out.println("New Allergies? (1) none (2) food (3) medication (4) other");
                    option = Integer.parseInt(in.nextLine());
                    switch (option){
                        case 1: newInfo = "none"; break;
                        case 2: newInfo = "food"; break;
                        case 3: newInfo = "medication"; break;
                        case 4: newInfo = "other"; break;
                        default: {
                            System.out.println("Invalid!");
                            System.out.println("New Allergies? (1) none (2) food (3) medication (4) other");
                            option = Integer.parseInt(in.nextLine());
                        }
                    }
                    medInfo.updateAlgType(newInfo);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean displayTravProf(TravProf tp){
        System.out.printf("ID: %s%n", tp.gettravAgentID());
        System.out.printf("First Name: %s%n", tp.getFirstName());
        System.out.printf("Last Name: %s%n", tp.getLastName());
        System.out.printf("Address: %s%n", tp.getAddress());
        System.out.printf("Phone Number: %s%n", tp.getPhone());
        System.out.printf("Trip Cost: %s%n", tp.getTripCost());
        System.out.printf("Travel Type: %s%n", tp.getTravelType());
        System.out.printf("Payment Type: %s%n", tp.getPaymentType());

        MedCond m = tp.getMedCondInfo();
        System.out.printf("Medical Contact: %s%n", m.getMdContact());
        System.out.printf("Medical Phone #: %s%n", m.getMdPhone());
        System.out.printf("Allergies: %s%n", m.getAlgType());
        System.out.printf("Illnesses: %s%n", m.getIllType());

        return true;
    }

    public static boolean displayAllTravProf() {
        Scanner in = new Scanner(System.in);
        System.out.println("Agent ID:");
        String travAgentID = in.nextLine();

        TravProf p = TravProfInterface.db.findFirstProfile();
        while (p != null) {
            if (p.gettravAgentID().equals(travAgentID)) {
                displayTravProf(p);
            }
            p = TravProfInterface.db.findNextProfile();
        }
        return true;
    }

    public static boolean writeToDB() throws IOException, ClassNotFoundException{
        TravProfInterface.db.writeAllTravProf();
        return true;
    }
    public static boolean initDB() throws IOException, ClassNotFoundException{
        TravProfInterface.db.initializeDataBase();
        return true;
    }
    public static boolean createNewTravProf(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your credentials");
        String travAgentID = in.nextLine();
        System.out.println("First name:");
        String firstname = in.nextLine();
        System.out.println("Last name:");
        String lastname = in.nextLine();
        System.out.println("Address:");
        String address = in.nextLine();
        System.out.println("Phone:");
        String number = in.nextLine();
        System.out.println("Trip cost:");
        String cost = in.nextLine();
        float tripcost = Float.valueOf(cost);

        System.out.println("Travel Type (1) Business (2) Pleasure:");
        String line = in.nextLine();
        int option = Integer.parseInt(line);
        String traveltype = "";
        switch (option){
            case 1: traveltype = "Business"; break;
            case 2: traveltype = "Pleasure"; break;
            default: {
                System.out.println("Invalid!");
                System.out.println("Travel Type (1) Business (2) Pleasure:");
                option = Integer.parseInt(in.nextLine());
            }
        }

        System.out.println("Payment type (1) Credit (2) Check (3) Debit (4) Invoice:");
        line = in.nextLine();
        option = Integer.parseInt(line);
        String paytype = "";
        switch (option){
            case 1: paytype = "Credit"; break;
            case 2: paytype = "Check"; break;
            case 3: paytype = "Debit"; break;
            case 4: paytype = "Invoice"; break;
            default: {
                System.out.println("Invalid!");
                System.out.println("Payment type (1) Credit (2) Check (3) Debit (4) Invoice:");
                option = Integer.parseInt(in.nextLine());
            }
        }

        MedCond md = createNewMedCond();

        TravProf tp = new TravProf(travAgentID, firstname, lastname, address, number, tripcost, traveltype, paytype, md);
        TravProfInterface.db.insertNewProfile(tp);
        return true;
    }
    public static MedCond createNewMedCond(){
        Scanner in = new Scanner(System.in);
        System.out.println("Medical contact name:");
        String contact = in.nextLine();
        System.out.println("Medical contact's phone number:");
        String number = in.nextLine();

        System.out.println("Allergies (1) none (2) food (3) medication (4) other:");
        String line = in.nextLine();
        int option = Integer.parseInt(line);
        String allergies = "";
        switch (option){
            case 1: allergies = "none"; break;
            case 2: allergies = "food"; break;
            case 3: allergies = "medication"; break;
            case 4: allergies = "other"; break;
            default: {
                System.out.println("Invalid!");
                System.out.println("Allergies (1) none (2) food (3) medication (4) other:");
                option = Integer.parseInt(in.nextLine());
            }
        }

        System.out.println("Illnesses (1) none (2) heart (3) diabetes (4) asthma (5) other:");
        line = in.nextLine();
        option = Integer.parseInt(line);
        String illnesses = "";
        switch (option){
            case 1: illnesses = "none"; break;
            case 2: illnesses = "heart"; break;
            case 3: illnesses = "diabetes"; break;
            case 4: illnesses = "asthma"; break;
            case 5: illnesses = "other"; break;
            default: {
                System.out.println("Invalid!");
                System.out.println("Illnesses (1) none (2) heart (3) diabetes (4) asthma (5) other:");
                option = Integer.parseInt(in.nextLine());
            }
        }

        return new MedCond(contact, number, allergies, illnesses);
    }

    private static String[] promptProfile() {
        Scanner in = new Scanner(System.in);
        System.out.println("Agent ID:");
        String travAgentID = in.nextLine();
        System.out.println("Last Name:");
        String lastName = in.nextLine();
        return new String[] {travAgentID, lastName};
    }
}
