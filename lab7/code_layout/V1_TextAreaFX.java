import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class V1_TextAreaFX extends Application {
   public void start(Stage stage) {
      BorderPane mainPanel = new BorderPane();
      VBox leftPanel= createLeftPanel();
      mainPanel.setLeft(leftPanel);
    
      Scene scene = new Scene(mainPanel);
      stage.setTitle("Text Area");
      stage.setScene(scene);
      stage.show();
   }
   private VBox createLeftPanel(){
      Label label = new Label("Notes");
      Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16);
      label.setFont(font);
      
      //Creating a pagination
      TextArea area = new TextArea();
      area.setPrefHeight(120);
      area.setPrefWidth(300);
      area.setFont(font);
      area.setWrapText(true);

      VBox vbox = new VBox();
      vbox.setSpacing(20);
      vbox.setPadding(new Insets(20, 20, 20, 20));
      vbox.getChildren().addAll(label, area);
      return vbox;
   }
   public static void main(String args[]){
      launch(args);
   }
}