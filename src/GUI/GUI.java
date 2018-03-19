package GUI;

import Logic.Main;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent() {

        Pane root = new Pane();
        root.setPrefSize(600,600);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setTranslateX(50);
        choiceBox.setTranslateY(25);
        choiceBox.getItems().add("square frees");
        choiceBox.getItems().add("cube time square frees");
        choiceBox.setValue("square frees");

        root.getChildren().add(choiceBox);

        changeFieldsDependingOnSetting(choiceBox.getValue(),root, choiceBox);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldvalue, newValue) -> changeFieldsDependingOnSetting(newValue,root, choiceBox));
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

    private void removeFieldsFromScene (Pane root, ChoiceBox<String> box){

        root.getChildren().clear();
        root.getChildren().add(box);
    }

    private void changeFieldsDependingOnSetting(String value, Pane root, ChoiceBox<String> box){

        Main main = new Main();

        if (value.equals("square frees")){
            removeFieldsFromScene(root, box);
            setLockerStates(root,main.squarefrees());
        }
        if (value.equals("cube time square frees")){
            removeFieldsFromScene(root, box);
            setLockerStates(root, main.cubetimesquarefrees());
        }
    }

    private void setLockerStates(Pane root, ArrayList<Long> students){
        ArrayList<Field> fields = new ArrayList<>(createGrid(root, students));
        int row = 100;
        for (long student: students){

            for (int j = row; j < row +100; j++){
                fields.get(j).setFill(fields.get(j-100).getFill());
            }

            for (int i= (int)  student -1 + row; i < row + 100; i += student){
                fields.get(i).changeFill();
            }

            row += 100;
        }
    }

    private ArrayList<Field> createGrid(Pane root, ArrayList<Long> students){

        ArrayList<Field> fields = new ArrayList<>();
        for (int i = 0; i < (students.size()+1) * 100; i++) {
            fields.add(new Field());
        }

        int i = 0;

        for (int j= 0; j< fields.size()/100; j++) {
            for (int k = i;k < i +100; k++) {
                Field field = fields.get(k);
                field.setTranslateX((field.getLenght() * (k % 100)) + 50);
                field.setTranslateY((field.getLenght() * (k / 100)) + 70);
                root.getChildren().add(field);
            }

            i += 100;
        }

        return fields;
    }
}

