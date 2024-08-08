package Objects.Examen;

/**
 * This class represents a professor.
 */
public class Professor {
    private final String name;

    /**
     * Constructs a new Professor.
     * @param name the professor's name
     */
    Professor(String name){
        this.name=name;
    }

    /**
     * Gets the professor's name.
     * @return the professor's name
     */
    public String getName(){
        return name;
    }
}
