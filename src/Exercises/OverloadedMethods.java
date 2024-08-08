package Exercises;

import java.util.Scanner;

/**
 * This class contains overloaded methods.
 */
public class OverloadedMethods {
    /**
     * A {@link Scanner} object used for text input.
     */
    static Scanner s = new Scanner(System.in);

    // Overloaded methods that display squares.
    /**
     * Displays a square of given side and default symbol.
     * @param l The given side.
     */
    private static void displaySquare(int l){
        for (int i=0; i<l; i++){
            for (int j=0; j<l; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Displays a square whose side and symbol are given.
     * @param l The given side.
     * @param c The given symbol.
     */
    private static void displaySquare(int l, char c){
        for (int i=0; i<l; i++){
            for (int j=0; j<l; j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Overloaded methods that calculate the area of a square and a rectangle.

    /**
     * Calculates the area of a square.
     * @param length The side of the square.
     * @return The area.
     */
    private static int area(int length){
        return length * length;
    }

    /**
     * Calculates the area of a rectangle.
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @return The area.
     */
    private static int area(int length, int width){
        return length * width;
    }

    /**
     * Calculates the final grade when the student has a partial grade (20% of the final grade), a laboratory grade (20% of the final grade), and an exam grade (60% of the final grade).
     * @param partial The partial grade.
     * @param laboratory The laboratory grade.
     * @param exam The exam grade.
     * @return The final grade.
     */
    private static float finalGrade(float partial, float laboratory, float exam) {
        return (float) (20.0f / 100.0f) * partial + (20.0f / 100.0f) * laboratory + (60.0f / 100.0f) * exam;
    }

    /**
     * Calculates the final grade when the student has a laboratory grade (30% of the final grade), and an exam grade (70% of the final grade).
     * @param laboratory The laboratory grade.
     * @param exam The exam grade.
     * @return The final grade.
     */
    private static float finalGrade(float laboratory, float exam) {
        return (float) (30.0f / 100.0f) * laboratory + (70.0f / 100.0f) * exam;
    }

    /**
     * Displays the data of a student.
     */
    private static void displayStudentData(){
        System.out.print("Exam: ");
        String name = s.nextLine();

        System.out.print("Does the student have a partial grade? (y/n)\n");
        char part = s.nextLine().charAt(0);

        if (part == 'y') {
            System.out.print("Partial: ");
            float partial = s.nextFloat();

            System.out.print("Laboratory: ");
            float laboratory = s.nextFloat();

            System.out.print("Exam: ");
            float exam = s.nextFloat();

            System.out.println(name + "\nFinal grade: " + finalGrade(partial, laboratory, exam));
        } else if (part=='n') {
            System.out.print("Laboratory: ");
            float laboratory = s.nextFloat();

            System.out.print("Exam: ");
            float exam = s.nextFloat();

            System.out.println(name + "\nFinal grade: " + finalGrade(laboratory, exam));
        }
    }

    public static void main(String[] args) {

    }
}
