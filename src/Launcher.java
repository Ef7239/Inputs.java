import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Contact p = new Contact();
        Inputs in = new Inputs();
        Scanner keyboard = new Scanner(System.in);
        String n = "1";

        try {
            in.readDir();
        } catch (Exception e) {
        }


        do {

            System.out.print("\nWhat would you like to do?:\n Press 1 to enter a new contact, 2 to look up a contact, 3 to delete a contact, 4 to display entire directory, or any other key to quit: ");
            n = keyboard.nextLine();
            switch (n) {
                case "1": {

                    in.enterContact();
                    n="1";

                    break;
                }

                case "2": {
                    in.search();
                    n="1";

                    break;


                }

                case "3": {
                    in.deleteContact();
                    n="1";

                    break;

                }

                case "4": {
                    in.displayDir();
                    n="1";

                    break;


                }

                default:{
                    in.saveDir();
                }
            }


        }while (n.equals("1")) ;

    }
}

