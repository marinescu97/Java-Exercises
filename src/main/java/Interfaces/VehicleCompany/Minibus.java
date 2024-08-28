package Interfaces.VehicleCompany;

/**
 * This class represents a minibus object.
 * It extends the {@link Vehicle} interface, being a type of vehicle.
 */
public class Minibus extends Vehicle {
    /**
     * Constructs a new minibus object.
     * @param price the price of the minibus
     * @param manufacturer the manufacturer of the minibus
     * @param country the country of the minibus
     */
    public Minibus(double price, String manufacturer, String country) {
        super(price, manufacturer, country);
    }

    /**
     * This method overrides the method from the {@link Vehicle} interface.
     * It calculates the road tax.
     * @return the road tax
     */
    @Override
    public double calculateRoadTax() {
        return 0.03d * getPrice();
    }
}
