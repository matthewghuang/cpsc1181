import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.EventType;

public class Lab8 extends Application {
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(500, 500);

        CircleDrawer circleDrawer = new CircleDrawer(500, 500);
        root.getChildren().add(circleDrawer);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class CircleDrawer extends Pane {
    Group circles;
    DynamicCircle currentCircle;
    boolean drawing = false;

    public CircleDrawer(int width, int height) {
        super();

        setPrefSize(width, height);

        CircleDrawerHandler handler = new CircleDrawerHandler();

        setOnMouseClicked(handler);
        setOnMouseMoved(handler);

        circles = new Group();

        getChildren().add(circles);
    }

    class CircleDrawerHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();

            if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                if (!drawing) {
                    // make a new circle
                    currentCircle = new DynamicCircle(sceneX, sceneY);
                    // add it to the group
                    circles.getChildren().add(currentCircle);
                    drawing = true;
                } else if (drawing) {
                    // second click
                    currentCircle.freeze();
                    drawing = false;
                }
            } else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
                if (drawing) {
                    currentCircle.resize(sceneX, sceneY);
                }
            }
        }
    }

    class DynamicCircle extends Group {
        double x;
        double y;
        Circle c;
        Line l;

        public DynamicCircle(double centerX, double centerY) {
            super();

            x = centerX;
            y = centerY;

            c = new Circle(x, y, 0);
            l = new Line(x, y, x, y);

            c.setFill(null);
            c.setStroke(Color.RED);
            l.setStroke(Color.PINK);

            getChildren().addAll(c, l);
        }

        public void resize(double curX, double curY) {
            double dist = Math.sqrt(Math.pow(curX - x, 2) + Math.pow(curY - y, 2));
            c.setRadius(dist);
            l.setEndX(curX);
            l.setEndY(curY);
        }

        public void freeze() {
            c.setStroke(Color.BLUE);
            l.setVisible(false);
        }
    }
}