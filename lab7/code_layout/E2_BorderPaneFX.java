import javafx.application.Application;
import javafx.stage.Stage;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class E2_BorderPaneFX extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		Button top = new Button("top");
		Button bottom = new Button("bottom");
		Button left = new Button("left");
		Button center = new Button("center");
		Button right = new Button("right");

		BorderPane mainPane = new BorderPane();
		mainPane.setTop(top);
		mainPane.setBottom(bottom);
		mainPane.setLeft(left);
		mainPane.setCenter(center);
		mainPane.setRight(right);

		mainPane.setAlignment(top, Pos.TOP_CENTER);
		mainPane.setAlignment(bottom, Pos.BOTTOM_RIGHT);
		mainPane.setPadding(new Insets(10));

		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("FX BorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	

}