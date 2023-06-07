public class Circle extends Oval {
    public Circle(int x, int y, int r) {
        super(x, y, r, r);
    }

    @Override
    public String toString() {
        return String.format("Circle: [x:%d, y:%d, r:%d, area:%.2f]", getX(), getY(), getA(), getArea());
    }
}