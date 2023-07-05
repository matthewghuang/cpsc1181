import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * ControlsVBox is a custom VBox container that provides various controls for manipulating a GraphicsPane object.
 */
public class ControlsVBox extends VBox {
    GraphicsPane graphics;

    /**
     * Constructs a ControlsVBox object with the specified GraphicsPane.
     *
     * @param graphicsPane The GraphicsPane object to manipulate.
     */
    public ControlsVBox(GraphicsPane graphicsPane) {
        super();
        setPrefSize(200, 600);
        setPadding(new Insets(5));

        graphics = graphicsPane;

        BackgroundChanger checkboxes = new BackgroundChanger(graphics);
        RotationChanger rotationRadios = new RotationChanger(graphics);
        rotationRadios.setPadding(new Insets(50, 0, 50, 0));
        CaptionChanger captionChanger = new CaptionChanger(graphics);

        getChildren().addAll(checkboxes, rotationRadios, captionChanger);
    }

    /**
     * BackgroundChanger is an inner class that represents a VBox containing background-related controls.
     */
    class BackgroundChanger extends VBox {
        GraphicsPane graphics;
        CheckBox rainbowVisible;
        CheckBox smileVisible;

        /**
         * Constructs a BackgroundChanger object with the specified GraphicsPane.
         *
         * @param graphics The GraphicsPane object to manipulate.
         */
        BackgroundChanger(GraphicsPane graphics) {
            super();
            setAlignment(Pos.CENTER);

            this.graphics = graphics;

            BackgroundCheckboxesHandler handler = new BackgroundCheckboxesHandler();

            Text header = new Text("Background");

            rainbowVisible = new CheckBox("rainbow");
            rainbowVisible.setPadding(new Insets(0, 5, 0, 0));
            smileVisible = new CheckBox("smile");

            rainbowVisible.setOnAction(handler);
            smileVisible.setOnAction(handler);

            HBox checkboxes = new HBox();
            checkboxes.setPadding(new Insets(0, 0, 5, 0));
            checkboxes.getChildren().addAll(rainbowVisible, smileVisible);

            getChildren().addAll(header, checkboxes);
        }

        /**
         * BackgroundCheckboxesHandler is an inner class that handles checkbox events for the BackgroundChanger.
         */
        class BackgroundCheckboxesHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                graphics.setRainbowVisible(rainbowVisible.isSelected());
                graphics.setSmileVisible(smileVisible.isSelected());
            }
        }
    }

    /**
     * RotationChanger is an inner class that represents a VBox containing rotation-related controls.
     */
    class RotationChanger extends VBox {
        GraphicsPane graphics;
        RotationEventHandler handler;
        ToggleGroup toggleGroup;
        RadioButton deg0;
        RadioButton deg90;
        RadioButton deg180;
        RadioButton deg270;

        /**
         * Constructs a RotationChanger object with the specified GraphicsPane.
         *
         * @param graphics The GraphicsPane object to manipulate.
         */
        RotationChanger(GraphicsPane graphics) {
            super();
            this.graphics = graphics;
            handler = new RotationEventHandler();
            toggleGroup = new ToggleGroup();

            deg0 = new RadioButton("0 degrees");
            deg90 = new RadioButton("90 degrees");
            deg180 = new RadioButton("180 degrees");
            deg270 = new RadioButton("270 degrees");

            deg0.setToggleGroup(toggleGroup);
            deg90.setToggleGroup(toggleGroup);
            deg180.setToggleGroup(toggleGroup);
            deg270.setToggleGroup(toggleGroup);

            deg0.setOnAction(handler);
            deg90.setOnAction(handler);
            deg180.setOnAction(handler);
            deg270.setOnAction(handler);

            toggleGroup.selectToggle(deg0);

            getChildren().addAll(deg0, deg90, deg180, deg270);
        }

        /**
         * RotationEventHandler is an inner class that handles radio button events for the RotationChanger.
         */
        class RotationEventHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                if (e.getSource() == deg0) {
                    graphics.setTreeRotate(0);
                } else if (e.getSource() == deg90) {
                    graphics.setTreeRotate(90);
                } else if (e.getSource() == deg180) {
                    graphics.setTreeRotate(180);
                } else if (e.getSource() == deg270) {
                    graphics.setTreeRotate(270);
                }
            }
        }
    }

    /**
     * CaptionChanger is an inner class that represents a VBox containing caption-related controls.
     */
    class CaptionChanger extends VBox {
        GraphicsPane graphics;

        TextField captionText;
        Button changeCaptionButton;

        /**
         * Constructs a CaptionChanger object with the specified GraphicsPane.
         *
         * @param graphicsPane The GraphicsPane object to manipulate.
         */
        CaptionChanger(GraphicsPane graphicsPane) {
            super();
            setAlignment(Pos.CENTER);

            graphics = graphicsPane;

            Text header = new Text("Caption");
            captionText = new TextField();
            changeCaptionButton = new Button("Change text");

            changeCaptionButton.setOnAction(new CaptionChangerHandler());

            getChildren().addAll(header, captionText, changeCaptionButton);
        }

        /**
         * CaptionChangerHandler is an inner class that handles button events for the CaptionChanger.
         */
        class CaptionChangerHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                graphics.setCaption(captionText.getText());
            }
        }
    }
}
