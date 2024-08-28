package Objects.Examen;

/**
 * This class represents a course.
 */
public class Course {
    /**
     * The name of the course.
     */
    private final String name;

    /**
     * Constructs a new course.
     * @param name the name of the course
     */
    Course(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the course
     * @return the name of the course
     */
    public String getName(){
        return name;
    }
}
