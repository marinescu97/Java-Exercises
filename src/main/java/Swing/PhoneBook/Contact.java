package Swing.PhoneBook;

/**
 * This class represents a contact object.
 * It is a person from the contact list.
 */
public class Contact {
    /**
     * The contact id.
     */
    private static int id=0;
    /**
     * The contact's code.
     */
    private int code;
    /**
     * The contact information.
     */
    private String lastName, firstName, phoneNumber;

    /**
     * Constructs a new contact object.
     * @param lastName The contact's last name.
     * @param firstName The contact's first name.
     * @param phoneNumber The contact's phone number.
     */
    public Contact(String lastName, String firstName, String phoneNumber) {
        Contact.id++;
        this.code = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the contact's id.
     * @return the contact's id.
     */
    public static int getId() {
        return id;
    }

    /**
     * Sets the contact's id.
     * @param id the contact's id
     */
    public static void setId(int id) {
        Contact.id = id;
    }

    /**
     * Gets the contact's code.
     * @return the contact's code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the contact's code.
     * @param code the contact's code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the contact's last name.
     * @return the contact's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the contact's last name.
     * @param lastName the contact's last
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the contact's first name.
     * @return the contact's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the contact's first name.
     * @param firstName the contact's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the contact's phone number.
     * @return the contact's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the contact's phone number.
     * @param phoneNumber the contact's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Displays a contact.
     * @return the way a contact is displayed
     */
    @Override
    public String toString() {
        return "<html>" + getCode() + ". " +
                getLastName() + " " + getFirstName() + "<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;" + getPhoneNumber() + "&nbsp";
    }
}
