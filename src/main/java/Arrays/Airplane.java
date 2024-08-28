package Arrays;

import java.util.Scanner;

/**
 * The class with which seats on an airplane are automatically reserved.
 */
public class Airplane {
    /**
     * A {@link Scanner} object used for text input.
     */
    Scanner scn = new Scanner(System.in);

    /**
     * An array of integers that represent the airplane's seats.
     */
    private final int[] seats;

    /**
     * The number of seats for people who smoke and for people who don't smoke.
     */
    private int smokingSeats, nonSmokingSeats;

    /**
     * The constructor of the class.
     * Creates an object instance with a capacity of 10 seats.
     */
    Airplane(){
        this.seats = new int[10];
        smokingSeats = 5;
        nonSmokingSeats = 5;
    }

    /**
     * Gets the number of available seats for people who smoke.
     * @return The number of seats.
     */
    public int getSmokingSeats() {
        return smokingSeats;
    }

    /**
     * Sets the number of available seats for people who smoke.
     * @param smokingSeats The new number of seats.
     */
    public void setSmokingSeats(int smokingSeats) {
        this.smokingSeats = smokingSeats;
    }

    /**
     * Gets the number of available seats for people who don't smoke.
     * @return The number of seats.
     */
    public int getNonSmokingSeats() {
        return nonSmokingSeats;
    }

    /**
     * Sets the number of available seats for people who don't smoke.
     * @param nonSmokingSeats The new number of seats.
     */
    public void setNonSmokingSeats(int nonSmokingSeats) {
        this.nonSmokingSeats = nonSmokingSeats;
    }

    /**
     * This method reserves a seat in the smoking section.
     * It checks the seat availability.
     * If there are no free seats, a message appears through which you can opt for reserving a seat in another section.
     * If the next section has available seats, a seat is reserved, otherwise a message is displayed.
     */
    private void smokingSeatReservation(){
        if (getSmokingSeats()==0){
            if (getNonSmokingSeats()==0){
                System.out.println("The next flight is in 3 hours");
            } else {
                System.out.println("Do you want to reserve a seat in the non-smoking section? y/n");
                char choice = scn.next().charAt(0);
                if (choice == 'y'){
                    if (getNonSmokingSeats()==0){
                        System.out.println("The next flight is in 3 hours");
                    } else {
                        nonSmokingSeatReservation();
                    }
                } else {
                    System.out.println("The next flight is in 3 hours");
                }
            }
        } else {
            for (int i=0; i<5; i++){
                if (seats[i] == 0){
                    seats[i] = 1;
                    int seat = i+1;
                    setSmokingSeats(getSmokingSeats()-1);
                    System.out.println("Place no." + seat + " in the smoking section has been reserved!");
                    break;
                }
            }
        }
    }

    /**
     * This method reserves a seat in the non-smoking section.
     */
    private void nonSmokingSeatReservation(){
        if (getNonSmokingSeats()==0){
            if (getSmokingSeats()==0){
                System.out.println("The next flight is in 3 hours.");
            } else {
                System.out.println("Do you want to reserve a seat in the smoking section? y/n");
                char choice = scn.next().charAt(0);
                if (choice == 'y'){
                    if (getSmokingSeats()==0){
                        System.out.println("The next flight is in 3 hours.");
                    } else {
                        smokingSeatReservation();
                    }
                } else {
                    System.out.println("The next flight is in 3 hours.");
                }
            }
        } else {
            for (int i=5; i<10; i++){
                if (seats[i] == 0){
                    seats[i] = 1;
                    int seat = i+1;
                    setNonSmokingSeats(getNonSmokingSeats()-1);
                    System.out.println("Place no." + seat + " in the non-smoking section has been reserved!");
                    break;
                }
            }
        }
    }

    /**
     * Displays the menu for which one opts for reserving a seat in a certain section.
     */
    public void reservation(){
        boolean flag = true;
        while (flag){
            System.out.println("""
                    Choose 1 for the Smoking section\s
                    Choose 2 for the Non-Smoking section\s
                    Choose 3 to end the program
                    """);
            System.out.print("Choice: ");
            int nr = scn.nextInt();

            switch (nr) {
                case 1 -> smokingSeatReservation();
                case 2 -> nonSmokingSeatReservation();
                case 3 -> flag = false;
            }
        }
    }
}

/**
 * The class tests the functionality of the {@link Airplane} class.
 */
class TestAirplane {
    public static void main(String[] args) {
        Airplane a1 = new Airplane();
        a1.reservation();
    }
}
