public class DeleteContact extends Contact {

    public static void deleteContact() {
        Contact contact = new Contact();
        System.out.print("\nHow would you like to search? Enter 5 to search by first name, " +
                "or 6 to search by last name, or any other key to go back: ");

        String a = keyboard.nextLine();
        if (a.equals("5") || (a.equals("6"))) {
            System.out.print("Enter name: ");
            String name = keyboard.nextLine();


            contact.delete(name, a);

        }
    }
}
