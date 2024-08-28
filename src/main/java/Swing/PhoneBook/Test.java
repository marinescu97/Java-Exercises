package Swing.PhoneBook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * The class tests the functionality of the {@link ContactList} class.
 * This is a simple Swing application that displays a list of contacts and allows
 *  the user to add, update, or delete contacts.
 */
public class Test extends JFrame {
    /** The contact list. */
    private ContactList contactList = new ContactList();
    /** The list model for the JList component. */
    private DefaultListModel<Contact> listModel = new DefaultListModel<>();
    /** The JList component that displays the contacts. */
    private JList<Contact> list = new JList<>(listModel);
    /** The empty border around certain components. */
    private EmptyBorder spaceAround = new EmptyBorder(10, 10, 10, 10);
    /** The font used for certain labels and text fields. */
    private Font myFont = new Font("Times Roman", Font.BOLD, 16);
    /**
     * Constructs a new Test frame.
     */
    public Test(){
        setTitle("Contacts");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Contacts");
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setFont(myFont);
        label.setBorder(spaceAround);

        // Adds some sample contacts to the contact list.
        contactList.getContacts().add(new Contact("Popescu", "Cristina", "0040-756-364768"));
        contactList.getContacts().add(new Contact("Sabau", "Marian", "0040-735-936475"));
        contactList.getContacts().add(new Contact("Marinescu", "Monica", "0040-924-724867"));
        contactList.getContacts().add(new Contact("Serban", "Cristian", "0040-154-274658"));
        contactList.getContacts().add(new Contact("Georgescu", "Elena", "0040-758-839547"));
        contactList.getContacts().add(new Contact("Popa", "Andrei", "0040-573-759245"));
        contactList.getContacts().add(new Contact("Gheorghe", "Stefan", "0040-385-836725"));

        listModel.addAll(contactList.getContacts());
        list.setFont(myFont);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(null);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Times Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));

        searchField.setText("Search...");
        searchField.setForeground(Color.GRAY);

        // Adds a focus listener to the search field to clear the text when it is clicked.
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search...")){
                    searchField.setText("");
                    searchField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().equals("")){
                    searchField.setText("Search...");
                    searchField.setForeground(Color.GRAY);
                }
            }
        });

        // Adds a document listener to the search field to filter the list of contacts.
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterList();
            }

            private void filterList() {
                if (searchField.getForeground().equals(Color.black)){
                    String filter = searchField.getText();
                    if (searchField.getText().equals("")){
                        listModel.clear();
                        listModel.addAll(contactList.getContacts());
                    } else {
                        listModel.clear();
                        for (Contact contact : contactList.getContacts()){
                            if (contact.getLastName().toLowerCase().contains(filter.toLowerCase()) || contact.getFirstName().toLowerCase().contains(filter.toLowerCase()) || contact.getPhoneNumber().toLowerCase().contains(filter.toLowerCase())){
                                listModel.addElement(contact);
                            }
                        }
                    }
                }
            }
        });


        listPanel.add(label);
        listPanel.add(scrollPane);
        listPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        listPanel.add(searchField);
        listPanel.setBorder(new EmptyBorder(10, 10 ,10 ,10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton addBtn = new JButton("Add");
        addBtn.setFont(myFont);
        addBtn.addActionListener(e -> addUpdateContact("Add", null));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(myFont);
        deleteBtn.addActionListener(e -> {
            if (list.getSelectedValue() == null){
                JOptionPane.showMessageDialog(null, "Select a contact!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                Contact contact = list.getSelectedValue();
                contactList.deleteContact(contact);
                listModel.clear();
                listModel.addAll(contactList.getContacts());
                JOptionPane.showMessageDialog(null, "The contact " + contact.getLastName() + " " + contact.getFirstName() + " was successfully deleted", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton updateBtn = new JButton("Update");
        updateBtn.setFont(myFont);
        updateBtn.addActionListener(e -> {
            if (list.getSelectedValue() == null){
                JOptionPane.showMessageDialog(null, "Select a contact!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                Contact contact = list.getSelectedValue();
                addUpdateContact("Update", contact);
            }
        });

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(addBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(deleteBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(updateBtn);
        buttonPanel.add(Box.createVerticalGlue());

        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(listPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);

        setContentPane(panel);
    }

    /**
     * Adds or updates a contact in the contact list.
     * @param title   The title of the dialog box (either "Add" or "Update").
     * @param contact The contact to update, or null if adding a new contact.
     */
    public void addUpdateContact(String title, Contact contact){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 250);

        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 10, 5, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel lastNameLbl = new JLabel("Last name:");
        lastNameLbl.setFont(myFont);
        formPanel.add(lastNameLbl, constraints);

        constraints.gridx = 1;
        JTextField lastNameField = new JTextField(15);
        lastNameField.setFont(myFont);
        formPanel.add(lastNameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel firstNameLbl = new JLabel("First name:");
        firstNameLbl.setFont(myFont);
        formPanel.add(firstNameLbl, constraints);

        constraints.gridx = 1;
        JTextField firstNameField = new JTextField(15);
        firstNameField.setFont(myFont);
        formPanel.add(firstNameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel phoneLbl = new JLabel("Phone number:");
        phoneLbl.setFont(myFont);
        formPanel.add(phoneLbl, constraints);

        constraints.gridx = 1;
        JTextField phoneField = new JTextField(15);
        phoneField.setFont(myFont);


        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));

        JButton addBtn = new JButton();

        if (title.equals("Add")){
            phoneField.setText("0040-736-386134");
            phoneField.setForeground(Color.GRAY);

            phoneField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (phoneField.getText().equals("0040-736-386134")){
                        phoneField.setText("");
                        phoneField.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (phoneField.getText().equals("")){
                        phoneField.setText("0040-736-386134");
                        phoneField.setForeground(Color.gray);
                    }
                }
            });

            addBtn.setText("Add");
            addBtn.addActionListener(e -> {
                if (lastNameField.getText().equals("") || firstNameField.getText().equals("") || (phoneField.getText().equals("") || phoneField.getForeground().equals(Color.gray))){
                    JOptionPane.showMessageDialog(null, "All fields are required", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    contactList.addContact(lastNameField.getText().trim(), firstNameField.getText().trim(), phoneField.getText().trim());
                    listModel.clear();
                    listModel.addAll(contactList.getContacts());
                    frame.dispose();
                }
            });
        } else if (title.equals("Update")) {
            lastNameField.setText(contact.getLastName());
            firstNameField.setText(contact.getFirstName());
            phoneField.setText(contact.getPhoneNumber());

            addBtn.setText("Update");
            addBtn.addActionListener(e -> {
                if (contactList.updateContact(contact.getCode(), lastNameField.getText().trim(), firstNameField.getText().trim(), phoneField.getText().trim())){
                    frame.dispose();
                    listModel.clear();
                    listModel.addAll(contactList.getContacts());
                    JOptionPane.showMessageDialog(null, "Contact no." + contact.getCode() + " was successfully updated!", "", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

        formPanel.add(phoneField, constraints);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> frame.dispose());

        btnPanel.add(Box.createHorizontalGlue());
        btnPanel.add(addBtn);
        btnPanel.add(cancelBtn);
        btnPanel.add(Box.createHorizontalGlue());

        btnPanel.setBorder(new EmptyBorder(20, 10, 20 ,10));

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * The main method that creates and displays the Test frame.
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Test test = new Test();
            test.setLocationRelativeTo(null);
            test.setResizable(false);
            test.setVisible(true);
        });
    }
}
