package Objects;

/**
 * This class represents a complex number and contains operations on it.
 */
public class Complex {
    /**
     * The real number.
     */
    private final double realNumber;
    /**
     * The imaginary number.
     */
    private final double imaginaryNumber;

    /**
     * Constructs an instance object of a complex number.
     * @param realNumber the real number
     * @param imaginaryNumber the imaginary number
     */
    Complex(double realNumber, double imaginaryNumber){
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    /**
     * Constructs an instance object of a complex number with default values.
     */
    Complex(){
        this(2,3);
    }

    /**
     * Gets the real number.
     * @return the real number
     */
    public double getRealNumber() {
        return realNumber;
    }

    /**
     * Gets the imaginary number.
     * @return the imaginary number
     */
    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    /**
     * Gets the sum between this complex number and one given as a parameter.
     * @param c2 the given complex number
     * @return a new complex number
     */
    public Complex sum(Complex c2){
        return new Complex(this.realNumber+c2.realNumber, this.imaginaryNumber+c2.imaginaryNumber);
    }

    /**
     * Gets the subtraction between this complex number and one given as a parameter.
     * @param c2 the given complex number
     * @return a new complex number
     */
    public Complex subtraction(Complex c2){
        return new Complex(this.realNumber-c2.realNumber, this.imaginaryNumber-c2.imaginaryNumber);
    }

    /**
     * Gets the way a complex number is displayed.
     * @return the way a complex number is displayed
     */
    @Override
    public String toString() {
        return String.format("%.1f + i * %.1f", getRealNumber(), getImaginaryNumber());
    }
}
