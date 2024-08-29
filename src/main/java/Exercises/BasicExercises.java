package Exercises;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

/**
 * This class contains a set of basic exercises in java.
 */
public class BasicExercises {
    public BasicExercises() {
    }

    /**
     * A {@link Scanner} object used for text input.
     */
    static Scanner scanner = new Scanner(System.in);

    /**
     * Calculates the value of the mathematical function f(x), for a real value of x:
     *                    x*x+1, for x <=-3
     *     f:R->R, f(x) = x – 2, for -3<x<3
     *                    x*x - 4*x + 5, for x>=3
     * @param x The real value of the function.
     * @return The value of the mathematical function.
     */
    private int func(int x){
        if (x<=-3){
            return (x*x)+1;
        } else if (x>=3) {
            return (x*x) - (4*x) + 5;
        } else {
            return x - 2;
        }
    }

    /**
     * Checks if an integer is perfect or not (is equal to the sum of its divisors)
     * @param x The integer to be checked.
     * @return True is the integer is perfect, otherwise false.
     */
    public static boolean isPerfect(int x){
        int sum = 0;
        for (int i=1; i<x; i++){
            if (x % i == 0){
                sum += i;
            }
        }
        return sum == x;
    }

    /**
     * Checks if an integer is a palindrome (is equal to its reversed).
     * @param x The integer to be checked.
     * @return True is the integer is a palindrome, otherwise false.
     */
    public boolean isPalindrome(int x){
        int reversed = 0;
        int temp = x;
        while (temp>0){
            reversed = reversed*10 + temp%10;
            temp/=10;
        }
        return reversed == x;
    }

    /**
     * Calculates and displays the sum of integers in the range [1,15].
     * @return The sum of integers.
     */
    public int sum(){
        int sum = 0;
        for (int i=1; i<=15; i++){
            sum+=i;
        }
        return sum;
    }

    /**
     * Calculates and displays the product of even integers in the range [1,20]
     * @return The product.
     */
    public long product(){
        long prod = 1;
        for (int i=1; i<=20; i++){
            if (i%2==0){
                prod *= i;
            }
        }
        return prod;
    }

    public long product1(){
        long prod = 1;
        for (int i=2; i<=20; i+=2){
            prod *= i;
        }
        return prod;
    }

    public long product2(){
        long prod = 1;
        int x = 20;
        while (x>0){
            prod *= x;
            x -= 2;
        }
        return prod;
    }

    /**
     * Translates the numbers from 1 to 12 into the names of the corresponding months: January, February, …, December.
     * @param x The number of the month.
     * @return The name of the corresponding month.
     */
    public String month(int x){
        return switch (x) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Enter a number between 1 and 12 inclusive";
        };
    }

    /**
     * Returns the temperature in degrees Celsius equivalent to the temperature in degrees Fahrenheit.
     * @param fahrenheit The temperature in degrees Fahrenheit.
     * @return The temperature in degrees Celsius.
     */
    public double convertToCelsius(double fahrenheit){
        return Math.round(((fahrenheit - 32) * 5/9) * 100.00) / 100.00;
    }

    /**
     * Returns the temperature in degrees Fahrenheit equivalent to the temperature in degrees Celsius.
     * @param celsius The temperature in degrees Celsius.
     * @return The temperature in degrees Fahrenheit.
     */
    public double convertToFahrenheit(double celsius){
        return Math.round(((celsius * 9/5) + 32) * 100.00) / 100.00;
    }

    /**
     * Stores two integers read from the keyboard and returns the sum, difference, product, maximum and minimum between the numbers.
     */
    public void calc(int a, int b){
//        System.out.print("a = ");
//        int a = scanner.nextInt();
//        System.out.print("b = ");
//        int b = scanner.nextInt();

        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product: " + (a * b));
        System.out.println("Maximum: " + Math.max(a, b));
        System.out.println("Minimum: " + Math.min(a, b));

    }

    /**
     * Displays a square filled with the symbol "*" whose side is specified as a method parameter.
     * @param l The square's side.
     */
    public void displaySquare(int l){
        if (l > 0){
            for (int i=0; i<l; i++){
                for (int j=0; j<l; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        } else {
            System.out.println("The length should be greater than 0.");
        }
    }

    /**
     * Calculates the factorial of a given number.
     * @param n The given number.
     * @return The factorial.
     */
    public BigDecimal factorial(int n){
        if (n >= 0){
            BigDecimal result = BigDecimal.ONE;
            for (int i=1; i<=n; i++){
                result = result.multiply(BigDecimal.valueOf(i));
            }
            if (n <= 14){
                return result;
            }
            return result.round(new MathContext(10)).stripTrailingZeros();
        }

        System.out.println("The number must be >= 0");
        return null;
    }

    /**
     * This method calculates the number of divisors of a given number.
     * @param x The given number.
     * @return The number of divisors.
     */
    public static int divisorsNumber(int x){
        if (x > 0){
            int number = 0;
            for (int i=1; i<=x; i++){
                if (x % i == 0){
                    number++;
                }
            }
            return number;
        }
        return 0;
    }

    /**
     * Returns an integer in the range [1.10000] that has the highest number of divisors.
     * @return The integer.
     */
    public int highestNumberOfDivisors(){
        int divNumber = divisorsNumber(1);
        int theHighestNumber = 1;
        for (int i=1; i<=10000; i++){
            if (divisorsNumber(i) > divNumber){
                divNumber = divisorsNumber(i);
                theHighestNumber = i;
            }
        }
        return theHighestNumber;
    }

    /**
     * Displays:
     *             *
     *             **
     *             ***
     *             ****
     *             *****
     *             ******
     *             *******
     *             ********
     *             *********
     *             **********
     */
    public void star(){
        for (int i=0; i<=10; i++){
            for (int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Displays the number of occurrences of a character in a string.
     * @param text The given string.
     * @param c The character.
     * @return The number of occurrences of the character in the string.
     */
    public int countChars(String text, char c){
        int count = 0;
        for (int i=0; i<text.length(); i++){
            if (text.charAt(i) == c){
                count++;
            }
        }
        return count;
    }

    /**
     * Display the initials “M A” with the character "*".
     */
    public void showInitials(){
        for (int i=0; i<9; i++){
            for (int j=0; j<20; j++){
                if ((i==0 && (j==0 || j==8 || j==15)) || (i==1 && (j==0 || j==1 || j==7 || j==8))
                        || (i==2 && (j==0 || j==2 || j==6 || j==8 || j==14 || j==16)) || (i==3 && (j==0 || j==8 || j==3 || j==4))
                        || (i==4 && (j==0 || j==8 || j==13 || j==14 || j==15 || j==16 || j==17)) || (i==5 && (j==0 || j==8)) || (i==6 && (j==0 || j==8 || j==12 || j==18)) || (i==7 && (j==0 || j==8)) || (i==8 && (j==0 || j==8 || j==11 || j==19)))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
