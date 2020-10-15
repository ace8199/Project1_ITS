import java.util.Scanner;
public class TravProfInterface {
    public static void  main (String[ ] args) {
        TravProf[] obj = new TravProf[100] ;

        //menu options
        while(true) {
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
            Scanner in = new Scanner(System.in);
            int options = in.nextInt();
            if(options == 0){
                break;
            }

            getUserChoice(obj,options);

        }
    }

    public static void getUserChoice(TravProf[]  obj,int options){
        if (options == 1){
            createNewTravProf(obj);
        }else if(options == 2){
            deleteTravProf();
        }else if(options == 3){
            findTravProf();
            displayTravProf(obj);
        }else if(options == 4){
            UpdateTravProf();
        }else if(options == 5){
            displayAllTravProf(obj);
        }else if(options == 6){
            writeToDB();
        }else if(options == 7){
            initDB();
        }
    }
    public static void deleteTravProf(){

    }
    public static void findTravProf(){

    }
    public static void UpdateTravProf(){

    }
    public static void displayTravProf(TravProf[] obj){
        //System.out.println(obj[0].g);
        System.out.println(obj[0].getFirstName());
        System.out.println(obj[0].getLastName());
    }
    public static void displayAllTravProf(TravProf[] obj) {
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i].getFirstName());
            System.out.println(obj[i].getLastName());
            System.out.println(obj[i].getAddress());
            System.out.println(obj[i].getPhone());
            System.out.println(obj[i].getTripCost());
            System.out.println(obj[i].getTravelType());
            System.out.println(obj[i].getPaymentType());
            System.out.println("-----------------------");
        }
    }
    public static void writeToDB(){

    }
    public static void initDB(){

    }
    public static TravProf[] createNewTravProf(TravProf[] obj){
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

        obj[0] = new TravProf(travAgentID,firstname,lastname,address,number,tripcost,traveltype,paytype);

        return obj;
    }
    public void createNewMedCont(){

    }
}
