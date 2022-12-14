import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Contact {
    private String firstName;
    private String lastName;
    private String phNum;
    ArrayList<Contact> dir = new ArrayList<>();
    ArrayList<Contact> tempArr = new ArrayList<>();
    BufferedWriter bw = null;
    //FileWriter fw = null;

    Scanner keyboard = new Scanner(System.in);

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
            Collections.sort(dir, new Comparator<Contact>() {
                @Override
                public int compare(Contact p1, Contact p2) {
                    if (p1.getLastName().equals(p2.getLastName())) {
                        return p1.getFirstName().compareTo(p2.getFirstName());
                    } else {
                        return p1.getLastName().compareTo(p2.getLastName());
                    }
                }
            });
        } catch (Exception e) {
        }
    }


    public void display() {
        if (dir.isEmpty()) {
            System.out.println("Directory is empty");
        } else {
            System.out.println();

            for (int i = 0; i < dir.size(); i++) {

                System.out.println(i+1 + ")" + dir.get(i).firstName + " " + dir.get(i).lastName + " - " + dir.get(i).phNum);
            }
        }
    }

    public void retrieve(String name, String a) {
        switch (a) {
            case "5": {
                for (int index = 0; index < dir.size(); index++) {
                    if ((name.equalsIgnoreCase(dir.get(index).getFirstName()))) {
                        tempArr.add(dir.get(index));
                    }
                }
                break;
            }
            case "6": {
                for (int index = 0; index < dir.size(); index++) {
                    if (name.equalsIgnoreCase(dir.get(index).getLastName())) {
                        tempArr.add(dir.get(index));
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        displayTempArr();
    }

    public void displayTempArr() {
        if (!tempArr.isEmpty()) {
            for (int index = 0; index < tempArr.size(); index++) {
                System.out.println("\nContacts found: \n");
                System.out.println((index + 1) + ")" + tempArr.get(index).getFirstName() + " " + tempArr.get(index).getLastName() + " - " + tempArr.get(index).getPhNum());
            }
        }else {
            System.out.println("\nNo contacts found");
        }
        }

    public void delete(String name, String a) {
        String del="";
        retrieve(name, a);
        if (!tempArr.isEmpty()){
            del = "1";
        }
            do {
                for (int count = 0; count < tempArr.size(); count++) {
                    System.out.print("\nDo you want to delete this contact?:\n");
                    System.out.println("\n" + tempArr.get(count).getFirstName() + " " + tempArr.get(count).getLastName() + " - " + tempArr.get(count).getPhNum());
                    System.out.println("\nPress 2 to delete, or any other key to go back :\n");

                    del = keyboard.nextLine();

                    System.out.println(del);
                    switch (del) {
                        case "2": {
                            dir.remove(tempArr.get(count));
                            System.out.println("\nContact has been deleted");
                            break;
                        }
//                        case "3": {
//                            System.out.println("\nContact not deleted");
//                            break;
//                        }
                        default: {
                            break;
                        }
                    }
                }

            } while (del.equals("1"));
            tempArr.clear();
    }

    public void saveDir(){
        try {
            bw =new BufferedWriter (new FileWriter("Dir.txt"));
            for (int i = 0; i < dir.size(); i++){
                bw.write(dir.get(i).firstName + "\n");
                bw.write(dir.get(i).lastName + "\n");
                bw.write(dir.get(i).phNum + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



