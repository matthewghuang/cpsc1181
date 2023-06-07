/**
 * The Rectangle class represents a rectangular shape defined by its position, width, and height.
 * It extends the abstract class GeometricShape and provides implementations for calculating the area
 * and returning a string representation of the rectangle.
 */
public class Rectangle extends GeometricShape {

    private int width;
    private int height;

    /**
     * Constructs a Rectangle object with the specified position, width, and height.
     *
     * @param x      the x coordinate of the rectangle
     * @param y      the y coordinate of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    public double getArea() {
        return width * height;
    }

    /**
     * Returns a string representation of the rectangle, including its position, width, height, and area.
     *
     * @return a string representation of the rectangle
     */
    public String toString() {
        return String.format("Rectangle: [x:%d, y:%d, width:%d, height:%d, area:%.2f]",
                getX(), getY(), width, height, getArea());
    }
}
