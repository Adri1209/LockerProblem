package GUI;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Field extends StackPane {

    private Rectangle rectangle;

    public Field()  {
        rectangle = new Rectangle(5, 5);
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.GREY);

        getChildren().add(rectangle);
    }

    public void setFill (Color color){

        rectangle.setFill(color);
    }

    public double getLenght(){
        return  rectangle.getHeight();
    }
}
