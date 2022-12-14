
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        Inputs in = new Inputs();

        Scanner keyboard = new Scanner(System.in);
        String n;

        try {
            in.readDir();
        } catch (Exception e) {
            System.out.println("There was an issue reading data file.");
        }


        do {

            System.out.print("\nWhat would you like to do?:\n Press 1 to enter a new contact, 2 to look up a contact," +
                    " 3 to delete a contact, 4 to display entire directory, or any other key to quit: ");
            n = keyboard.nextLine();
            switch (n) {
                case "1": {

                    EnterContact.enterContact();
                    n="1";

                    break;
                }

                case "2": {
                    ContactSearch.search();
                    n="1";

                    break;


                }

                case "3": {
                    DeleteContact.deleteContact();
                    n="1";

                    break;

                }

                case "4": {
                    DisplayContact.displayDir();
                    n="1";

                    break;


                }

                default:{
                    SaveDir.saveDir();
                }
            }


        }while (n.equals("1")) ;

    }
}

