package GUI;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Field extends StackPane {

    private Rectangle rectangle;

    public Field()  {
        rectangle = new Rectangle(5, 5);
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.WHITE);

        getChildren().add(rectangle);
    }

    public void setStroke (Color color){

        rectangle.setStroke(color);
    }

    public void setFill (Color color){

        rectangle.setFill(color);
    }
}
