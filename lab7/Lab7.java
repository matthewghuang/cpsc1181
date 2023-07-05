import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

/**
 * The Lab7 class is the main class for the application.
 */
public class Lab7 extends Application {
    /**
     * The main method of the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method of the JavaFX application.
     *
     * @param stage The primary stage for the application.
     */
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        GraphicsPane graphics = new GraphicsPane();
        ControlsVBox controls = new ControlsVBox(graphics);

        root.setLeft(controls);
        root.setCenter(graphics);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
