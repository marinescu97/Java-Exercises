package Interfaces.SoftwareProducts;

/**
 * The interface offers methods for applying discounts to products in the store.
 */
public interface DiscountCalculation {
    /**
     * This method applies a 4% discount for all products.
     * @param price The price of the product.
     * @return The price of the product after applying the discount.
     */
    default double discountProducts(double price){
        return price - 0.04 * price;
    }

    /**
     * The method applies a 30% discount from the price of operating systems.
     * @param price The price of the product.
     * @return The price of the product after applying the discount.
     */
    default double discountOperatingSystems(double price){
        return price - 0.3 * price;
    }

    /**
     * The method applies a 3% discount from the price of programming languages.
     * @param price The price of the product.
     * @return The price of the product after applying the discount.
     */
    default double discountProgrammingLanguages(double price){
        return price - 0.03 * price;
    }
}
