import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Buttons extends Application {
	
	private Image img1, img2;
	
	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		
		img1 = new Image("./mickey.png");
		img2 = new Image("./minnie.jpg");

		PhotoChanger listener = new PhotoChanger();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageView img  = getImage();
				img.setFitWidth(100);
				img.setFitHeight(100);
				Button b = new Button();
				b.setGraphic(img);
				b.setPrefSize(img.getFitWidth(), img.getFitHeight());
				b.setOnAction(listener); 
				root.add(b, i, j);
			}
		}
			
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	private ImageView getImage(){
		int x = new Random().nextInt(100);
		if(x<50)
			return new ImageView(img1);
		return new ImageView(img2);
		
	}
	private class PhotoChanger implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Button bf = (Button)e.getSource();
			ImageView theView= (ImageView)bf.getGraphic();
			Image img = theView.getImage();
			if(img == img1)
				theView.setImage(img2);
			else 
				theView.setImage(img1);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
