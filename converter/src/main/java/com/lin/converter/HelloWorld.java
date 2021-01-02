package com.lin.converter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    private ConverterService converterService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 1, 1));


        Text scenetitle = new Text("Convert DB stored data to Json format");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label hexString = new Label("Hexadecimal in DB:");
        grid.add(hexString, 0, 1);
        TextArea hexTextArea = new TextArea();
        hexTextArea.setPrefWidth(1600);
        hexTextArea.setWrapText(true);
        grid.add(hexTextArea, 1, 1);


        Button btn = new Button("Convert");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 2);

        Label jsonLabel = new Label("Converted Json:");
        grid.add(jsonLabel, 0, 3);
        TextArea jsonTextArea = new TextArea();
        grid.add(jsonTextArea, 1, 3);


        Text errorMsg = new Text();
        errorMsg.setFill(Color.RED);
        grid.add(errorMsg, 0, 4, 2, 1);

        converterService = new ConverterService();
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                errorMsg.setText("");
                jsonTextArea.setText("");
                try {
                    jsonTextArea.setText(converterService.deserialize(hexTextArea.getText()));
                } catch (Exception ex) {
                    errorMsg.setText(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(grid, 1800, 275);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
