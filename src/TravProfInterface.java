import java.util.Scanner;
public class TravProfInterface {
    public static void main (String[ ] args) {
        //menu options
        System.out.println("Welcome to Kayne ITS");
        System.out.println("Please enter the number that corresponds with the menu options");
        System.out.println("(1) Enter a New TravProf");
        System.out.println("(2) Delete a traveler by Name and travelAgentID");
        System.out.println("(3) Find and display a TravProf by Name and travAgentID");
        System.out.println("(4) TravProf Modifications");
        System.out.println("(5) Display all profiles");
        System.out.println("(6) Write to database");
        System.out.println("(7) Initialize database");

        getUserChoice();


    }
    
    public static void getUserChoice(){
        Scanner in = new Scanner(System.in);
        int options = in.nextInt();
        if (options == 1){

        }else if(options == 2){

        }else if(options == 3){

        }else if(options == 4){

        }else if(options == 5){

        }else if(options == 6){

        }else if(options == 7){

        }
    }
    public static void deleteTravProf(){

    }
    public static void findTravProf(){

    }
    public static void UpdateTravProf(){

    }
    public static void displayTravProf(){

    }
    public static void displayAllTravProf(){

    }
    public static void writeToDB(){

    }
    public static void initDB(){

    }
    public static void createNewTravPronf(){

    }
    public static void createNewMedCont(){

    }
}
