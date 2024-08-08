package Objects;

/**
 * This class represents a rational number object.
 */
public class Rational {
    /**
     * The numerator of the rational number.
     */
    private int numerator;
    /**
     * The denominator of the rational number.
     */
    private int denominator;

    /**
     * Constructs a rational number and brings it to the lowest form.
     * @param numerator the numerator of the rational number
     * @param denominator the denominator of the rational number
     */
    Rational(int numerator, int denominator){
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    /**
     * Gets the greatest common divisor of the two given numbers.
     * @param u the first number
     * @param v the second number
     * @return the greatest common divisor of the two given numbers
     */
    public int gcd(int u, int v){
        if (v==0){
            return u;
        } else {
            return gcd(v, u%v);
        }
    }

    /**
     * Gets the least common multiple of the two given numbers.
     * @param a the first number
     * @param b the second number
     * @return the least common multiple of the two given numbers
     */
    public int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    /**
     * Displays the rational number.
     */
    public void display(){
        System.out.println(this.numerator + "/" + this.denominator);
    }

    /**
     * Performs the addition between this rational number and a given one.
     * It also brings the result to its lowest form.
     * @param r the given rational number
     * @return a new rational number as the result of the addition
     */
    public Rational addition(Rational r){
        if (this.denominator == r.denominator){
            return new Rational(this.numerator+r.numerator, denominator);
        } else {
            int lcm = lcm(this.denominator, r.denominator);
            if (this.denominator==lcm){
                r.numerator*=lcm/r.denominator;
                r.denominator=lcm;
                return addition(r);
            } else if (r.denominator==lcm) {
                this.numerator*=lcm/this.denominator;
                this.denominator=lcm;
                return addition(r);
            } else {
                r.numerator*=lcm/r.denominator;
                r.denominator=lcm;

                this.numerator*=lcm/this.denominator;
                this.denominator=lcm;
                return addition(r);
            }
        }
    }

    /**
     * Performs the subtraction between this rational number and a given one.
     * It also brings the result to its lowest form.
     * @param r the given rational number
     * @return a new rational number as a result of the subtraction
     */
    public Rational subtraction(Rational r){
        if (this.denominator==r.denominator){
            return new Rational(this.numerator-r.numerator,this.denominator);
        } else {
            int lcm = lcm(this.denominator, r.denominator);
            if (this.denominator==lcm){
                r.numerator*=lcm/r.denominator;
                r.denominator=lcm;
                return subtraction(r);
            } else if (r.denominator==lcm) {
                this.numerator*=lcm/this.denominator;
                this.denominator=lcm;
                return subtraction(r);
            } else {
                this.numerator*=lcm/this.denominator;
                this.denominator=lcm;

                r.numerator*=lcm/r.denominator;
                r.denominator=lcm;

                return subtraction(r);
            }
        }
    }

    /**
     * Performs the multiplication between this rational number and a given one.
     * @param r the given rational number
     * @return a new rational number as a result of multiplication
     */
    public Rational multiplication(Rational r){
        return new Rational(this.numerator*r.numerator, this.denominator*r.denominator);
    }

    /**
     * Performs the division between this rational number and a given one.
     * @param r the given rational number
     * @return a new rational number as a result of the division
     */
    public Rational division(Rational r){
        return new Rational(this.numerator*r.denominator, this.denominator*r.numerator);
    }

}
