import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ContactManagerApplication contactManagerApplication = new ContactManagerApplication("123456789");

    public static void main(String[] args){

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
                    removeContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    changeContact();
                    break;
                case 6:
                    exitRequested = true;
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
            System.out.println("Wrong input!");
        } else {
            contactManagerApplication.addContact(name, phoneNumber);
        }
    }
    private static void removeContact(){
        System.out.println("Which contact would you like to remove?" +"\n" +
                "Please type phone number.");
        String phoneNumber = sc.nextLine();
        contactManagerApplication.removeContact(phoneNumber);
    }

    private static void searchContact(){

        System.out.println("Please enter phone number ");
        String phoneNumber = sc.nextLine();
        if(contactManagerApplication.searchContactByPhoneNumber(phoneNumber) == -1) {
            System.out.println("No contact found with phone number " + phoneNumber);
        } else {
            contactManagerApplication.searchContactByPhoneNumber(phoneNumber);
        }
    }

    private static void changeContact(){
        System.out.println("Which contact would you like to modify?");
        String currentName = sc.nextLine();
        System.out.println("Enter your modify");
        String updatedName = sc.nextLine();
        contactManagerApplication.changeContact(currentName,updatedName);
    }
}



