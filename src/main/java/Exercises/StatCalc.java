package Exercises;

/**
 * The class takes a data set and calculates the number of elements, sum of elements, mean, minimum, maximum and standard deviation.
 */
public class StatCalc {
    /**
     * An array of integers.
     */
    private final int[] calc;

    /**
     * The constructor of the class.
     * Creates an instance of the object.
     * @param calc An array of integers.
     */
    public StatCalc(int[] calc) {
        this.calc = calc;
    }

    /**
     * Displays the information of the array of integers.
     */
    private void display(){
        for (int j : this.calc) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.printf("Number of elements: %d\nThe sum: %d\nThe mean: %.2f\nThe minimum: %d\nThe maximum: %d\nThe standard deviation: %.2f",
                            getCount(), getSum(), getMean(), getMin(), getMax(), getStandardDeviation());
    }

    /**
     * Gets the number of integers.
     * @return The number of integers.
     */
    private int getCount(){
        return calc.length;
    }

    /**
     * Gets the sum of integers.
     * @return The sum.
     */
    private int getSum(){
        int s = 0;
        for (int j : calc) {
            s += j;
        }
        return s;
    }

    /**
     * Gets the mean of the numbers.
     * @return The mean.
     */
    private double getMean(){
        double mean = this.getSum() / this.getCount();

        return Math.round(mean * 100.0) / 100.0;
    }

    /**
     * Gets the minimum between numbers.
     * @return The minimum.
     */
    private int getMin(){
        int min = calc[0];
        for (int j : calc) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    /**
     * Gets the maximum between numbers.
     * @return The maximum.
     */
    private int getMax(){
        int max = calc[0];
        for (int j : calc) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    /**
     * Gets the standard deviation of the numbers.
     * @return The standard deviation.
     */
    public double getStandardDeviation(){
        double standardDeviation = 0.0;
        for (double num : calc) {
            standardDeviation += Math.pow(num - getMean(), 2);
        }
        double result = Math.sqrt(standardDeviation / getCount());
        return Math.round(result * 100.0) / 100.0;
    }

    public static void calculator(int[] elements){
        StatCalc statCalc = new StatCalc(elements);
        statCalc.display();
    }
}
