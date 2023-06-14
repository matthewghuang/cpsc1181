import java.awt.Rectangle;
import java.util.*;

public class SortDemo {
    public static void main(String[] args) {
        // yo this is so ugly don't make us do this again!!!
        class RectangleComparator implements Comparator<Rectangle> {

            /**
            * Compares two Rectangle objects.
            * @param r1 the first rectangle
            * @param r2 the second rectangle
            * @return 1 if the area of the first rectangle is larger than the area of the second rectangle,
            *         -1 if the area of the first rectangle is smaller than the area of the second rectangle,
            *         or 0 if the two rectangles have the same area
            */
            public int compare(Rectangle r1, Rectangle r2) {
                double area1 = r1.getWidth() * r1.getHeight();
                double area2 = r2.getWidth() * r2.getHeight();

                if (area1 > area2) {
                    return 1;
                } else if (area1 < area2) {
                    return -1;
                }

                return 0;
            }
        }

        ArrayList<Rectangle> list = new ArrayList<Rectangle>();

        Rectangle rect1 = new Rectangle(5, 10, 20, 30);
        Rectangle rect2 = new Rectangle(10, 20, 30, 15);
        Rectangle rect3 = new Rectangle(20, 30, 45, 10);

        list.add(rect1);
        list.add(rect2);
        list.add(rect3);

        Comparator<Rectangle> comparator = new RectangleComparator();
        Collections.sort(list, comparator);

        // Print out the sorted list
        for (int i = 0; i < list.size(); i++) {
            Rectangle r = list.get(i);
            System.out.println(r.getWidth() + " " + r.getHeight());
        }
    }
}

class RectangleComparator implements Comparator<Rectangle> {

    /**
     * Compares two Rectangle objects.
     * @param r1 the first rectangle
     * @param r2 the second rectangle
     * @return 1 if the area of the first rectangle is larger than the area of the second rectangle,
     *         -1 if the area of the first rectangle is smaller than the area of the second rectangle,
     *         or 0 if the two rectangles have the same area
     */
    public int compare(Rectangle r1, Rectangle r2) {
        double area1 = r1.getWidth() * r1.getHeight();
        double area2 = r2.getWidth() * r2.getHeight();

        if (area1 > area2) {
            return 1;
        } else if (area1 < area2) {
            return -1;
        }

        return 0;
    }
}

