public class ContactSearch extends Contact{

    public static void search() {
        Contact contact = new Contact();
        String nm = "7";
        do {
            System.out.print("\nHow would you like to search? Enter 5 to search by first name, " +
                    "or 6 to search by last name, or any other key to go back: ");

            String a = keyboard.nextLine();

            if (a.equals("5") || (a.equals("6"))) {
                System.out.print("\nEnter name: ");
                String name = keyboard.nextLine();
                contact.retrieve(name, a);
            }

            System.out.print("\nEnter 7 to search for another contact, any key to stop: ");
            nm = keyboard.nextLine();
            Contact.tempArr.clear();


        } while (nm.equals("7"));
        String n = "1";
    }

}
