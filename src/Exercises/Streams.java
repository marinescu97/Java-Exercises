package Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    /**
     * Given a list of integers, this method filters out all the even numbers.
     */
    private static void filterEvenNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Initial list: " + numbers);

        System.out.print("Filtered list: ");

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));
    }

    /**
     * Given a list of strings, it converts all the strings to uppercase.
     */

    private static void toUppercase(){
        List<String> words = Arrays.asList("hello", "world", "java", "streams");
        System.out.println("Initial list: " + words);

        System.out.print("Words to uppercase: ");

        words.stream()
                .map(String::toUpperCase)
                .forEach(word -> System.out.print(word + " "));
    }

    /**
     * Given a list of integers, the method calculates the sum of all odd numbers.
     */

    private static void sumOfNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("The list of the numbers: " + numbers);

        int sum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, (a, b) -> a + b);

        System.out.print("The sum of the odd numbers: " + sum);
    }

    /**
     * Given a list of strings, it finds the first string that starts with the specified letter.
     */

    private static void startsWithLetter(String letter){
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "javascript");
        System.out.println("The list: " + words);

        System.out.print("The words that starts with the letter " + letter + ": ");

        words.stream()
                .filter(word -> word.startsWith(letter))
                .findFirst()
                .orElse("Not found");
    }

    /**
     * Given a list of strings, it groups the strings by their lengths.
     */
    private static void groupingByLength(){
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "javascript");
        System.out.println("The list: " + words);

        System.out.println("Result: ");

        words.stream()
                .collect(Collectors.groupingBy(String::length))
                .forEach((word, length) -> System.out.println(word + ": " + length));
    }

    /**
     * Given a list of integers, it sorts the numbers in descending order.
     */

    private static void sortDescending(){
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6);
        System.out.println("The list of the numbers: " + numbers);

        System.out.print("The sorted list: ");

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(n -> System.out.print(n + ", "));
    }

    /**
     * Given a list of integers, it finds the maximum number.
     */

    private static void findMax(){
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6);
        System.out.println("The list of the numbers: " + numbers);

        var max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();

        System.out.println("The maximum element of the list is " + max);
    }

    /**
     * Given a list of integers, it checks if all the numbers are greater than a given number.
     */

    private static void ifGreaterThan(int number){
        List<Integer> numbers = Arrays.asList(6, 7, 8, 9, 10);
        System.out.println("The list of the numbers: " + numbers);

        System.out.print("Result: ");

        numbers.stream()
                .map(n -> n > number)
                .forEach(n -> System.out.print(n + " "));
    }

    /**
     * Given a list of strings, it finds the top 3 longest strings.
     */

    private static void findTop3Strings(){
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "javascript", "programming", "software", "development");
        System.out.println("The list: " + words);

        System.out.println("Top 3 longest strings: ");

        words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}
