package Interfaces.SoftwareProducts;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A company sells software products and has divided the products into the following categories:
 * operating systems, utilities, games and programming languages.
 * Each product has a set price, but this month the company offers a 4% discount on all products.
 * Also, there was already a 30% discount on all operating systems,
 * and a 3% discount on all programming languages.
 * The program creates a SoftwareProduct table, calculates the new price of each product in the table
 * and displays the information about each product in ascending order according to the product code.
 * This class tests the functionality of the program.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<SoftwareProduct> products = new ArrayList<>();
        products.add(new OperatingSystem(1245, "WindowsNT", 5000));
        products.add(new ProgrammingLanguage(2134, "Pascal", 3500));
        products.add(new Utility(56890, "NortonCommander", 1200));
        products.add(new Game(789, "Mahjong", 23456));

        Collections.sort(products);

        for (SoftwareProduct product : products){
            product.getNewPrice();
            System.out.println(product + "\n");
        }
    }
}
