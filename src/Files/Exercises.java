package Files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Contains basic exercises with working with files.
 */
public class Exercises {
    /**
     * A {@link Scanner} object used for text input.
     */
    static Scanner s = new Scanner(System.in);

    /**
     * Prints into a file the prime numbers from a given range.
     * @param x the start point of the range
     * @param y the end point of the range
     * @param fileName the name of the file
     * @throws Exception if an error occurs while writing the file
     */
    static void printPrimeNumbers(int x, int y, String fileName) throws Exception {
        if (x < y){
            try {
                BufferedWriter in = new BufferedWriter(new FileWriter(fileName));

                for (int i = x; i<=y; i++){
                    if (isPrime(i)){
                        in.write(Integer.toString(i));
                        in.newLine();
                    }
                }
                in.close();
                System.out.println("Successfully wrote numbers to the file.");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            throw new Exception("The first number should be less than the second number");
        }
    }

    /**
     * This is a helper method for {@link #printPrimeNumbers(int, int, String) printPrimeNumbers} method.
     * It checks if a number is prime or not.
     * @param number the number to be checked
     * @return true if the number is prime, false otherwise.
     */
    private static boolean isPrime(int number){
        int count = 0;

        for (int i = 1; i<=number; i++){
            if (number%i==0){
                count++;
            }
        }

        return count == 2;
    }

    /**
     * Checks if two strings are lexicographically equal and prints the result to a file.
     * If they are not equal it will print the smallest string.
     * Two strings are lexicographically equal if they are the same length and
     * contain the same characters in the same positions.
     * @param str1 the first string
     * @param str2 the second string
     * @param fileName the name of the destination file
     */
    static void areLexicographicallyEqual(String str1, String str2, String fileName){
        try {
            int result = str1.compareTo(str2);
            BufferedWriter in = new BufferedWriter(new FileWriter(fileName));
            if (result == 0){
                in.write("The two strings are lexicographically equal.");
            } else if (result < 0) {
                in.write("The smaller lexicographic string is: " + str1);
            } else {
                in.write("The smaller lexicographic string is: " + str2);
            }

            in.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Reads from the keyboard a set of positive integers until the number 0 is entered.
     * These numbers are stored in an array, they are ordered in descending order,
     * then they are written in the "numbers.txt" file
     */
    static void printArray(){
        List<Integer> numbers = new ArrayList<>();
        boolean flag = true;
        int number;

        System.out.println("Enter the numbers: ");
        while (flag){
            number = s.nextInt();

            if (number == 0){
                flag = false;
            } else if (number < 0) {
                System.out.println("Enter a positive number!");
            } else {
                numbers.add(number);
            }
        }

        numbers.sort(Collections.reverseOrder());

        try {
            BufferedWriter in = new BufferedWriter(new FileWriter("numbers.txt"));

            for (int n : numbers){
                in.write(n + " ");
            }
            in.close();
            System.out.println("The numbers were written in the file!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
//        printPrimeNumbers(1, 50, "primeNumbers.txt");
//        areLexicographicallyEqual("abcd", "abc", "result.txt");
//        printArray();
    }
}
