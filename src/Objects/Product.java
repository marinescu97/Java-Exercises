package Objects;

/**
 * This class represents a product object.
 */
public class Product {
    /**
     * The name of the product.
     */
    private final String name;
    /**
     * The price of the product.
     */
    private double price;

    /**
     * Creates a new product object.
     * @param name the name of the product
     * @param price the price of the product
     */
    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    /**
     * Displays the product.
     */
    public void displayProduct(){
        System.out.println(name + ": " + price);
    }

    /**
     * Gets the price of the product.
     * @return the price of the product
     */
    public double getPrice(){
        return price;
    }

    /**
     * Sets the price of the product.
     * @param val the price of the product
     */
    public void setPrice(double val){
        price = val;
    }

    /**
     * Applies a discount to the price of the product.
     * @param percent the percentage discount
     */
    public void applyDiscount(double percent){
        setPrice(getPrice() - (percent/100 * getPrice()));
    }
}
