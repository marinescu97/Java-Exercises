package Interfaces.SoftwareProducts;

/**
 * This class represents an operating system object.
 */
public class OperatingSystem extends SoftwareProduct {
    /**
     * Constructs a new operating system object.
     * @param code the code of the product
     * @param name the name of the product
     * @param price the price of the product
     */
    public OperatingSystem(int code, String name, double price) {
        super(code, name, price);
    }

    /**
     * This method applies a 4% discount, then another 30% discount is applied.
     */
    @Override
    public void getNewPrice() {
        setPrice(discountProducts(discountOperatingSystems(getPrice())));
    }
}
