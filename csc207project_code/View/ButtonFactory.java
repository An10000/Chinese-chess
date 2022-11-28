package View;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class ButtonFactory {

    public void ButtonFactory(AnchorPane anchorPane){
        Button red_chariot = new Button();
        red_chariot.setShape(new Circle(35));
        red_chariot.setMaxSize(70,70);
        red_chariot.setMinSize(70,70);
        Image chess = new Image("View/Graphics/chess.png",75,75,true,true);
        ImageView chessView = new ImageView(chess);
        red_chariot.setGraphic(chessView);
        AnchorPane.setTopAnchor(red_chariot, 15.0);
        AnchorPane.setLeftAnchor(red_chariot, 192.0);



    }

    private void null_buttons(){

    }


}
