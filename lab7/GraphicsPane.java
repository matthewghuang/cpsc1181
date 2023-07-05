import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Group;

/**
 * GraphicsPane is a custom Pane that represents a graphics pane for displaying various graphical elements.
 */
public class GraphicsPane extends Pane {
    Tree tree;
    Rainbow rainbow;
    SmileySun smile;
    Text caption;

    /**
     * Constructs a GraphicsPane object.
     */
    public GraphicsPane() {
        super();

        setPrefSize(600, 600);
        Rectangle clip = new Rectangle(0, 0, 600, 600);
        setClip(clip);

        Rectangle grass = new Rectangle(0, 500, 600, 100);
        grass.setFill(Color.GREEN);

        rainbow = new Rainbow(250, 650, 400, 20);
        tree = new Tree(300, 550);
        smile = new SmileySun(500, 100);

        Font captionFont = new Font("Comic Sans MS", 36);

        caption = new Text(200, 550, "");
        caption.setFill(Color.YELLOW);
        caption.setFont(captionFont);

        getChildren().addAll(grass, rainbow, tree, smile, caption);

        setRainbowVisible(false);
        setSmileVisible(false);
    }

    /**
     * Sets the visibility of the rainbow.
     *
     * @param visible true to make the rainbow visible, false otherwise.
     */
    public void setRainbowVisible(boolean visible) {
        rainbow.setVisible(visible);
    }

    /**
     * Sets the visibility of the smiley sun.
     *
     * @param visible true to make the smiley sun visible, false otherwise.
     */
    public void setSmileVisible(boolean visible) {
        smile.setVisible(visible);
    }

    /**
     * Sets the rotation angle of the tree.
     *
     * @param degrees The rotation angle in degrees.
     */
    public void setTreeRotate(double degrees) {
        tree.setRotate(degrees);
    }

    /**
     * Sets the caption text.
     *
     * @param captionText The text to set as the caption.
     */
    public void setCaption(String captionText) {
        caption.setText(captionText);
    }
}

/**
 * Tree is a custom Group that represents a tree graphical element.
 */
class Tree extends Group {
    private final int WTRUNK = 20;
    private final int HTRUNK = 300;
    private final int WLEAVES = 40;
    private final int HLEAVES = 60;

    /**
     * Constructs a Tree object at the specified coordinates.
     *
     * @param x The x-coordinate of the tree.
     * @param y The y-coordinate of the tree.
     */
    public Tree(int x, int y) {
        super();
        Rectangle trunk = new Rectangle(x - WTRUNK / 2, y - HTRUNK, WTRUNK, HTRUNK);
        trunk.setFill(Color.SADDLEBROWN);

        Ellipse leaves = new Ellipse(x, y - HTRUNK, WLEAVES, HLEAVES);
        leaves.setFill(Color.rgb(30, 120, 80));
        getChildren().addAll(trunk, leaves);
    }
}

/**
 * Rainbow is a custom Group that represents a rainbow graphical element.
 */
class Rainbow extends Group {
    private static int bandCount = 0;

    /**
     * Constructs a Rainbow object at the specified coordinates with the given radius and band thickness.
     *
     * @param x              The x-coordinate of the rainbow.
     * @param y              The y-coordinate of the rainbow.
     * @param radius         The radius of the rainbow.
     * @param bandThickness  The thickness of each band in the rainbow.
     */


    public Rainbow(int x, int y, int radius, int bandThickness) {
        super();

        Band violet = new Band(x, y, radius, bandThickness, Color.rgb(148, 0, 211));
        Band indigo = new Band(x, y, radius, bandThickness, Color.rgb(75, 0, 130));
        Band blue = new Band(x, y, radius, bandThickness, Color.rgb(0, 0, 255));
        Band green = new Band(x, y, radius, bandThickness, Color.rgb(0, 255, 0));
        Band yellow = new Band(x, y, radius, bandThickness, Color.rgb(255, 255, 0));
        Band orange = new Band(x, y, radius, bandThickness, Color.rgb(255, 127, 0));
        Band red = new Band(x, y, radius, bandThickness, Color.rgb(255, 0, 0));

        getChildren().addAll(violet, indigo, blue, green, yellow, orange, red);
    }

    /**
     * Band is a custom Circle that represents a band in the rainbow.
     */
    class Band extends Circle {
        /**
         * Constructs a Band object at the specified coordinates with the given radius, thickness, and color.
         *
         * @param x          The x-coordinate of the band.
         * @param y          The y-coordinate of the band.
         * @param radius     The radius of the band.
         * @param thickness  The thickness of the band.
         * @param color      The color of the band.
         */
        public Band(int x, int y, int radius, int thickness, Color color) {
            super(x, y, radius + (bandCount++ * thickness));
            setFill(null);
            setStroke(color);
            setStrokeWidth(thickness);
        }
    }
}

/**
 * SmileySun is a custom Group that represents a smiley sun graphical element.
 */
class SmileySun extends Group {
    private final int SUN_RADIUS = 100;
    private final double EYE_BALL_SIZE = 0.3;
    private final double SMILE_SIZE = 0.5;

    /**
     * Constructs a SmileySun object at the specified coordinates.
     *
     * @param x The x-coordinate of the smiley sun.
     * @param y The y-coordinate of the smiley sun.
     */
    public SmileySun(int x, int y) {
        super();

        Circle sun = new Circle(x, y, SUN_RADIUS);
        sun.setFill(Color.YELLOW);
        Eye eye = new Eye(x, y);

        double smileRad = SUN_RADIUS * SMILE_SIZE;
        Circle smile = new Circle(x, y + smileRad * 0.5, smileRad);
        smile.setFill(Color.WHITE);
        // make a half circle using clip
        Rectangle clip = new Rectangle(x - smileRad, y + smileRad * 0.5, smileRad * 2, smileRad);
        smile.setClip(clip);

        getChildren().addAll(sun, eye, smile);
    }

    /**
     * Eye is a custom Group that represents an eye of the smiley sun.
     */
    class Eye extends Group {
        /**
         * Constructs an Eye object at the specified coordinates.
         *
         * @param x The x-coordinate of the eye.
         * @param y The y-coordinate of the eye.
         */
        public Eye(int x, int y) {
            super();

            double radX = SUN_RADIUS * EYE_BALL_SIZE;
            double radY = SUN_RADIUS * EYE_BALL_SIZE * 0.5;
            double cx = x

;
            double cy = y - SUN_RADIUS + (radY * 4);

            Ellipse ellipse = new Ellipse(cx, cy, radX, radY);
            ellipse.setFill(Color.WHITE);

            Circle iris = new Circle(cx, cy, radY * 0.75);
            iris.setFill(Color.AQUA);

            Circle pupil = new Circle(cx, cy, radY * 0.4);
            pupil.setFill(Color.BLACK);

            getChildren().addAll(ellipse, iris, pupil);
        }
    }
}