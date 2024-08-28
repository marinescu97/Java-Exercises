package Interfaces.VehicleCompany;

/**
 * This class represents a truck object.
 * It extends the {@link Vehicle} interface, being a type of vehicle.
 */
public class Truck extends Vehicle {
    /**
     * Constructs a new truck object.
     * @param price the price of the truck
     * @param manufacturer the manufacturer of the truck
     * @param country the country of the truck
     */
    public Truck(double price, String manufacturer, String country) {
        super(price, manufacturer, country);
    }

    /**
     * This method overrides the method from the {@link Vehicle} interface.
     * It calculates the road tax.
     * @return the road tax
     */
    @Override
    public double calculateRoadTax() {
        return 0.05d * getPrice();
    }
}
