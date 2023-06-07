/**
 * The Square class represents a square shape defined by its position and side length.
 * It extends the Rectangle class and provides an implementation for returning a string representation of the square.
 */
public class Square extends Rectangle {

    /**
     * Constructs a Square object with the specified position and side length.
     *
     * @param x      the x coordinate of the square
     * @param y      the y coordinate of the square
     * @param length the side length of the square
     */
    public Square(int x, int y, int length) {
        super(x, y, length, length);
    }

    /**
     * Returns a string representation of the square, including its position, side length, and area.
     *
     * @return a string representation of the square
     */
    @Override
    public String toString() {
        return String.format("Square: [x:%d, y:%d, length:%d, area:%.2f]",
                getX(), getY(), getWidth(), getArea());
    }
}
