package Exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test for Exercises class")
class ExercisesTest {

    @Test
    @DisplayName("Dictionary method")
    void dictionaryTest() {
        assertArrayEquals(new String[]{"button"} ,Exercises.dictionary("bu", new String[]{"button", "breakfast", "border"}));
        assertArrayEquals(new String[]{"triplet", "tries", "trip"} ,Exercises.dictionary("tri", new String[]{"triplet", "tries", "trip", "piano", "tree"}));
        assertArrayEquals(new String[]{} ,Exercises.dictionary("beau", new String[]{"pastry", "delicious", "name", "boring"}));
        assertNull(Exercises.dictionary(null, null));
        assertNull(Exercises.dictionary("", null));
        assertNull(Exercises.dictionary(null, new String[]{}));
    }

    @Test
    @DisplayName("oddsVsEvens method")
    void oddsVsEvens() {
        assertEquals("The number should be greater than 9.", Exercises.oddsVsEvens(0));
        assertEquals("The number should be greater than 9.", Exercises.oddsVsEvens(5));
        assertEquals("odd", Exercises.oddsVsEvens(10));
        assertEquals("even", Exercises.oddsVsEvens(467835));
        assertEquals("odd", Exercises.oddsVsEvens(37946736));
        assertEquals("odd", Exercises.oddsVsEvens(31));
        assertEquals("odd", Exercises.oddsVsEvens(67));
        assertEquals("even", Exercises.oddsVsEvens(83));
    }

    @ParameterizedTest
    @DisplayName("isHarshad method for false results")
    @ValueSource(ints = {-2, 0, 17})
    void isHarshadFalseTest(int input) {
        assertFalse(Exercises.isHarshad(input));
    }

    @ParameterizedTest
    @DisplayName("isHarshad method for true results")
    @ValueSource(ints = {2, 18, 54})
    void isHarshadTrueTest(int input) {
        assertTrue(Exercises.isHarshad(input));
    }
}