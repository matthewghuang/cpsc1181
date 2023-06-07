import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Point2DTest {
    private Point2D p2d;

    public Point2DTest() {
        p2d = new Point2D(1, 1);
    }

    @Test
    void getX() {
        assertEquals(1, p2d.getX());
    }

    @Test
    void getY() {
        assertEquals(1, p2d.getY());
    }

    @Test
    void setX() {
        p2d.setX(2.5);
        assertEquals(2.5, p2d.getX());
    }

    @Test
    void setY() {
        p2d.setY(3.5);
        assertEquals(3.5, p2d.getY());
    }

    @Test
    void move() {
        p2d.move(32.3, 84.5);
        assertEquals(32.3, p2d.getX());
        assertEquals(84.5, p2d.getY());
    }
}