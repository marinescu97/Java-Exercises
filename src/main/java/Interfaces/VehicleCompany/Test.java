package Interfaces.VehicleCompany;
import java.util.Arrays;

/**
 * A company sells large vehicles: trucks, buses and minibuses,
 *  produced in the country or abroad.
 *
 * The program creates 3 vehicles, one from each category and displays data such as:
 *  type of vehicle, manufacturer, country of origin, price and amount owed to the state.
 *
 * To calculate the total amount owed to the Romanian state, they must be calculated the following taxes:
 * a) TVA: 19% of the price of the vehicle;
 * b) Road tax: 3% for minibuses, 4% for buses and 5% for trucks;
 * c) 10% customs duties for vehicles produced abroad.
 */
public class Test {
    public static void main(String[] args) {
        Vehicle truck = new Truck(30000, "Volkswagen", "Romania");

        Vehicle bus = new Bus(60000, "Mercedes", "Turkey");

        Vehicle minibus = new Minibus(40000, "Toyota", "Romania");

        Vehicle[] arr = {truck, bus, minibus};
        Arrays.sort(arr);

        for (Vehicle vehicle : arr){
            System.out.println(vehicle.toString());
            System.out.println();
        }
    }
}