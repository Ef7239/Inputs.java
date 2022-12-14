public class EnterContact extends Contact{

    public static void enterContact() {
        Contact p = new Contact();
        System.out.println("\nEnter contact details when prompted: \n");


        String n;
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
}
