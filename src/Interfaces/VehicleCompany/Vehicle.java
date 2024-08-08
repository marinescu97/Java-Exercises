package Interfaces.VehicleCompany;

/**
 * This class represents a vehicle object.
 */
public abstract class Vehicle implements TaxCalculation, Comparable<Vehicle>{
    /**
     * The price of the vehicle.
     */
    private final double price;
    /**
     * The vehicle information.
     */
    private final String manufacturer, country;

    /**
     * Constructs a new instance of the Vehicle.
     * @param price the price of the vehicle
     * @param manufacturer the manufacturer of the vehicle
     * @param country the country of the vehicle
     */
    public Vehicle(double price, String manufacturer, String country) {
        this.price = price;
        this.manufacturer = manufacturer;
        this.country = country;
    }

    /**
     * Gets the price of the vehicle.
     * @return the price of the vehicle
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the manufacturer of the vehicle.
     * @return the manufacturer of the vehicle
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets the country of the vehicle.
     * @return the country of the vehicle
     */
    public String getCountry() {
        return country;
    }

    /**
     * The method is taken from the {@link TaxCalculation} interface,
     * but will be overwritten in the class of each vehicle type.
     */
    @Override
    public abstract double calculateRoadTax();

    /**
     * This method, taken from the {@link TaxCalculation}, calculates the customs tax
     *  for the vehicles manufactured abroad.
     * @return the customs tax.
     */
    @Override
    public double calculateCustomsTax() {
        if (!getCountry().equals("Romania")){
            return 0.10d * getPrice();
        }
        return 0;
    }

    /**
     * This method, taken from the {@link TaxCalculation}, calculates the sum of taxes.
     * @return the total amount of taxes
     */
    @Override
    public double total() {
        return calculateTVA(getPrice()) + calculateRoadTax() + calculateCustomsTax();
    }

    /**
     * This method is taken from the {@link Comparable} interface.
     * Compares this vehicle object with another vehicle object based on their prices.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object's price
     *  is less than, equal to, or greater than the specified object's price.
     */
    @Override
    public int compareTo(Vehicle o) {
        return Double.compare(this.price, o.getPrice());
    }

    /**
     * Displays a vehicle object.
     * @return the way a vehicle is displayed
     */
    @Override
    public String toString() {
        return  " Type: " + this.getClass().getSimpleName().toLowerCase() +
                "\n Manufacturer: " + getManufacturer() +
                "\n Country: " + getCountry() +
                "\n Price: " + getPrice() +
                "\n Total amount: " + total();
    }
}
