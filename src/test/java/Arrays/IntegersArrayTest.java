package Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegersArrayTest {
    @org.junit.jupiter.api.Test
    void testConstructor(){
        int [] arr1 = {4, 7, 8};
        IntegersArray obj1 = new IntegersArray(arr1);
        assertEquals(arr1, obj1.getArr());

        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11};
        IntegersArray obj2 = new IntegersArray(arr2);
        assertNull(obj2.getArr());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        new IntegersArray(arr2);
        assertEquals("Maximum length 10!" + System.lineSeparator(), outputStream.toString());
        System.setOut(System.out);
    }

    @org.junit.jupiter.api.Test
    void testConstructorRandom(){
        int n = 4;
        IntegersArray obj1 = new IntegersArray(n);

        assertNotNull(obj1.getArr());
        assertEquals(n, obj1.getArr().length);

        int[] arr = obj1.getArr();
        for (int i : arr){
            assertTrue(i >= 0 && i < 10);
        }

        n = -1;
        IntegersArray obj2 = new IntegersArray(n);
        assertNull(obj2.getArr());
    }

    @org.junit.jupiter.api.Test
    void testEquals(){
        assertNotEquals(new IntegersArray(new int[]{1, 2, 3}), new IntegersArray(new int[]{1, 2}));
        assertNotEquals(new IntegersArray(new int[]{1, 2, 3}), new IntegersArray(new int[]{4, 5, 6}));
        assertEquals(new IntegersArray(new int[]{1, 2, 3}), new IntegersArray(new int[]{1, 2, 3}));
    }

    private static Stream<Arguments> provideArgsForTestMax(){
        return Stream.of(
                Arguments.of(new IntegersArray(new int[]{1, 2, 3, 4}), new int[]{2, 3, 4}, 5),
                Arguments.of(new IntegersArray(new int[]{1, 4}), new int[]{2, 6, 4}, 7),
                Arguments.of(new IntegersArray(new int[]{8, 9}), new int[]{2, 4, 5}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestMax")
    void testMax(IntegersArray thisObj, int[] array, int expectedLength){
        assertEquals(expectedLength, thisObj.max(array).getArr().length);
    }

    private static Stream<Arguments> provideArgsForTestReunion(){
        return Stream.of(
                Arguments.of(new IntegersArray(new int[]{2, 3, 4}), new int[]{7, 8, 9}, new int[]{0, 0, 1, 1, 1, 0, 0, 1, 1, 1}),
                Arguments.of(new IntegersArray(new int[]{0, 1}), new int[]{0}, new int[]{1, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestReunion")
    void testReunion(IntegersArray obj, int[] array, int[] expectedArray){
        assertArrayEquals(expectedArray, obj.reunion(array));
    }

    @org.junit.jupiter.api.Test
    void testReunionRandom(){
        IntegersArray obj = new IntegersArray(5);
        int[] arr = new int[8];
        int[] reunion = obj.reunion(arr);

        for (int i : reunion){
            assertTrue(i == 0 || i == 1);
        }
    }

    @Test
    void testIntersectionRandom(){
        IntegersArray obj = new IntegersArray(5);
        int[] arr = new int[8];
        int[] reunion = obj.intersection(arr);

        for (int i : reunion){
            assertTrue(i == 0 || i == 1);
        }
    }

    private static Stream<Arguments> provideArgsForTestIntersection(){
        return Stream.of(
                Arguments.of(new IntegersArray(new int[]{2, 3, 4}), new int[]{7, 8, 9}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
                Arguments.of(new IntegersArray(new int[]{0, 1}), new int[]{0}, new int[]{1, 0}),
                Arguments.of(new IntegersArray(new int[]{5, 8, 3, 5, 6, 2, 5}), new int[]{7, 2, 4, 8, 4, 1, 3, 6}, new int[]{0, 0, 1, 1, 0, 0, 1, 0, 1}),
                Arguments.of(new IntegersArray(new int[]{7, 8, 3, 5, 5, 2, 2}), new int[]{3, 5, 3, 6, 5, 4}, new int[]{0, 0, 0, 1, 0, 1, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestIntersection")
    void testIntersection(IntegersArray obj, int[] array, int[] expectedArray){
        assertArrayEquals(expectedArray, obj.intersection(array));
    }

    private static Stream<Arguments> provideArgsTestInsertItem(){
        return Stream.of(
                Arguments.of(new int[]{5, 8, 3, 5, 1}, 3, 7, new int[]{5, 8, 3, 7, 5, 1}),
                Arguments.of(new int[]{5, 8, 2, 4, 5}, 3, -5, new int[]{5, 8, 2, 4, 5}),
                Arguments.of(new int[]{6, 2, 4, 5, 2, 6}, 2, 4, new int[]{6, 2, 4, 4, 5, 2, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsTestInsertItem")
    void testInsertItem(int[] arrObj,int position, int number, int[] expectedArray){
        IntegersArray expected = new IntegersArray(expectedArray);
        IntegersArray array = new IntegersArray(arrObj);
        array.insertItem(position, number);

        assertEquals(expected, array);
    }

    private static Stream<Arguments> provideArgsForDeleteElemTest(){
        return Stream.of(
                Arguments.of(new int[]{5, 8, 2, 4, 5}, 2, new int[]{5, 8, 4, 5}),
                Arguments.of(new int[]{4}, 0, new int[0]),
                Arguments.of(new int[]{2, 4, 7}, 7, new int[]{2, 4, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForDeleteElemTest")
    void testDeleteElement(int[] arr, int position, int[] expectedArray){
        IntegersArray obj = new IntegersArray(arr);
        obj.deleteElement(position);
        assertArrayEquals(expectedArray, obj.getArr());
    }

    static Stream<Arguments> provideArgsForDisplayTest(){
        return Stream.of(
                Arguments.of(new IntegersArray(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), "---"),
                Arguments.of(new IntegersArray(new int[]{0, 0, 0, 0, 0}), "---"),
                Arguments.of(new IntegersArray(new int[]{1, 2, 3, 4}), "1 2 3 4 ")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForDisplayTest")
    void testDisplay(IntegersArray array, String expected){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        array.display();

        String output = out.toString();

        assertEquals(expected + System.lineSeparator(), output);

        System.setOut(System.out);
    }
}
