/**
 * The Circle class represents a circle shape defined by its position and radius.
 * It extends the Oval class and provides an implementation for returning a string representation of the circle.
 */
public class Circle extends Oval {

    /**
     * Constructs a Circle object with the specified position and radius.
     *
     * @param x the x coordinate of the circle
     * @param y the y coordinate of the circle
     * @param r the radius of the circle
     */
    public Circle(int x, int y, int r) {
        super(x, y, r, r);
    }

    /**
     * Returns a string representation of the circle, including its position, radius, and area.
     *
     * @return a string representation of the circle
     */
    @Override
    public String toString() {
        return String.format("Circle: [x:%d, y:%d, r:%d, area:%.2f]",
                getX(), getY(), getA(), getArea());
    }
}
