package Exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicExercisesTest {
    private BasicExercises exercises;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        exercises = new BasicExercises();
        outputStream = new ByteArrayOutputStream();
    }

    private static Stream<Arguments> provideArgsForFunctionTest(){
        return Stream.of(
                Arguments.of(10, -3),
                Arguments.of(17, -4),
                Arguments.of(-2, 0),
                Arguments.of(0, 2),
                Arguments.of(2, 3),
                Arguments.of(10, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForFunctionTest")
    void functionTest(int expected, int input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = BasicExercises.class.getDeclaredMethod("func", int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(exercises, input);

        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void isPerfectTest(){
        assertFalse(BasicExercises.isPerfect(-2));
        assertFalse(BasicExercises.isPerfect(16));
        assertTrue(BasicExercises.isPerfect(6));
        assertFalse(BasicExercises.isPerfect(17));
        assertTrue(BasicExercises.isPerfect(28));
    }

    @org.junit.jupiter.api.Test
    void isPalindromeTest(){
        assertFalse(exercises.isPalindrome(-35754));
        assertFalse(exercises.isPalindrome(374683));
        assertTrue(exercises.isPalindrome(85358));
    }

    @org.junit.jupiter.api.Test
    void sumTest(){
        assertEquals(120, exercises.sum());
    }

    @org.junit.jupiter.api.Test
    void product(){
        long result = 3715891200L;
        assertEquals(result, exercises.product());
        assertEquals(result, exercises.product1());
        assertEquals(result, exercises.product2());
    }

    @org.junit.jupiter.api.Test
    void monthTest(){
        assertEquals("June", exercises.month(6));
        assertEquals("Enter a number between 1 and 12 inclusive", exercises.month(-1));
        assertEquals("Enter a number between 1 and 12 inclusive", exercises.month(13));
    }

    private static Stream<Arguments> provideArgsCelsiusFahrenheitTest(){
        return Stream.of(
                Arguments.of(0, 32),
                Arguments.of(-5, 23),
                Arguments.of(10, 50),
                Arguments.of(23, 73.4),
                Arguments.of(25.6, 78.08)
        );
    }

    private static Stream<Arguments> provideArgsFahrenheitCelsiusTest(){
        return Stream.of(
                Arguments.of(32, 0),
                Arguments.of(23, -5),
                Arguments.of(50, 10),
                Arguments.of(73.4, 23),
                Arguments.of(78.08, 25.6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsCelsiusFahrenheitTest")
    void celsiusToFahrenheitTest(double input, double expected){
        assertEquals(expected, exercises.convertToFahrenheit(input));
    }

    @ParameterizedTest
    @MethodSource("provideArgsFahrenheitCelsiusTest")
    void fahrenheitToCelsiusTest(double input, double expected){
        assertEquals(expected, exercises.convertToCelsius(input));
    }

    // Not working
//    @Test
//    void calcTest(){
//        System.setOut(System.out);
//        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n3\n".getBytes());
//        System.setIn(inputStream);
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        exercises.calc();
//
//        assertEquals("""
//                Sum: 5
//                Difference: -1
//                Product: 6
//                Maximum: 3
//                Minimum: 2
//                """, outputStream.toString());
//    }

    @org.junit.jupiter.api.Test
    void testCalc(){
        System.setOut(new PrintStream(outputStream));

        exercises.calc(2, 3);

        assertEquals("""
                Sum: 5
                Difference: -1
                Product: 6
                Maximum: 3
                Minimum: 2
                """, outputStream.toString());

        System.setOut(System.out);
    }

    private static Stream<Arguments> provideArgsFor_displaySquareTest(){
        return Stream.of(
                Arguments.of("""
                    ***
                    ***
                    ***
                    """, 3),
                Arguments.of("The length should be greater than 0.\n", 0),
                Arguments.of("The length should be greater than 0.\n", -3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsFor_displaySquareTest")
    void displaySquareTest(String expected, int input){
        System.setOut(new PrintStream(outputStream));

        exercises.displaySquare(input);

        assertEquals(expected, outputStream.toString());

        System.setOut(System.out);
    }

    @org.junit.jupiter.api.Test
    void factorialTest(){
        assertNull(exercises.factorial(-4));
        assertEquals(BigDecimal.valueOf(1), exercises.factorial(0));
        assertEquals(BigDecimal.valueOf(24), exercises.factorial(4));
        assertEquals(BigDecimal.valueOf(87178291200L), exercises.factorial(14));
        assertEquals(new BigDecimal("1.307674368E+12"), exercises.factorial(15));
        assertEquals(new BigDecimal("8.159152832E+47"), exercises.factorial(40));
    }

    @org.junit.jupiter.api.Test
    void divisorsNumberTest(){
        assertEquals(0, BasicExercises.divisorsNumber(-4));
        assertEquals(0, BasicExercises.divisorsNumber(0));
        assertEquals(1, BasicExercises.divisorsNumber(1));
        assertEquals(2, BasicExercises.divisorsNumber(7));
        assertEquals(8, BasicExercises.divisorsNumber(24));
        assertEquals(4, BasicExercises.divisorsNumber(3455));
    }

    @org.junit.jupiter.api.Test
    void highestNumberOfDivisorsTest(){
        assertEquals(7560, exercises.highestNumberOfDivisors());
    }

    @org.junit.jupiter.api.Test
    void starTest(){
        System.setOut(new PrintStream(outputStream));

        exercises.star();

        assertEquals("\n*\n**\n***\n****\n*****\n******\n*******\n********\n*********\n**********\n", outputStream.toString());
    }

    @org.junit.jupiter.api.Test
    void countChars(){
        assertEquals(0, exercises.countChars("Hello World", 'm'));
        assertEquals(3, exercises.countChars("Hello World", 'l'));
        assertEquals(5, exercises.countChars("Hellllo World", 'l'));
    }

    @Test
    void showInitialsTest(){
        System.setOut(new PrintStream(outputStream));
        exercises.showInitials();

        assertEquals("""
                *       *      *   \s
                **     **          \s
                * *   * *     * *  \s
                *  **   *          \s
                *       *    ***** \s
                *       *          \s
                *       *   *     *\s
                *       *          \s
                *       *  *       *
                """, outputStream.toString());
    }
}
