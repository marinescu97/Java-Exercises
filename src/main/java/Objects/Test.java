package Objects;

import java.util.Scanner;

/**
 * This class tests the functionality of another classes.
 */
public class Test {
    /**
     * A {@link Scanner} object used for text input.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Tests the functionality of the {@link Circle} class.
     * It creates a new circle and displays its area and circumference.
     */
    private static void displayCircle(){
        System.out.print("Enter the radius: ");
        Circle c1 = new Circle(scanner.nextInt());

        System.out.println("Area: " + c1.getArea());
        System.out.println("Circumference: " + c1.getCircumference());
    }

    /**
     * Tests the functionality of the {@link Product} class.
     * It creates a product and applies a discount to it.
     */
    private static void displayProduct(){
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the product price: ");
        double price = scanner.nextDouble();

        Product p1 = new Product(name, price);

        p1.displayProduct();

        System.out.print("Apply discount: ");
        double percent = scanner.nextDouble();

        p1.applyDiscount(percent);

        System.out.println("The new price:");
        p1.displayProduct();
    }

    /**
     * Tests the functionality of the {@link BankAccount} class.
     * It creates a new account and performs displaying, depositing and withdrawing operations.
     */
    private static void displayAccount(){
        BankAccount c1 = new BankAccount();

        boolean flag = true;

        while (flag){
            System.out.println("0 - display account\n1 - deposit\n2 - withdrawal\n3 - exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> c1.displayAccount();
                case 1 -> c1.deposit();
                case 2 -> c1.withdraw();
                case 3 -> flag = false;
                default -> System.out.println("Enter a number from the menu!");
            }
        }
    }

    /**
     * Tests the functionality of the {@link Complex} class.
     * It creates two complex numbers and performs operations on them.
     */
    private static void displayComplex(){
        Complex c1 = new Complex();
        Complex c2 = new Complex(4,5);

        System.out.println("C1 = " + c1);
        System.out.println("C2 = " + c2);

        Complex addition = c1.sum(c2);
        Complex subtraction = c1.subtraction(c2);

        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
    }

    /**
     * It tests the functionality of the {@link  Rational} class.
     * Creates two rational numbers and performs operations on them.
     */
    private static void displayRational(){
        Rational r1 = new Rational(3,5);
        r1.display();

        Rational r2 = new Rational(7,9);
        r2.display();

        Rational addition = r1.addition(r2);

        System.out.print("Addition: ");
        addition.display();

        Rational subtraction = r1.subtraction(r2);
        System.out.print("Subtraction: ");
        subtraction.display();

        Rational multiplication = r1.multiplication(r2);
        System.out.print("Multiplication: ");
        multiplication.display();

        Rational division = r1.division(r2);
        System.out.print("Division: ");
        division.display();
    }

    /**
     * Tests the functionality of the {@link Receipt} class.
     * It creates two receipt and displays them.
     * You can see the automatic increase of the receipt number when creating a new object.
     */
    private static void displayReceipt(){
        Receipt r1 = new Receipt("S.C. Info S.R.L.", 1, 1300, "16");
        System.out.println(r1);
        Receipt r2 = new Receipt("SC Program SRL", 245, 245.6,"30");
        System.out.println(r2);

    }

    public static void main(String[] args) {

    }

}
