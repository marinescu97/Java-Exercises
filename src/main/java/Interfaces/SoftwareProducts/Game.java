package Interfaces.SoftwareProducts;

/**
 * This class represents a game.
 */
public class Game extends SoftwareProduct {
    /**
     * Constructs a new instance of this class.
     * @param code the code of the product
     * @param name the name of the product
     * @param price the price of the product
     */
    public Game(int code, String name, double price) {
        super(code, name, price);
    }

    /**
     * This method applies a 4% discount.
     */
    @Override
    public void getNewPrice() {
        setPrice(discountProducts(getPrice()));
    }
}
