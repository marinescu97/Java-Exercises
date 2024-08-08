package Interfaces.SoftwareProducts;

/**
 * This class represents a programming language product.
 */
public class ProgrammingLanguage extends SoftwareProduct {
    /**
     * Constructs a new programming language product.
     * @param code the code of the product
     * @param name the name of the product
     * @param price the price of the product
     */
    public ProgrammingLanguage(int code, String name, double price) {
        super(code, name, price);
    }

    /**
     * The method applies a 4% discount, then a 3% discount is applied.
     */
    @Override
    public void getNewPrice() {
        setPrice(discountProducts(discountProgrammingLanguages(getPrice())));
    }
}
