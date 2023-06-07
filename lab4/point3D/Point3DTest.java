import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Point3DTest {
    private Point3D p3d;

    public Point3DTest() {
        p3d = new Point3D(1, 1, 1);
    }

    @Test
    void getZ() {
        assertEquals(1, p3d.getZ());
    }

    @Test
    void setZ() {
        p3d.setZ(3.5);
        assertEquals(3.5, p3d.getZ());
    }

    @Test
    void move() {
        p3d.move(32.3, 84.5, 29.2);
        assertEquals(32.3, p3d.getX());
        assertEquals(84.5, p3d.getY());
        assertEquals(29.2, p3d.getZ());
    }
}