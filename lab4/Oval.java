public class Oval extends GeometricShape {
    private int a;
    private int b;

    public Oval(int x, int y, int a, int b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public double getArea() {
        return a * b * 3.14;
    }

    public String toString() {
        return String.format("Oval: [x:%d, y:%d, a:%d, b:%d, area:%.2f]", getX(), getY(), a, b, getArea());
    }
}