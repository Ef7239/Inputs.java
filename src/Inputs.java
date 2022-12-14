import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Inputs {
    Contact p = new Contact();
    Scanner keyboard = new Scanner(System.in);
    String n = "1";
    BufferedReader br = null;
    FileReader fr = null;

    String line;

    public void readDir(){
        try {
            br = new BufferedReader(new FileReader("Dir.txt"));

            while ((line = br.readLine()) != null){
                p.setFirstName(line);
                p.setLastName(br.readLine());
                p.setPhNum(br.readLine());


                p.addToDir(p);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public void enterContact() {
        System.out.println("\nEnter contact details when prompted: \n");


        do {
            System.out.print("Enter first name: ");
            p.setFirstName(keyboard.nextLine());

            System.out.print("Enter last name: ");
            p.setLastName(keyboard.nextLine());

            System.out.print("Enter phone number: ");
            p.setPhNum(keyboard.nextLine());

            p.addToDir(new Contact(p.getFirstName(), p.getLastName(), p.getPhNum()));

            System.out.println("\nEnter 1 to add more contacts, any key to stop: ");

            n = keyboard.nextLine();

        } while (n.equals("1"));
        n = "1";
    }

    public void search() {
        String nm = "7";
        do {
            System.out.print("\nHow would you like to search? Enter 5 to search by first name, or 6 to search by last name, or any other key to go back: ");

            String a = keyboard.nextLine();

            if (a.equals("5") || (a.equals("6"))) {
                System.out.print("\nEnter name: ");
                String name = keyboard.nextLine();
                p.retrieve(name, a);
            }

            System.out.print("\nEnter 7 to search for another contact, any key to stop: ");
            nm = keyboard.nextLine();
                p.tempArr.clear();


        } while (nm.equals("7"));
        n = "1";
    }

    public void deleteContact() {
        System.out.print("\nHow would you like to search? Enter 5 to search by first name, or 6 to search by last name, or any other key to go back: ");

        String a = keyboard.nextLine();
        if (a.equals("5") || (a.equals("6"))) {
            System.out.print("Enter name: ");
            String name = keyboard.nextLine();


            p.delete(name, a);

        }
    }

    public void displayDir() {
        p.display();
    }

    public void saveDir(){
        p.saveDir();
    }
}


