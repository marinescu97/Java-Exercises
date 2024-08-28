package Objects;

import Interfaces.Round;

/**
 * Represents a circle.
 * It implements the {@link Round} interface.
 */
public class Circle implements Round {
    /**
     * The radius of the circle.
     */
    private int radius;

    /**
     * Creates a new circle object.
     * @param radius the radius of the circle
     */
    Circle(int radius){
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     * @return the radius of the circle
     */
    public int getRadius(){
        return this.radius;
    }

    /**
     * Sets the radius of the circle.
     * @param val the radius of the circle
     */
    public void setRadius(int val){
        this.radius = val;
    }

    /**
     * Gets the area of the circle.
     * @return the area of the circle
     */
    public double getArea(){
        return round(Math.PI*Math.pow(this.radius,2), 2);
    }

    /**
     * Gets the circumference of the circle.
     * @return the circumference of the circle
     */
    public double getCircumference(){
        return round(2*radius*Math.PI, 2);
    }
}
