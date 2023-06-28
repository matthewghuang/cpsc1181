import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Lab7 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        ControlsPane controls = new ControlsPane();
        GraphicsPane graphics = new GraphicsPane();

        root.setLeft(controls);
        root.setCenter(graphics);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}

class ControlsPane extends Pane {
    public ControlsPane() {
        super();
        setPrefSize(200, 600);
    }
}

class GraphicsPane extends Pane {
    Tree tree;
    Rainbow rainbow;
    SmileySun smile;

    public GraphicsPane() {
        super();

        setPrefSize(600, 600);
        Rectangle clip = new Rectangle(0, 0, 600, 600);
        setClip(clip);

        Rectangle grass = new Rectangle(0, 500, 600, 100);
        grass.setFill(Color.GREEN);

        
        rainbow = new Rainbow(250, 650, 400, 20);
        tree = new Tree(300, 550);
        smile = new SmileySun(400, 100);

        getChildren().addAll(grass, rainbow, tree, smile);
    }

    public void setRainbowVisible(boolean visible) {
        rainbow.setVisible(visible);
    }

    public void setSmileVisible(boolean visible) {
        smile.setVisible(visible);
    }
}

class Tree extends Group {
    private final int WTRUNK = 20;
    private final int HTRUNK = 300;
    private final int WLEAVES = 40;
    private final int HLEAVES = 60;

    public Tree(int x, int y) {
        super();
        Rectangle trunk = new Rectangle(x - WTRUNK / 2, y - HTRUNK, WTRUNK, HTRUNK);
        trunk.setFill(Color.SADDLEBROWN);

        Ellipse leaves = new Ellipse(x, y - HTRUNK, WLEAVES, HLEAVES);
        leaves.setFill(Color.rgb(30, 120, 80));
        getChildren().addAll(trunk, leaves);
    }
}

class Rainbow extends Group {
    private static int bandCount = 0;

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
    
    class Band extends Circle {
        public Band(int x, int y, int radius, int thickness, Color color) {
            super(x, y, radius + (bandCount++ * thickness));
            setFill(null);
            setStroke(color);
            setStrokeWidth(thickness);
        }
    }
}

class SmileySun extends Group {
    private final int SUN_RADIUS = 100;
    private final double EYE_BALL_SIZE = 0.3;
    private final double SMILE_SIZE = 0.5;

    public SmileySun(int x, int y) {
        super();

        Circle sun = new Circle(x, y, SUN_RADIUS);
        sun.setFill(Color.YELLOW);
        Eye eye = new Eye(x, y);

        double smileRad = SUN_RADIUS * SMILE_SIZE;
        Circle smile = new Circle(x, y + smileRad * 0.5, smileRad);
        smile.setFill(Color.WHITE);

        getChildren().addAll(sun, eye, smile);
    }

    class Eye extends Group {
        public Eye(int x, int y) {
            super();

            double radX = SUN_RADIUS * EYE_BALL_SIZE;
            double radY = SUN_RADIUS * EYE_BALL_SIZE * 0.5;
            double cx = x;
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