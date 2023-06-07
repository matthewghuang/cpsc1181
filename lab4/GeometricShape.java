/**
 * The abstract class GeometricShape represents a geometric shape with an x and y coordinate.
 * This class provides common functionality for geometric shapes, such as accessing the x and y coordinates,
 * calculating the area, and returning a string representation of the shape.
 */
public abstract class GeometricShape {
    
    private int x;
    private int y;
    
    /**
     * Constructs a GeometricShape object with the specified x and y coordinates.
     *
     * @param x the x coordinate of the shape
     * @param y the y coordinate of the shape
     */
    public GeometricShape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the x coordinate of the shape.
     *
     * @return the x coordinate of the shape
     */
    public int getX() {
        return x;
    }
    
    /**
     * Returns the y coordinate of the shape.
     *
     * @return the y coordinate of the shape
     */
    public int getY() {
        return y;
    }
    
    /**
     * Calculates and returns the area of the geometric shape.
     *
     * @return the area of the geometric shape
     */
    abstract public double getArea();
    
    /**
     * Returns a string representation of the geometric shape.
     *
     * @return a string representation of the geometric shape
     */
    abstract public String toString();
}


