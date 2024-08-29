package Exercises;

import java.util.Scanner;

/**
 * This class contains overloaded methods.
 */
public class OverloadedMethods {
    // Overloaded methods that display squares.
    /**
     * Displays a square of given side and default symbol.
     * @param l The given side.
     */
    public static void displaySquare(int l){
        if (l < 0){
            System.out.println("The number must be positive!");
        } else {
            for (int i=0; i<l; i++){
                for (int j=0; j<l; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    /**
     * Displays a square whose side and symbol are given.
     * @param l The given side.
     * @param c The given symbol.
     */
    public static void displaySquare(int l, char c){
        if (l < 0){
            System.out.println("The number must be positive!");
        } else {
            for (int i=0; i<l; i++){
                for (int j=0; j<l; j++){
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    // Overloaded methods that calculate the area of a square and a rectangle.

    /**
     * Calculates the area of a square.
     * @param length The side of the square.
     * @return The area.
     */
    public static int area(int length){
        if (length < 0){
            System.out.println("The number must be positive!");
            return 0;
        }
        return length * length;
    }

    /**
     * Calculates the area of a rectangle.
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @return The area.
     */
    public static int area(int length, int width){
        if (length <= 0 || width <= 0){
            System.out.println("The values must be positive!");
            return 0;
        }
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
        float finalPartial = (20.0f / 100.0f) * partial;
        float finalLab = (20.0f / 100.0f) * laboratory;
        float finalExam = (60.0f / 100.0f) * exam;
        return (float) ((Math.floor(finalPartial * 10) / 10) + (Math.floor(finalLab * 10) / 10) + (Math.floor(finalExam * 10) / 10));
    }

    /**
     * Calculates the final grade when the student has a laboratory grade (30% of the final grade), and an exam grade (70% of the final grade).
     * @param laboratory The laboratory grade.
     * @param exam The exam grade.
     * @return The final grade.
     */
    private static float finalGrade(float laboratory, float exam) {
        float finalLab = (30.0f / 100.0f) * laboratory;
        float finalExam = (70.0f / 100.0f) * exam;
        return (float) ((Math.ceil(finalLab * 10) / 10) + (Math.ceil(finalExam * 10) / 10));
    }

    /**
     * Displays the data of a student.
     */
    public static void displayStudentData(){
        Scanner s = new Scanner(System.in);
        System.out.print("Exam: ");
        String name = s.nextLine();

        System.out.println("Does the student have a partial grade? (y/n)");
        char part = s.nextLine().charAt(0);

        if (part == 'y') {
            System.out.print("Partial: ");
            float partial = s.nextFloat();

            System.out.print("Laboratory: ");
            float laboratory = s.nextFloat();

            System.out.print("Exam: ");
            float exam = s.nextFloat();

            if (partial <= 0 || laboratory <=0 || exam <=0){
                System.out.println(name + "\nPlease enter valid values!");
            } else {
                System.out.println(name + "\nFinal grade: " + finalGrade(partial, laboratory, exam));
            }
        } else if (part=='n') {
            System.out.print("Laboratory: ");
            float laboratory = s.nextFloat();

            System.out.print("Exam: ");
            float exam = s.nextFloat();

            if (laboratory <= 0 || exam <= 0){
                System.out.println(name + "\nPlease enter valid values!");
            } else {
                System.out.println(name + "\nFinal grade:" + finalGrade(laboratory, exam));
            }
        }
    }
}
