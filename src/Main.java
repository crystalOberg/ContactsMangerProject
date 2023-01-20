import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ContactManagerApplication contactManagerApplication = new ContactManagerApplication("123-456-7891");

    public static void main(String[] args) throws FileNotFoundException {

        boolean exitRequested = false;
        while(!exitRequested) {
            Application.printMenu();
            int options = Integer.parseInt(sc.nextLine());
            switch (options) {
                case 1:
                    contactManagerApplication.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    exitRequested = true;
                    System.out.println("Have a wonderful day!");
                    break;
            }
        }
    }
    private static void addContact() {
        System.out.println("Name?");
        String name = sc.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = sc.nextLine();
        if (phoneNumber.length() != 10) {
            System.out.println("Invalid input!");
        } else {
            contactManagerApplication.addContact(name, phoneNumber);
        }
    }
    private static void searchContact() {

        System.out.println("Please enter name ");
        String name = sc.nextLine();
        if (contactManagerApplication.searchContactByName(name, name) == -1) {
            System.out.println("No contact found with that name " + name);
        } else {
            contactManagerApplication.searchContactByName(name, name);
        }
    }
    private static void removeContact(){
        System.out.println("Which contact would you like to remove?" +"\n" +
                "Please enter name.");
        String phoneNumber = sc.nextLine();
        contactManagerApplication.removeContact(phoneNumber);
        }
    }





