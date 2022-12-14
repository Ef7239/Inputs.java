import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Contact {
    private String firstName;
    private String lastName;
    private String phNum;
    static ArrayList<Contact> dir = new ArrayList<>();
    static ArrayList<Contact> tempArr = new ArrayList<>();
    static BufferedWriter bw = null;


    static Scanner keyboard = new Scanner(System.in);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phNum = phNum;
    }

    public void addToDir(Contact p) {
        dir.add(new Contact(firstName, lastName, phNum));
        try {
            dir.sort((p1, p2) -> {
                if (p1.getLastName().equals(p2.getLastName())) {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                } else {
                    return p1.getLastName().compareTo(p2.getLastName());
                }
            });
        } catch (Exception e) {
            System.out.println("There was an error adding the name");
        }
    }


   void display() {
        if (dir.isEmpty()) {
            System.out.println("Directory is empty");
        } else {
            System.out.println();

            for (int i = 0; i < dir.size(); i++) {

                System.out.println(i+1 + ")" + dir.get(i).firstName + " " + dir.get(i).lastName
                        + " - " + dir.get(i).phNum);
            }
        }
    }
    public static void displayTempArr() {
        if (!tempArr.isEmpty()) {
            for (int index = 0; index < tempArr.size(); index++) {
                System.out.println("\nContacts found: \n");
                System.out.println((index + 1) + ")" + tempArr.get(index).getFirstName()
                        + " " + tempArr.get(index).getLastName() + " - " + tempArr.get(index).getPhNum());
            }
        }else {
            System.out.println("\nNo contacts found");
        }
    }
    static void retrieve(String name, String a) {
        switch (a) {
            case "5" -> {
                for (Contact contact : dir) {
                    if ((name.equalsIgnoreCase(contact.getFirstName()))) {
                        tempArr.add(contact);
                    }
                }
            }
            case "6" -> {
                for (Contact contact : dir) {
                    if (name.equalsIgnoreCase(contact.getLastName())) {
                        tempArr.add(contact);
                    }
                }
            }
            default -> {
            }
        }
        displayTempArr();
    }



    void delete(String name, String a) {
        String del="";
        retrieve(name, a);
        if (!tempArr.isEmpty()){
            del = "1";
        }
            do {
                for (Contact contact : tempArr) {
                    System.out.print("\nDo you want to delete this contact?:\n");
                    System.out.println("\n" + contact.getFirstName() + " "
                            + contact.getLastName() + " - " + contact.getPhNum());
                    System.out.println("\nPress 2 to delete, or any other key to go back :\n");

                    del = keyboard.nextLine();

                    System.out.println(del);
                    if(Objects.equals(del, "2")){
                        dir.remove(contact);
                        System.out.println("\nContact has been deleted");
                    }

                }

            } while (del.equals("1"));
            tempArr.clear();
    }


}



