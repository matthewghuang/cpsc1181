public class Rectangle extends GeometricShape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public String toString() {
        return String.format("Rectangle: [x:%d, y:%d, width:%d, height:%d, area:%.2f]", getX(), getY(), width, height, getArea());
    }
}