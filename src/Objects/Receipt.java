package Objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a receipt.
 */
public class Receipt {
    /**
     * The number of receipt.
     */
    private static int receiptNumber = 0;
    /**
     * The customer name.
     */
    private final String customer;
    /**
     * The customer id.
     */
    private final int customerId;
    /**
     * The paid amount.
     */
    private final double amount;
    /**
     * The invoice number.
     */
    private final String invoiceNumber;

    /**
     * Constructs a new instance of the receipt.
     * @param customer The customer
     * @param customerId The customer id
     * @param amount The paid amount
     * @param invoiceNumber The invoice number
     */
    public Receipt(String customer, int customerId, double amount, String invoiceNumber) {
        this.customer = customer;
        this.customerId = customerId;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        receiptNumber++;
    }

    /**
     * Gets the seller.
     * @return the seller
     */
    public String getSeller() {
        return "Java SRL";
    }

    /**
     * Gets the receipt number.
     * @return the receipt number
     */
    public static int getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * Gets the customer name.
     * @return the customer name
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Gets the customer id.
     * @return the customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Gets the amount.
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the invoice number.
     * @return the invoice number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Gets the current date.
     * @return the current date
     */
    public String getCurrentDate() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy MM:ss").format(LocalDateTime.now());
    }

    /**
     * Prints the receipt.
     * @return a string representation of the receipt
     */
    @Override
    public String toString() {
        return "Seller: " + getSeller() + "\n\t\t\t\t" +
                "Receipt no." + getReceiptNumber() + "\n\t\t\t   " +
                getCurrentDate() + "\n" +
                "I received from " + getCustomer() + ", code " + getCustomerId() + ", the amount of " + getAmount() + ", representing the counter value of the invoice: " + getInvoiceNumber() + "\n";
    }
}
