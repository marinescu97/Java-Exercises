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
    public void display(){
        for (int j : this.calc) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.printf("Number of elements: %d\nThe sum: %d\nThe mean: %d\nThe minimum: %d\nThe maximum: %d\nThe standard deviation: %.2f",
                            getCount(), getSum(), getMean(), getMin(), getMax(), getStandardDeviation());
    }

    /**
     * Gets the number of integers.
     * @return The number of integers.
     */
    public int getCount(){
        return calc.length;
    }

    /**
     * Gets the sum of integers.
     * @return The sum.
     */
    public int getSum(){
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
    public int getMean(){
        return this.getSum()/ calc.length;
    }

    /**
     * Gets the minimum between numbers.
     * @return The minimum.
     */
    public int getMin(){
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
    public int getMax(){
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
        int sd = 0;
        for (int j : calc) {
            sd += Math.pow(j - this.getMean(), 2);
        }
        return Math.sqrt(sd/ calc.length);
    }
}

/**
 * The class tests the functionality of the {@link StatCalc} class.
 */
class Test {
    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc(new int[]{69, 27, 10});
        statCalc.display();
    }
}
