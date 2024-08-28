package Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatrixTest {
    private static Stream<Arguments> provideArgsForDisplay(){
        return Stream.of(
                Arguments.of(new int[][]{{1, 4, 5}, {3, 6, 8}, {3, 7, 5}}, "1 4 5 \n3 6 8 \n3 7 5 \n"),
                Arguments.of(null, "The array is not set.\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForDisplay")
    void displayTest(int[][] arr, String expected) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Matrix matrix = new Matrix(arr);
        matrix.display();

        assertEquals(expected, outputStream.toString());

        System.setOut(System.out);
    }

    private static Stream<Arguments> provideArgsForNullMatrixOperationsTest(){
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForNullMatrixOperationsTest")
    void nullMatrixTest(int[][] arr1, int[][] arr2) {
        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);

        assertThrows(NullPointerException.class, () -> matrix1.sum(matrix2));
        assertThrows(NullPointerException.class, () -> matrix1.subtraction(matrix2));
        assertThrows(NullPointerException.class, () -> matrix1.product(matrix2));
    }

    @org.junit.jupiter.api.Test
    void sumTest() {
        int[][] arr1 ={{1,2,3}, {6,3,1}, {9,3,6}};
        int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        Matrix m = new Matrix(arr1);
        Matrix n = new Matrix(arr2);

        assertArrayEquals(new int[][]{{2, 4, 6}, {10, 8, 7}, {16, 11, 15}}, m.sum(n).getMatrix());
    }

    @org.junit.jupiter.api.Test
    void subtractionTest() {
        int[][] arr1 ={{1,2,3}, {6,3,1}, {9,3,6}};
        int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        Matrix m = new Matrix(arr1);
        Matrix n = new Matrix(arr2);

        assertArrayEquals(new int[][]{{0, 0, 0}, {2, -2, -5}, {2, -5, -3}}, m.subtraction(n).getMatrix());
    }

    @org.junit.jupiter.api.Test
    void transposeTest() {
        int[][] arr1 ={{1,2,3}, {6,3,1}, {9,3,6}};
        Matrix m = new Matrix(arr1);

        assertArrayEquals(new int[][]{{1, 6, 9}, {2, 3, 3}, {3, 1, 6}}, m.transpose().getMatrix());

        assertThrows(NullPointerException.class, new Matrix(null)::transpose);
    }

    @org.junit.jupiter.api.Test
    void productTest() {
        int[][] arr1 ={{1,2,3}, {6,3,1}, {9,3,6}};
        int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        Matrix m = new Matrix(arr1);
        Matrix n = new Matrix(arr2);

        assertArrayEquals(new int[][]{{30, 36, 42}, {25, 35, 45}, {63, 81, 99}}, m.product(n).getMatrix());
    }

    @Test
    void minSumSubmatrices() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int[][] arr1 ={{1,2,3}, {6,3,1}, {9,3,6}};
        Matrix m = new Matrix(arr1);
        m.minSumSubmatrices(2);

        assertEquals("The minimum amount is 9. The region starts on line 1, column 2\n", out.toString());

        System.setOut(System.out);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> m.minSumSubmatrices(4));

        Matrix finalM1 = null;
        assertThrows(NullPointerException.class, () -> finalM1.minSumSubmatrices(2));
    }
}
