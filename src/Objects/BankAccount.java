package Objects;

import java.util.Scanner;

/**
 * This class represents a bank account object.
 */
public class BankAccount {
    /**
     * A {@link Scanner} object used for text input.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * The account number.
     */
    private final String accountNumber;
    /**
     * The account balance.
     */
    private double balance;

    /**
     * Constructs a new instance of a bank account.
     * @param accountNumber The account number.
     * @param balance The account balance.
     */
    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Constructs a new instance of a bank account with default values.
     */
    BankAccount(){
        this("1", 475.85);
    }

    /**
     * Sets the account balance.
     * @param balance the account balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Displays the account.
     */
    public void displayAccount(){
        System.out.println("Account number: " + accountNumber + "\nBalance: " + balance);
    }

    /**
     * Adds an amount to the account balance.
     */
    public void deposit(){
        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();
        setBalance(balance+=amount);
        System.out.println("The amount has been added successfully!");
        displayAccount();
    }

    /**
     * Withdraws an amount from the account.
     */
    public void withdraw(){
        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();
            if (amount<=balance){
                setBalance(balance-=amount);
                System.out.println("The amount has been withdrawn successfully!");
                displayAccount();
            } else {
                if (balance<1){
                    System.out.println("Insufficient funds!");
                } else {
                    System.out.println("Insufficient funds! Withdraw a smaller amount");
                    withdraw();
                }
            }
    }
}
