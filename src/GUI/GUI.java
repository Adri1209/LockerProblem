package GUI;

import Logic.Main;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    private ArrayList<Long> allValues;
    private ArrayList<Integer> resultValues;
    private Tab textual;
    public static void main(String[] args) {
        launch(args);
    }

    private Parent createGraphicalContent() {

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
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> changeFieldsDependingOnSetting(newValue,root, choiceBox));
        return root;
    }

    private Parent createTextualContent (){

        Pane textTab = new Pane();
        textTab.setPrefSize(600,600);

        Text Text1 = new Text("students sent");
        Text1.setTranslateX(20);
        Text1.setTranslateY(63);

        TextArea Text2 = new TextArea(allValues.toString().replace("[","").replace("]","").trim());
        Text2.setTranslateX(20);
        Text2.setTranslateY(100);
        Text2.setEditable(false);
        Text2.setWrapText(true);

        Text Text3 = new Text("open lockers");
        Text3.setTranslateX(20);
        Text3.setTranslateY(306);

        TextArea Text4 = new TextArea(resultValues.toString().replace("[","").replace("]","").trim());
        Text4.setTranslateX(20);
        Text4.setTranslateY(340);
        Text4.setEditable(false);
        Text4.setWrapText(true);

        textTab.getChildren().addAll(Text1,Text2,Text3,Text4);
        return textTab;
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Locker Problem");

        TabPane tabs = new TabPane();
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab graphical = new Tab("graphical");
        textual = new Tab("textual");
        graphical.setContent(createGraphicalContent());

        tabs.getTabs().addAll(graphical, textual);

        Scene scene = new Scene(tabs);
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
            allValues = main.squarefrees();
            setLockerStates(root, allValues);
        }
        if (value.equals("cube time square frees")){
            removeFieldsFromScene(root, box);
            allValues = main.cubetimesquarefrees();

            allValues.remove(32l);
            allValues.remove(72l);
            allValues.remove(96l);
            setLockerStates(root, allValues);
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

        resultValues = new ArrayList<>();
        for (int k = fields.size()-100; k < fields.size(); k++){
            if (fields.get(k).getFill() == Color.WHITE){
                resultValues.add(k-(fields.size()-101));
            }
        }

        textual.setContent(createTextualContent());
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

