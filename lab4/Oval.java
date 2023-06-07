/**
 * The Oval class represents an oval shape defined by its position and semi-major and semi-minor axes.
 * It extends the abstract class GeometricShape and provides implementations for calculating the area
 * and returning a string representation of the oval.
 */
public class Oval extends GeometricShape {

    private int a;
    private int b;

    /**
     * Constructs an Oval object with the specified position, semi-major axis (a), and semi-minor axis (b).
     *
     * @param x the x coordinate of the oval
     * @param y the y coordinate of the oval
     * @param a the semi-major axis of the oval
     * @param b the semi-minor axis of the oval
     */
    public Oval(int x, int y, int a, int b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    /**
     * Returns the semi-major axis of the oval.
     *
     * @return the semi-major axis of the oval
     */
    public int getA() {
        return a;
    }

    /**
     * Returns the semi-minor axis of the oval.
     *
     * @return the semi-minor axis of the oval
     */
    public int getB() {
        return b;
    }

    /**
     * Calculates and returns the area of the oval.
     *
     * @return the area of the oval
     */
    public double getArea() {
        return a * b * 3.14;
    }

    /**
     * Returns a string representation of the oval, including its position, semi-major axis, semi-minor axis, and area.
     *
     * @return a string representation of the oval
     */
    public String toString() {
        return String.format("Oval: [x:%d, y:%d, a:%d, b:%d, area:%.2f]",
                getX(), getY(), a, b, getArea());
    }
}
