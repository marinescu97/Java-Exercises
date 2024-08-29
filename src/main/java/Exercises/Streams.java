package Exercises;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    /**
     * Given a list of integers, this method filters out all the even numbers.
     * @param list The given list.
     */
    public static void filterEvenNumbers(List<Integer> list){
        if (list != null){
            System.out.println("Initial list: " + list);

            System.out.print("Filtered list: ");

            list.stream()
                    .filter(number -> number % 2 == 0)
                    .forEach(number -> System.out.print(number + " "));
        } else {
            System.out.print("Please provide non null values!");
        }
    }

    /**
     * Given a list of strings, it converts all the strings to uppercase.
     * @param words The given list.
     */
    public static void toUpperCase(List<String> words){
        if (words != null){
            System.out.println("Initial list: " + words);

            System.out.print("Words to uppercase: ");

            words.stream()
                    .map(String::toUpperCase)
                    .forEach(word -> System.out.print(word + " "));
        } else {
            System.out.print("Please provide non null values!");
        }
    }

    /**
     * Given a list of integers, the method calculates the sum of all odd numbers.
     * @param numbers The given list of numbers.
     */
    public static void sumOfOddNumbers(List<Integer> numbers){
        if (numbers != null){
            System.out.println("The list of the numbers: " + numbers);

            int sum = numbers.stream()
                    .filter(n -> n % 2 != 0)
                    .reduce(0, Integer::sum);

            System.out.print("The sum of the odd numbers: " + sum);
        } else {
            System.out.print("Please provide non null values!");
        }
    }

    /**
     * Given a list of strings, it finds the first string that starts with the specified letter.
     * @param letter The given letter.
     * @param words The given words.
     */
    public static void startsWithLetter(char letter, List<String> words){
        if (words == null){
            System.out.print("Please provide non null values!");
        } else {
            if ((int) letter >= 65 && (int) letter <= 122){
                System.out.print("The words that starts with the letter " + letter + ": ");
                String result = words.stream()
                        .filter(word -> word.startsWith(String.valueOf(letter)))
                        .collect(Collectors.joining(", "));
                System.out.print((result.isEmpty()) ? "Not found" : result);
            } else {
                System.out.print("Please provide a letter");
            }
        }
    }

    /**
     * Given a list of strings, it groups the strings by their lengths.
     * @param words The given list of strings.
     */
    public static void groupingByLength(List<String> words){
        if (words == null){
            System.out.print("Please provide non null values!");
        } else {
            System.out.println("The list: " + words);

            System.out.println("Result: ");

            words.stream()
                    .collect(Collectors.groupingBy(String::length))
                    .forEach((word, length) -> System.out.println(word + ": " + length));
        }
    }

    /**
     * Given a list of integers, it sorts the numbers in descending order.
     * @param numbers The given list.
     */
    public static void sortDescending(List<Integer> numbers){
        if (numbers == null){
            System.out.print("Please provide non null values!");
        } else {
            System.out.println("The list of numbers: " + numbers);

            System.out.print("The sorted list: ");

            String result = numbers.stream()
                    .sorted(Comparator.reverseOrder())
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
    }

    /**
     * Given a list of integers, it finds the maximum number.
     * @param numbers The given list.
     */
    public static void findMax(List<Integer> numbers){
        if (numbers == null){
            System.out.print("Please provide non null values!");
        } else {
            System.out.println("The list of the numbers: " + numbers);

            var max = numbers.stream()
                    .max(Comparator.naturalOrder())
                    .get();

            System.out.println("The maximum element of the list is " + max);
        }
    }

    /**
     * Given a list of integers, it checks if all numbers are greater than a given number.
     * @param number The given number.
     * @param numbers The given list.
     */
    public static void allAreGreaterThan(int number, List<Integer> numbers){
        if (numbers == null){
            System.out.print("Please provide non null values!");
        } else {
            List<Integer> result = numbers.stream()
                    .filter(n -> n > number)
                    .toList();

            if (result.size() == numbers.size()){
                System.out.print("All numbers are greater than the given number!");
            } else {
                System.out.print("Not all numbers are greater than the given number!");
            }
        }
    }

    /**
     * Given a list of strings, it finds the top 3 longest strings.
     * @param words The given list.
     */
    public static void findTop3Strings(List<String> words){
        System.out.println("The list: " + words);

        System.out.println("Top 3 longest strings: ");

        words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}
