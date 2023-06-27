import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.*;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import java.time.LocalDateTime;

/**
 * The Clock class represents a clock application that displays the current time.
 */
public class Clock extends Application {
    private Pane root;
    private Scene scene;
    private int hour;
    private int minute;
    private int second;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        LocalDateTime now = LocalDateTime.now();
        hour = now.getHour() % 12;
        minute = now.getMinute();
        second = now.getSecond();

        root = new Pane();
        root.setPrefSize(500, 500);
        scene = new Scene(root);
        stage.setScene(scene);

        addCircle();
        addHourMarkers();
        addMinuteMarkers();
        addHands();
        addText();
        addCenterDot();

        stage.setTitle("Lab: ClockFX");
        stage.show();
    }

    /**
     * Adds the outer circle of the clock.
     */
    private void addCircle() {
        Circle c = new Circle(250, 250, 450/2);
        c.setFill(null);
        c.setStroke(Color.GRAY);
        c.setStrokeWidth(5);
        root.getChildren().add(c);
    }

    /**
     * Adds the hour markers on the clock face.
     */
    private void addHourMarkers() {
        for (int i = 0; i < 12; i++) {
            double hourDeg = (360 * (i / 12.0));
            double angle = Math.toRadians(hourDeg - 90.0);
            double x = 250 + 180 * Math.cos(angle);
            double y = 250 + 180 * Math.sin(angle);
            double x2 = x + 30 * Math.cos(angle);
            double y2 = y + 30 * Math.sin(angle);
            Line l = new Line(x, y, x2, y2);

            if (i % 3 == 0) {
                l.setStrokeWidth(5);
            }

            root.getChildren().add(l);
        }
    }

    /**
     * Adds the minute markers on the clock face.
     */
    private void addMinuteMarkers() {
        for (int i = 0; i < 60; i++) {
            double hourDeg = (360 * (i / 60.0));
            double angle = Math.toRadians(hourDeg - 90.0);
            double x = 250 + 210 * Math.cos(angle);
            double y = 250 + 210 * Math.sin(angle);
            Circle c = new Circle(x, y, 4/2);

            if (i % 5 == 0) {
                continue;
            }

            root.getChildren().add(c);
        }
    }

    /**
     * Adds the clock hands to the clock face.
     */
    private void addHands() {
        new HourHand(root, hour, minute, second);
        new MinuteHand(root, minute, second);
        new SecondHand(root, second);
    }

    /**
     * Adds the text label to the clock face.
     */
    private void addText() {
        Font arial18 = new Font("Arial", 18);
        Text tmp = new Text(250, 100, "CPSC1181");
        tmp.setFont(arial18);

        Bounds bound = tmp.getBoundsInLocal();
        double width = bound.getWidth();

        Text t = new Text(250 - width / 2, 100, "CPSC1181");
        t.setFont(arial18);
        t.setStroke(Color.BROWN);

        root.getChildren().add(t);
    }

    /**
     * Adds a central dot to the clock face.
     */
    private void addCenterDot() {
        Circle c = new Circle(250, 250, 7d/2);
        c.setFill(Color.RED);
        root.getChildren().add(c);
    }
}

/**
 * The Hand class represents a clock hand.
 */
abstract class Hand {
    private Pane root;
    private int length;

    /**
     * Constructs a Hand object with the specified length and attaches it to the root pane.
     *
     * @param root   the root pane of the clock application
     * @param length the length of the clock hand
     */
    public Hand(Pane root, int length) {
        this.root = root;
        this.length = length;
    }

    /**
     * Draws the clock hand on the clock face.
     */
    void draw() {
        double x = 250;
        double y = 250;
        double angle = getAngle();
        double x2 = x + this.length * Math.cos(angle);
        double y2 = y + this.length * Math.sin(angle);
        Line line = new Line(x, y, x2, y2);
        format(line);
        root.getChildren().add(line);
    }

    /**
     * Formats the clock hand line with the specified style.
     *
     * @param line the line representing the clock hand
     */
    abstract void format(Line line);

    /**
     * Calculates the angle of the clock hand in radians.
     *
     * @return the angle of the clock hand in radians
     */
    abstract double getAngle();
}

/**
 * The HourHand class represents the hour hand of the clock.
 */
class HourHand extends Hand {
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructs an HourHand object with the specified parameters and draws it on the clock face.
     *
     * @param root   the root pane of the clock application
     * @param hour   the current hour
     * @param minute the current minute
     * @param second the current second
     */
    public HourHand(Pane root, int hour, int minute, int second) {
        super(root, 100);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.draw();
    }

    @Override
    void format(Line line) {
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(6);
    }

    @Override
    double getAngle() {
        double hourDeg = (360 * (hour / 12.0));
        double minDeg = (360 * (minute / 60.0)) / 60.0;
        double secDeg = (360 * (second / 60.0)) / 3600.0;
        return Math.toRadians(hourDeg + minDeg + secDeg - 90.0);
    }
}

/**
 * The MinuteHand class represents the minute hand of the clock.
 */
class MinuteHand extends Hand {
    private int minute;
    private int second;

    /**
     * Constructs a MinuteHand object with the specified parameters and draws it on the clock face.
     *
     * @param root   the root pane of the clock application
     * @param minute the current minute
     * @param second the current second
     */
    public MinuteHand(Pane root, int minute, int second) {
        super(root, 150);
        this.minute = minute;
        this.second = second;
        this.draw();
    }

    @Override
    void format(Line line) {
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(4);
    }

    @Override
    double getAngle() {
        double minDeg = (360 * (minute / 60.0));
        double secDeg = (360 * (second / 60.0)) / 60.0;
        return Math.toRadians(minDeg + secDeg - 90.0);
    }
}

/**
 * The SecondHand class represents the second hand of the clock.
 */
class SecondHand extends Hand {
    private int second;

    /**
     * Constructs a SecondHand object with the specified parameters and draws it on the clock face.
     *
     * @param root   the root pane of the clock application
     * @param second the current second
     */
    public SecondHand(Pane root, int second) {
        super(root, 200);
        this.second = second;
        this.draw();
    }

    @Override
    void format(Line line) {
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
    }

    @Override
    double getAngle() {
        double secDeg = (360 * (second / 60.0));
        return Math.toRadians(secDeg - 90.0);
    }
}