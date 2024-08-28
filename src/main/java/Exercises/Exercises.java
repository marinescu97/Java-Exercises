package Exercises;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Exercises {
    /**
     * The method takes an initial word and extracts any words that start with the same letters as the initial word.
     */
    public static String[] dictionary(String s, String[] w) {
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

    /**
     * The method takes an integer and returns “odd”
     * if the sum of all odd digits is greater than the sum of all even digits.
     * Return “even” if the sum of all even digits is greater than the sum of all odd digits,
     * and “equal” if both sums are the same.
     */
    public static String oddsVsEvens(int num) {
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

    /**
     * A number is said to be Harshad if it is exactly divisible by the sum of its digits.
     * This method determines whether a number is a Harshad or not.
     */
    public static boolean isHarshad(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            sum += temp%10;
            temp /= 10;
        }

        return n % sum == 0;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(dictionary("bu", new String[]{"button", "breakfast", "border"})));
//        System.out.println(Arrays.toString(dictionary("tri", new String[]{"triplet", "tries", "trip", "piano", "tree"})));
//        System.out.println(Arrays.toString(dictionary("beau", new String[]{"pastry", "delicious", "name", "boring"})));

//        System.out.println(oddsVsEvens(97428));
//        System.out.println(oddsVsEvens(81961));
//        System.out.println(oddsVsEvens(54870));

//        System.out.println(isHarshad(75));
//        System.out.println(isHarshad(171));
//        System.out.println(isHarshad(481));
//        System.out.println(isHarshad(89));
//        System.out.println(isHarshad(516));
//        System.out.println(isHarshad(200));
    }
}
