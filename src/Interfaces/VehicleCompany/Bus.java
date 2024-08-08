package Interfaces.VehicleCompany;

/**
 * This class represents a bus object.
 * It extends the {@link Vehicle} interface, being a type of vehicle.
 */
public class Bus extends Vehicle {
    /**
     * Constructs a new bus object.
     * @param price the price of the bus
     * @param manufacturer the manufacturer of the bus
     * @param country the country of the bus
     */
    public Bus(double price, String manufacturer, String country) {
        super(price, manufacturer, country);
    }

    /**
     * This method overrides the method from the {@link Vehicle} interface.
     * It calculates the road tax.
     * @return the road tax
     */
    @Override
    public double calculateRoadTax() {
        return 0.04d * getPrice();
    }


}
