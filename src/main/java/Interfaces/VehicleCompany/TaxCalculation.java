package Interfaces.VehicleCompany;

/**
 * The interface contains methods for calculating taxes for a vehicle.
 */
public interface TaxCalculation {
    /**
     * This method calculates the TVA.
     * @param price the price of the vehicle
     * @return the TVA
     */
    default double calculateTVA(double price){
        return 0.19d * price;
    }

    /**
     * This method calculates the road tax for a vehicle.
     * @return the road tax
     */
    double calculateRoadTax();

    /**
     * This method calculates the customs tax for a vehicle.
     * @return the customs tax
     */
    double calculateCustomsTax();

    /**
     * Calculates the total tax for a vehicle.
     * @return the total tax
     */
    double total();
}
