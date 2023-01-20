import java.util.ArrayList;

public class ContactManagerApplication {
        private String phoneNumber;

        public ArrayList<Contact> myContacts = new ArrayList<Contact>();

        public ContactManagerApplication(String s) {
        }

        public void ContactManagementApplication(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void printContactList() {
            if (!myContacts.isEmpty()) {
                for (int i = 0; i < myContacts.size(); i++) {
                    System.out.println(i + 1 + ". " + "Name: " + myContacts.get(i).getName() + " || Phone number: " + myContacts.get(i).getPhoneNumber());
                }
            } else {
                System.out.println("Your contact list is empty!");
            }
        }

        public void addContact(String name, String phoneNumber) {
            if (searchContactByName(phoneNumber, name) == -1) {
                Contact contact = new Contact(name, phoneNumber);
                myContacts.add(contact);
                System.out.println("Contact " + name + " with phone number " + phoneNumber + " just added!");
            } else {
                System.out.println("This contact is already on your list.");
            }
        }
        public void removeContact(String name) {
            int index = searchContactByName(name, name);
            if (index >= 0) {
                System.out.println("You have removed " + myContacts.get(index).getName());
                myContacts.remove(index);
            }
        }

        public int searchContactByName(String Name, String name) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (name.equals(myContacts.get(i).getName())) {
                    System.out.println(myContacts.get(i).getName() + " Found!");
                    return i;
                }
            }
            return -1;
        }
    }



