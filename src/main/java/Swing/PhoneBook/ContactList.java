package Swing.PhoneBook;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class represents a list of {@link Contact} objects.
 */
public class ContactList {
    /**
     * A list of {@link Contact} objects.
     */
    private List<Contact> contacts;

    /**
     * Creates a new contact list.
     */
    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Gets the list of contacts.
     * @return the list of contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * Sets the list of contacts.
     * @param contacts the list of contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Adds a new contact to the list of contacts.
     * @param lastName the last name of the contact
     * @param firstName the first name of the contact
     * @param phoneNumber the phone number of the contact
     */
    public void addContact(String lastName, String firstName, String phoneNumber){
        // If the phone number is valid, a new contact is added to the list, otherwise a corresponding message is displayed.
        if (checkPhoneNumber(phoneNumber)){
            Contact contact = new Contact(lastName, firstName, phoneNumber);
            contacts.add(contact);
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid phone number!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Deletes a contact from the list of contacts.
     * It also renumbers contacts from the list.
     * @param contact the contact to be deleted
     */
    public void deleteContact(Contact contact){
        contacts.remove(contact);

        for (int i = 0; i<contacts.size(); i++){
            contacts.get(i).setCode(i+1);
        }

        Contact.setId(contacts.get(contacts.size()-1).getCode());
    }

    /**
     * Updates a contact information.
     * @param code the contact code
     * @param lastName the contact's last name
     * @param firstName the contact's first name
     * @param phoneNumber the contact's phone number
     * @return
     */
    public boolean updateContact(int code, String lastName, String firstName, String phoneNumber){
        // If the new phone number is valid, the contact's data is changed, otherwise a corresponding message is displayed.
        if (checkPhoneNumber(phoneNumber)){
            for (int i = 0; i<contacts.size(); i++){
                if (contacts.get(i).getCode() == code){
                    contacts.get(i).setLastName(lastName);
                    contacts.get(i).setFirstName(firstName);
                    contacts.get(i).setPhoneNumber(phoneNumber);
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid phone number!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    /**
     * Checks if a phone number is valid.
     * @param phoneNumber the given phone number
     * @return true if the phone number is valid, false otherwise
     */
    public boolean checkPhoneNumber(String phoneNumber){
        String regex = "^00\\d{2}-\\d{3}-\\d{6}$";

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(phoneNumber).matches();
    }
}
