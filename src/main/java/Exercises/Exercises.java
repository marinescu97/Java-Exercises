package Exercises;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Exercises {
    /**
     * The method takes an initial word and extracts any words that start with the same letters as the initial word.
     */
    public static String[] dictionary(String s, String[] w) {
        if (s != null && w != null) {
            String regex = "^("+s+").*";
            Pattern pattern = Pattern.compile(regex);
            ArrayList<String> words = new ArrayList<>();
            for (String word : w) {
                if (pattern.matcher(word).matches()) {
                    words.add(word);
                }
            }
            return words.toArray(new String[0]);
        }
        return null;
    }

    /**
     * The method takes an integer and returns “odd”
     * if the sum of all odd digits is greater than the sum of all even digits.
     * Return “even” if the sum of all even digits is greater than the sum of all odd digits,
     * and “equal” if both sums are the same.
     */
    public static String oddsVsEvens(int num) {
        if (num > 9){
            int sumOdd = 0;
            int sumEven = 0;
            int digit;

            while (num > 0){
                digit = num % 10;
                if (digit%2==0){
                    sumEven+=digit;
                } else {
                    sumOdd+=digit;
                }
                num /= 10;
            }

            if (sumOdd > sumEven){
                return "odd";
            } else if (sumEven > sumOdd){
                return "even";
            }

            return "equal";
        }
        return "The number should be greater than 9.";
    }

    /**
     * A number is said to be Harshad if it is exactly divisible by the sum of its digits.
     * This method determines whether a number is a Harshad or not.
     */
    public static boolean isHarshad(int n) {
        if (n > 0){
            int sum = 0;
            int temp = n;
            while (temp > 0) {
                sum += temp%10;
                temp /= 10;
            }

            return n % sum == 0;
        }
        return false;
    }
}
