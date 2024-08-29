package Exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StatCalcTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private static Stream<Arguments> provideArgsForTest(){
        return Stream.of(
                Arguments.of(new int[]{15, 16, 17}, "15 16 17 \n", "3", "48", "16,00", "15", "17", "0,82"),
                Arguments.of(new int[]{-2, 7, 0, 4, -5}, "-2 7 0 4 -5 \n", "5", "4", "0,00", "-5", "7", "4,34")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTest")
    void test(int[] elements, String numbers,String count, String sum, String mean, String min, String max, String standardDev){
        StatCalc.calculator(elements);

        assertEquals((numbers +
                "Number of elements: %s\nThe sum: %s\nThe mean: %s\nThe minimum: %s\nThe maximum: %s\nThe standard deviation: %s")
                .formatted(count, sum, mean, min, max, standardDev), outputStream.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}
