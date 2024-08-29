package Exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamsTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void filterEvenNumbersTest() {
        Streams.filterEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -2, -3, 0));

        assertEquals("Initial list: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -2, -3, 0]\n" +
                "Filtered list: 2 4 6 8 10 -2 0 ", outputStream.toString());
    }

    @Test
    void filterEvenNumbersNullTest() {
        Streams.filterEvenNumbers(null);

        assertEquals("Please provide non null values!", outputStream.toString());
    }

    @Test
    void toUpperCaseTest() {
        Streams.toUpperCase(Arrays.asList("hello", "world", "java", "programming"));

        assertEquals("Initial list: [hello, world, java, programming]\n" +
                "Words to uppercase: HELLO WORLD JAVA PROGRAMMING ", outputStream.toString());
    }

    @Test
    void toUpperCaseNullTest() {
        Streams.toUpperCase(null);

        assertEquals("Please provide non null values!", outputStream.toString());
    }

    @Test
    void sumOfOddNumbersTest() {
        Streams.sumOfOddNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -2, -3, 0));

        assertEquals("The list of the numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -2, -3, 0]\n" +
                "The sum of the odd numbers: 22", outputStream.toString());
    }

    @Test
    void sumOfOddNumbersNullTest() {
        Streams.sumOfOddNumbers(null);

        assertEquals("Please provide non null values!", outputStream.toString());
    }

    private static Stream<Arguments> provideArgsForStartsWithLetter(){
        return Stream.of(
                Arguments.of('w', Arrays.asList("hello", "world", "java", "wide", "web"), "The words that starts with the letter w: world, wide, web"),
                Arguments.of('a', Arrays.asList("hello", "world", "java", "wide", "web"), "The words that starts with the letter a: Not found"),
                Arguments.of('a', null, "Please provide non null values!"),
                Arguments.of("2", Arrays.asList("hello", "world"), "Please provide a letter")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForStartsWithLetter")
    void startsWithLetterTest(char letter, List<String> words, String output){
        Streams.startsWithLetter(letter, words);

        assertEquals(output, outputStream.toString());
    }

    @Test
    void groupingByLengthTest(){
        Streams.groupingByLength(Arrays.asList("hello", "world", "java", "programming", "five", "script"));

        assertEquals("""
                The list: [hello, world, java, programming, five, script]
                Result:\s
                4: [java, five]
                5: [hello, world]
                6: [script]
                11: [programming]
                """, outputStream.toString());
    }

    @Test
    void groupingByLengthNullTest(){
        Streams.groupingByLength(null);
        assertEquals("Please provide non null values!", outputStream.toString());
    }

    @Test
    void sortDescendingTest(){
        Streams.sortDescending(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));
        assertEquals("""
                The list of numbers: [5, 2, 8, 1, 9, 3, 7, 4, 6]
                The sorted list: 9, 8, 7, 6, 5, 4, 3, 2, 1
                """, outputStream.toString());
    }

    @Test
    void sortDescendingNullTest(){
        Streams.sortDescending(null);
        assertEquals("Please provide non null values!", outputStream.toString());
    }

    @Test
    void findMaxTest(){
        Streams.findMax(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));
        assertEquals("""
                The list of the numbers: [5, 2, 8, 1, 9, 3, 7, 4, 6]
                The maximum element of the list is 9
                """, outputStream.toString());
    }

    @Test
    void findMaxNullTest(){
        Streams.findMax(null);
        assertEquals("Please provide non null values!", outputStream.toString());
    }

    private static Stream<Arguments> provideArgsForAllAreGreaterThan(){
        return Stream.of(
                Arguments.of(2, Arrays.asList(6, 4, 9, 5, 3, 10), "All numbers are greater than the given number!"),
                Arguments.of(5, Arrays.asList(6, 4, 9, 5, 3, 10), "Not all numbers are greater than the given number!"),
                Arguments.of(2, null, "Please provide non null values!")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForAllAreGreaterThan")
    void allAreGreaterThanTest(int number, List<Integer> numbers, String expected){
        Streams.allAreGreaterThan(number, numbers);
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void findTop3Strings(){
        Streams.findTop3Strings(Arrays.asList("hello", "world", "java", "streams", "javascript", "programming", "software", "development"));

        assertEquals("""
                The list: [hello, world, java, streams, javascript, programming, software, development]
                Top 3 longest strings:\s
                programming
                development
                javascript
                """, outputStream.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}
