import java.util.ArrayList;

public class ContactManagerApplication {
        private String phoneNumber;

        public ArrayList<Contact> myContacts = new ArrayList<Contact>();

        public ContactManagerApplication(String s) {
        }

        public void contactManagerProject(String phoneNumber) {
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
            if (searchContactByPhoneNumber(phoneNumber) == -1) {
                Contact contact = new Contact(name, phoneNumber);
                myContacts.add(contact);
                System.out.println("Contact " + name + " with phone number " + phoneNumber + " just added!");
            } else {
                System.out.println("This contact is already on your list.");
            }
        }
        public void removeContact(String phoneNumber) {
            int index = searchContactByPhoneNumber(phoneNumber);
            if (index >= 0) {
                System.out.println("You have removed " + myContacts.get(index).getName());
                myContacts.remove(index);
            }
        }

        public int searchContactByPhoneNumber(String phoneNumber) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (phoneNumber.equals(myContacts.get(i).getPhoneNumber())) {
                    System.out.println(myContacts.get(i).getName() + " Found!");
                    return i;
                }
            }
            return -1;
        }

        public int searchContactByName(String name){
            for(int i =0; i<myContacts.size(); i++){
                if(name.equals(myContacts.get(i).getName())) {
                    return i;
                }
            }
            return -1;
        }

        public void changeContact(String oldName, String newName) {
            int index = searchContactByName(oldName);
            if(index >=0){
                Contact updatedContact = new Contact(newName,myContacts.get(index).getPhoneNumber());
                myContacts.set(index,updatedContact);
                System.out.println("You have changed contact " +oldName + " to " + newName + "\n" +
                        "Phone number: " +myContacts.get(index).getPhoneNumber());
            } else {
                System.out.println("No contact named " + oldName + " on your contact list");
            }
        }
    }

