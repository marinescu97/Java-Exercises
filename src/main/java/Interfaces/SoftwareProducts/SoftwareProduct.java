package Interfaces.SoftwareProducts;

/**
 * This class represents a software product.
 */
public abstract class SoftwareProduct implements DiscountCalculation, Comparable<SoftwareProduct> {
    /**
     * The code of the product.
     */
    private final int code;
    /**
     * The name of the product.
     */
    private final String name;
    /**
     * The price of the product.
     */
    private double price;

    /**
     * Constructs a new software product.
     * @param code the code of the product
     * @param name the name of the product
     * @param price the price of the product
     */
    public SoftwareProduct(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the code of the product.
     * @return the code of the product
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the name of the product.
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price the price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculates the new price of the product.
     */
    public abstract void getNewPrice();

    /**
     * Compares this product with a given one by their code.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object's code
     *         is less than, equal to, or greater than the specified object's code.
     */
    @Override
    public int compareTo(SoftwareProduct o) {
        return Integer.compare(this.getCode(), o.getCode());
    }

    /**
     * Displays a SoftwareProduct object.
     * @return The way an object is displayed.
     */
    @Override
    public String toString() {
        return  " Code: " + getCode() +
                "\n Name: " + getName() +
                "\n Price: " + getPrice();
    }
}
