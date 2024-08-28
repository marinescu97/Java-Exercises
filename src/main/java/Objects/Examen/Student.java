package Objects.Examen;

/**
 * This class represents a student.
 */
public class Student {
    /**
     * The name of the student.
     */
    private final String name;
    /**
     * The student's grade.
     */
    private double grade;

    /**
     * Constructs a new Student.
     * @param name the student's name
     * @param grade the student's grade
     */
    Student(String name, double grade){
        this.name = name;
        this.grade=grade;
    }

    /**
     * Gets the student's grade.
     * @return the student's grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Gets the student's name.
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's grade.
     * @param grade the student's grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Displays a student and his grade.
     */
    public void display() {
        System.out.println(getName() + " -> " + getGrade());
    }
}
