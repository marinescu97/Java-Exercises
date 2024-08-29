package Exercises;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test for overloaded methods")
public class OverloadedMethodsTest {

    @Nested
    class OverloadedMethodsBasicTest{
        private ByteArrayOutputStream outputStream;

        @BeforeEach
        void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @DisplayName("Display square first method")
        @Test
        void displaySquare1Test(){
            OverloadedMethods.displaySquare(4);

            assertEquals("""
                ****
                ****
                ****
                ****
                """, outputStream.toString());
        }

        @DisplayName("Display square first method with zero value")
        @Test
        void displaySquare1TestZero(){
            OverloadedMethods.displaySquare(0);
            assertEquals("",outputStream.toString());
        }

        @DisplayName("Display square first method with negative value")
        @Test
        void displaySquare1TestNegative(){
            OverloadedMethods.displaySquare(-1);
            assertEquals("The number must be positive!\n", outputStream.toString());
        }

        @DisplayName("Display square second method")
        @Test
        void displaySquare2Test(){
            OverloadedMethods.displaySquare(4, '#');

            assertEquals("""
                ####
                ####
                ####
                ####
                """, outputStream.toString());
        }

        @DisplayName("Display square second method with zero value")
        @Test
        void displaySquare2TestZero(){
            OverloadedMethods.displaySquare(0, '%');
            assertEquals("",outputStream.toString());
        }

        @DisplayName("Display square second method with negative value")
        @Test
        void displaySquare2TestNegative(){
            OverloadedMethods.displaySquare(-1, '#');
            assertEquals("The number must be positive!\n", outputStream.toString());
        }

        @DisplayName("Area of a square test")
        @Test
        void areaSquareTest(){
            assertEquals(36, OverloadedMethods.area(6));
            assertEquals(0, OverloadedMethods.area(0));

            int result = OverloadedMethods.area(-2);
            assertEquals(0, result);
            assertEquals("The number must be positive!\n", outputStream.toString());
        }

        @DisplayName("Area of a rectangle test")
        @Test
        void areaRectangleTest(){
            assertEquals(12, OverloadedMethods.area(6, 2));
            assertEquals(0, OverloadedMethods.area(0, 9));
            assertEquals(0, OverloadedMethods.area(0, -1));

            int result = OverloadedMethods.area(-2, 7);
            assertEquals(0, result);
            assertEquals("The values must be positive!\n".repeat(3), outputStream.toString());
        }

        @AfterEach
        void tearDown() {
            System.setOut(System.out);
        }
    }

    @Nested
    class FinalGradeTest{
        private ByteArrayOutputStream outputStream;

        @BeforeEach
        void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @DisplayName("Final grade with laboratory and exam valid input")
        @Test
        void finalGradeNoPartialValidInputTest() {
                System.setIn(new ByteArrayInputStream("OOP\nn\n8,5\n9\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
                Exam: \
                Does the student have a partial grade? (y/n)
                Laboratory: \
                Exam: \
                OOP\
                
                Final grade:\
                8.9
                """, outputStream.toString());
        }

        @DisplayName("Final grade with laboratory and exam invalid input")
        @Test
        void finalGradeNoPartialInvalidInputTest() {
                System.setIn(new ByteArrayInputStream("OOP\nn\n-2\n9\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
                Exam: \
                Does the student have a partial grade? (y/n)
                Laboratory: \
                Exam: \
                OOP\
                
                Please enter valid values!
                """, outputStream.toString());
        }

        @DisplayName("Final grade with laboratory and exam with zero")
        @Test
        void finalGradeNoPartialZeroInputTest() {
                System.setIn(new ByteArrayInputStream("OOP\nn\n0\n9\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
                    Exam: \
                    Does the student have a partial grade? (y/n)
                    Laboratory: \
                    Exam: \
                    OOP\
        
                    Please enter valid values!
                    """, outputStream.toString());
        }

        @DisplayName("Final grade with wrong answer (y/n)")
        @Test
        void finalGradeWrongAnswerTest() {
                System.setIn(new ByteArrayInputStream("OOP\ng\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
            Exam: \
            Does the student have a partial grade? (y/n)
            """, outputStream.toString());
        }

        @DisplayName("Final grade with laboratory, exam and partial valid input")
        @Test
        void finalGradeValidInputTest() {
                System.setIn(new ByteArrayInputStream("OOP\ny\n8,5\n9\n7\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
                    Exam: \
                    Does the student have a partial grade? (y/n)
                    Partial: \
                    Laboratory: \
                    Exam: \
                    OOP\
        
                    Final grade: \
                    7.7
                    """, outputStream.toString());
        }

        @DisplayName("Final grade with laboratory, exam and partial invalid input")
        @Test
        void finalGradeInvalidInputTest() {
                System.setIn(new ByteArrayInputStream("OOP\ny\n-2\n9\n7\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
                    Exam: \
                    Does the student have a partial grade? (y/n)
                    Partial: \
                    Laboratory: \
                    Exam: \
                    OOP\
        
                    Please enter valid values!
                    """, outputStream.toString());
        }

        @DisplayName("Final grade with laboratory, exam and partial with zero")
        @Test
        void finalGradeZeroInputTest() {
                System.setIn(new ByteArrayInputStream("OOP\nn\n0\n9\n7\n".getBytes()));

                OverloadedMethods.displayStudentData();

                assertEquals("""
                    Exam: \
                    Does the student have a partial grade? (y/n)
                    Laboratory: \
                    Exam: \
                    OOP\
        
                    Please enter valid values!
                    """, outputStream.toString());
        }

        @AfterEach
        void tearDown() {
            System.setOut(System.out);
        }
    }
}
