import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.ComboBox;

public class V3_TextAreaFX extends Application {
   private ComboBox<String> comboBox;
   private TextArea textArea;

   public void start(Stage stage) {
      BorderPane mainPanel = new BorderPane();
      VBox leftPanel= createLeftPanel();
      mainPanel.setLeft(leftPanel);
      VBox comboBox= createComboBox();
      mainPanel.setCenter(comboBox);


      Scene scene = new Scene(mainPanel);
      stage.setTitle("Text Area");
      stage.setScene(scene);
      stage.show();
   }
   private class ComboListener implements EventHandler<ActionEvent> {

      @Override
      public void handle(ActionEvent e) {
         // you can get the index of the selected item
         // int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
         // or just get the item
         String selectedItem = (String) comboBox.getSelectionModel().getSelectedItem();

         // you can append to the test
         // textArea.appendText(selectedItem); 
         // or insert in cursor location
         int caretPosition = textArea.getCaretPosition();
         textArea.insertText(caretPosition, selectedItem);

         
      }
      
   }
   

   private VBox createComboBox(){
      comboBox = new ComboBox<>();
      comboBox.setValue("Courses:");
      comboBox.getItems().add("CPSC1181");
      comboBox.getItems().add("CPSC1150");
      comboBox.getItems().add("CPSC1160");
      comboBox.setOnAction(new ComboListener());
    
      comboBox.setEditable(true);
      VBox vbox = new VBox();
      vbox.setSpacing(20);
      vbox.setPadding(new Insets(20, 20, 20, 20));
      vbox.getChildren().addAll(comboBox);
      return vbox;

   }

   private VBox createLeftPanel(){
      Label label = new Label("Notes");
      Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16);
      label.setFont(font);
      
      //Creating a pagination
      textArea = new TextArea();
      textArea.setPrefColumnCount(15);
      textArea.setPrefHeight(120);
      textArea.setPrefWidth(300);
      textArea.setFont(font);
      textArea.setWrapText(true);

      VBox vbox = new VBox();
      vbox.setSpacing(20);
      vbox.setPadding(new Insets(20, 20, 20, 20));
      vbox.getChildren().addAll(label, textArea);
      return vbox;
   }
   public static void main(String args[]){
      launch(args);
   }
}