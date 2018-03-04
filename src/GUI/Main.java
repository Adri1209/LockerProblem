package GUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent() {

        Pane root = new Pane();
        root.setPrefSize(600,600);




        List<Field> fields = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            fields.add(new Field());
        }

        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            field.setTranslateX((5 * (i % 100)) + 50);
            field.setTranslateY((5 * (i / 100)) + 70);
            root.getChildren().add(field);
        }

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setTranslateX(50);
        choiceBox.setTranslateY(25);
        choiceBox.getItems().add("square frees");
        choiceBox.getItems().add("cube time square frees");
        choiceBox.setValue("square frees");

        root.getChildren().add(choiceBox);

        changeFieldsDependingOnSetting(choiceBox.getValue(),fields);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldvalue, newValue) -> changeFieldsDependingOnSetting(newValue,fields));

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Locker Problem");

        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void changeFieldsDependingOnSetting(String value, List<Field> fields){

        if (value.equals("square frees")){

            for (Field field: fields){
                field.setFill(Color.BLACK);
                field.setStroke(Color.WHITE);
            }
        }
        if (value.equals("cube time square frees")){
            for (Field field: fields){
                field.setFill(Color.WHITE);
                field.setStroke(Color.BLACK);
            }
        }
    }
}

