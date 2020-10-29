import java.util.Scanner;

public class TravProfInterface {

    public TravProfInterface(String dbFile) {
        this.db = TravProfDB(dbFile);
    }

    public static void main(String[] args) {
        //menu options
        boolean run = true;
        while(run) {
            System.out.println("Welcome to Kayne ITS");
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

    public static boolean getUserChoice(){
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch (option) {
            case 0:
                return false;
            case 1:
                return createNewTravProf();
            case 2
                return deleteTravProf();
            case 3:
                findTravProf();
                return displayTravProf();
            case 4:
                return UpdateTravProf();
            case 5:
                return displayAllTravProf();
            case 6:
                return writeToDB();
            case 7:
                return initDB();
        }
    }

    public boolean deleteTravProf(){
        String[] profile = promptProfile();
        boolean deleted = this.db.deleteProfile(profile[0], profile[1]);
        if (deleted) {
            System.out.println("Deleted.");
        }
        else {
            System.out.println("Profile doesn't exist.");
        }
        return true;
    }

    public boolean findTravProf(){
        String[] profile = promptProfile();
        TravProf tp = this.db.findProfile(profile[0], profile[1]);
        if (tp != null) {
            displayTravProf(tp);
        }
        else {
            System.out.println("Profile doesn't exist.");
        }
        return true;
    }
    public static void UpdateTravProf(){
        String[] profile = promptProfile();
        TravProf tp = this.db.findProfile(profile[0], profile[1]);
        if (tp != null) {
            System.out.println("What would you like to update?");
            System.out.println("(1) Update traveler's personal information");
            System.out.println("(2) Update traveler's medical information");

            Scanner in = new Scanner(System.in);
            int option = in.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Select the personal information to update.");
                    System.out.println("(1) Address");
                    System.out.println("(2) Phone");
                    System.out.println("(3) Travel Type");
                    System.out.println("(4) Trip Cost");
                    System.out.println("(5) Payment Type");
                    option = in.nextInt();
                    System.out.println("Enter new information:");
                    String newInfo = in.nextLine();
                    switch (option) {
                        case 1: {
                            tp.updateAddress(newInfo);
                            return true;
                        }
                        case 2: {
                            tp.updatePhone(newInfo);
                            return true;
                        }
                        case 3: {
                            tp.updateTravelType(newInfo);
                            return true;
                        }
                        case 4: {
                            tp.updateTripCost(newInfo);
                            return true;
                        }
                        case 5: {
                            tp.updatePaymentType(newInfo);
                            return true;
                        }
                    }
                }
                case 2: {
                    System.out.println("Select the medical information to update.");
                    System.out.println("(1) Medical Contact's Name");
                    System.out.println("(2) Medical Contact's Phone #");
                    System.out.println("(3) Illnesses");
                    System.out.println("(4) Allergies");
                    option = in.nextInt();
                    System.out.println("Enter new information:");
                    String newInfo = in.nextLine();
                    MedCond medInfo = tp.getMedCondInfo()
                    switch (option) {
                        case 1: {
                            medInfo.updateMdContact(newInfo);
                            return true;
                        }
                        case 2: {
                            medInfo.updateMdPhone(newInfo);
                            return true;
                        }
                        case 3: {
                            medInfo.updateIllType(newInfo);
                            return true;
                        }
                        case 4: {
                            medInfo.updateAlgType(newInfo);
                            return true;
                        }
                    }
                }
            }
        }
    }
    public static boolean displayTravProf(TravProf tp){
        System.out.printf("ID: %s%n", tp.gettraveAgentID());
        System.out.printf("First Name: %s%n", tp.getFirstName());
        System.out.printf("Last Name: %s%n", tp.getLastName());
        System.out.printf("Address: %s%n", tp.getAddress());
        System.out.printf("Phone Number: %s%n", tp.getPhone());
        System.out.printf("Trip Cost: %s%n", tp.getTripCost());
        System.out.printf("Travel Type: %s%n", tp.getTravelType());
        System.out.printf("Payment Type: %s%n", tp.getPaymentType());
        System.out.printf("Medical Condition: %s%n", tp.getMedCondInfo());

        return true;
    }

    public boolean displayAllTravProf() {
        Scanner in = new Scanner(System.in);
        System.out.println("Agent ID:");
        String travAgentID = in.nextLine();

        TravProf p = this.db.findFirstProfile();
        while (p != null) {
            if (TravProf.gettravAgentID() == travAgentID) {
                displayTravProf(p);
            }
            p = this.db.findNextProfile();
        }
        return true;
    }

    public boolean writeToDB(){
        this.db.writeAllTravProf();
        return true;
    }
    public boolean initDB(){
        this.db.initializeDataBase();
        return true;
    }
    public boolean createNewTravProf(){
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
        Float tripcost = in.nextFloat();
        System.out.println("Travel:");
        String traveltype = in.nextLine();
        System.out.println("Payment type:");
        String paytype = in.nextLine();

        MedCond md = createNewMedCond();

        TravProf tp = new TravProf(travAgentID, firstname, lastname, address, number, tripcost, traveltype, paytype, md);
        this.db.insertNewProfile(tp);
        return true;
    }
    public MedCond createNewMedCond(){
        Scanner in = new Scanner(System.in);
        System.out.println("Medical contact name:");
        String contact = in.nextLine();
        System.out.println("Medical contact's phone number:");
        String number = in.nextLine();
        System.out.println("Allergies (none, food, medication, or other):");
        String allergies = in.nextLine();
        System.out.println("Illnesses (none, heart, diabetes, asthma, or other):");
        String illnesses = in.nextLine();

        return new MedCond(contact, number, allergies, illnesses)
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
