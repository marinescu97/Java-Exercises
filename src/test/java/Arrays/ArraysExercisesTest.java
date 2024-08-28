package Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysExercisesTest {
    Exercises arraysExercises;

    @BeforeEach
    void setUp() {
        arraysExercises = new Exercises();
    }

    @org.junit.jupiter.api.Test
    void displayArrayRangeTest() {
        assertNull(arraysExercises.displayArrayRange(5, 3));
        assertNull(arraysExercises.displayArrayRange(3, 3));
        assertArrayEquals(new int[]{9, 6, 3, 0}, arraysExercises.displayArrayRange(0, 10));
        assertArrayEquals(new int[]{6, 3}, arraysExercises.displayArrayRange(2, 7));
        assertArrayEquals(new int[]{30, 27, 24, 21}, arraysExercises.displayArrayRange(21, 30));
    }

    private static Stream<Arguments> provideArgsForDisplayArrayRange() {
        return Stream.of(
                Arguments.of(null, 5, 3),
                Arguments.of(null, 3, 3),
                Arguments.of(new int[]{9, 6, 3, 0}, 0, 10),
                Arguments.of(new int[]{6, 3}, 2, 7),
                Arguments.of(new int[]{30, 27, 24, 21}, 21, 30)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForDisplayArrayRange")
    void displayArrayRangeStreamTest(int[] expected, int a, int b) {
        assertArrayEquals(expected, arraysExercises.displayArrayRangeStream(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForDisplayArrayRange")
    void displayArrayListRangeTest(int[] expected, int a, int b) {
        List<Integer> result;
        if (expected == null){
            result = null;
        } else {
            result = Arrays.stream(expected).boxed().collect(Collectors.toList());
        }
        assertIterableEquals(result, arraysExercises.displayArrayListRange(a, b));
    }

    @org.junit.jupiter.api.Test
    void maxNumberTest() {
        assertNull(null);
        assertEquals(11 , arraysExercises.maxNumber(new int[]{1, 1}));
        assertEquals(7320 , arraysExercises.maxNumber(new int[]{0, 7, 23, 21}));
        assertEquals(8775 , arraysExercises.maxNumber(new int[]{475, 734, 254, 864}));
        assertEquals(71 , arraysExercises.maxNumber(new int[]{-7, 10}));
        assertEquals(8760 , arraysExercises.maxNumber(new int[]{0, -638, -257, -642}));
        assertEquals(987 , arraysExercises.maxNumber(new int[]{73684, 25696, 24574}));
    }


    @ParameterizedTest
    @CsvSource(value = {"1,2,2", "0,7,7", "0,0,0", "-2,1,1", "-3,-7,-3"}, delimiter = ',')
    void maxTest(int a, int b, int expected) {
        assertEquals(expected, arraysExercises.max(a, b));
    }

    private static Stream<Arguments> provideArgsForSorting(){
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{8, 10, 12}, new int[]{10, 8, 12}),
                Arguments.of(new int[]{0, 1, 7, 18, 18, 23}, new int[]{18, 7, 18, 23, 1, 0}),
                Arguments.of(new int[]{-12, -1, 0, 3, 9, 43}, new int[]{-12, 9, 0, -1, 43, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForSorting")
    void sortIntegersTest(int[] expected, int[] input) {
        assertArrayEquals(expected, arraysExercises.sortIntegers(input));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForSorting")
    void sortIntegersStreamTest(int[] expected, int[] input) {
        assertArrayEquals(expected, arraysExercises.sortIntegersStream(input));
    }

    private static Stream<Arguments> provideArgsForSortingDesc(){
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{12, 10, 8}, new int[]{10, 8, 12}),
                Arguments.of(new int[]{23, 18, 18, 7, 1, 0}, new int[]{18, 7, 18, 23, 1, 0}),
                Arguments.of(new int[]{43, 9, 3, 0, -1, -12}, new int[]{-12, 9, 0, -1, 43, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForSortingDesc")
    void sortIntegersDescTest(int[] expected, int[] input) {
        assertArrayEquals(expected, arraysExercises.sortIntegersDesc(input));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForSortingDesc")
    void sortIntegersDescStreamTest(int[] expected, int[] input) {
        assertArrayEquals(expected, arraysExercises.sortIntegersDescStream(input));
    }

    private static Stream<Arguments> provideArgsForSortingEvenIntegers(){
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}),
                Arguments.of(new int[]{7, 34, 26, 12, 73, 8, 6, 2}, new int[]{7, 2, 8, 34, 73, 12, 6, 26}),
                Arguments.of(new int[]{78, 5, 9, 11, 42, 1, 22, 3, 4}, new int[]{4, 5, 9, 11, 42, 1, 78, 3, 22})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForSortingEvenIntegers")
    void sortEvenIntegersTest(int[] expected, int[] input) {
        assertArrayEquals(expected, arraysExercises.sortEvenIntegers(input));
    }

    @org.junit.jupiter.api.Test
    void checkDepressionTest() {
        assertFalse(arraysExercises.checkDepression(null));
        assertTrue(arraysExercises.checkDepression(new int[]{5, 3, 2, 4, 5}));
        assertTrue(arraysExercises.checkDepression(new int[]{5, 3, 4, 5}));
        assertTrue(arraysExercises.checkDepression(new int[]{7, 4, 5, 6, 7}));
        assertFalse(arraysExercises.checkDepression(new int[]{5, 3, 2, 2, 3}));
        assertFalse(arraysExercises.checkDepression(new int[]{6, 7, 8, 9}));
    }

    @org.junit.jupiter.api.Test
    void checkSameNumberOfDigitsTest() {
        assertFalse(arraysExercises.checkSameNumberOfDigits(null));
        assertTrue(arraysExercises.checkSameNumberOfDigits(new int[]{1, 1, 1, 1}));
        assertTrue(arraysExercises.checkSameNumberOfDigits(new int[]{5, 3, 2, 4, 5, 2, 3, 4}));
        assertTrue(arraysExercises.checkSameNumberOfDigits(new int[]{6, 1, 4, 8, 4, 1, 6, 8}));
        assertFalse(arraysExercises.checkSameNumberOfDigits(new int[]{6, 2, 8, 3, 2, 8, 3}));
    }

    private static Stream<Arguments> provideArgsOccurrencesNumber(){
        return Stream.of(
                Arguments.of(new int[]{5, 8, 2, 4, 2, 5, 1, 5, 4}, 5, 3),
                Arguments.of(null, 3, 0),
                Arguments.of(new int[]{23, 76, 34, 1}, 4, 0),
                Arguments.of(new int[]{7, 2, 4, 6, 6, 2, 4}, 7, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsOccurrencesNumber")
    void occurrencesNumberTest(int[] arr, int number, int expected) {
        assertEquals(expected, arraysExercises.occurrencesNumber(arr, number));
    }

    @Test
    void directlyOrInverselyProportionalTest() {
        assertNull(arraysExercises.directlyOrInverselyProportional(null,null));
        assertEquals("Directly proportional", arraysExercises.directlyOrInverselyProportional(new int[]{2, 5, 7}, new int[]{6, 15, 21}));
        assertEquals("Inversely proportional", arraysExercises.directlyOrInverselyProportional(new int[]{2, 6, 8}, new int[]{12, 4, 3}));
        assertEquals("The arrays are neither directly proportional nor inversely proportional", arraysExercises.directlyOrInverselyProportional(new int[]{2, 4, 6, 8}, new int[]{1, 3, 5, 7}));
    }
}
