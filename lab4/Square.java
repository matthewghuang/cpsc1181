public class Square extends Rectangle {
    public Square(int x, int y, int length) {
        super(x, y, length, length);
    }

    @Override
    public String toString() {
        return String.format("Square: [x:%d, y:%d, length:%d, area:%.2f]", getX(), getY(), getWidth(), getArea());
    }
}