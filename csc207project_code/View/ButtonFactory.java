package View;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.HashMap;

public class ButtonFactory {
    private AnchorPane anchorPane;
    private HashMap<Button,Double[]> buttonMap;
    private Button[] special;

    public ButtonFactory(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
        buttonMap = new HashMap<>();
        special = new Button[32];

        Image chess = new Image("View/Graphics/check.png",60,60,true,true);
        ImageView chessView = new ImageView(chess);
//        red_chariot.setGraphic(chessView);
        computeButtons();
    }

    private void computeButtons(){
        Double left = 195.5;
        Double top = 18.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Double[] array = new Double[2];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);
                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 75.0);

                if (i == 0) {
                    switch (j) {
                        case 0 -> special[0] = button;
                        case 1 -> special[1] = button;
                        case 2 -> special[2] = button;
                        case 3 -> special[3] = button;
                        case 4 -> special[4] = button;
                    }
                }
                else if (i == 2 && j == 1) special[9] = button;
                else if (i == 3) {
                    switch (j) {
                        case 0 -> special[11] = button;
                        case 2 -> special[12] = button;
                        case 4 -> special[13] = button;
                        default -> button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                    }
                }
                else {
                    button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                }

                array[0] = top + i * 74.0;
                array[1] = left + j * 75.0;
                buttonMap.put(button, array);
            }
        }

        left = 195.5;
        top = 391.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Double[] array = new Double[2];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);
                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 75.0);

                if (i == 1) {
                    switch (j) {
                        case 0 -> special[16] = button;
                        case 2 -> special[17] = button;
                        case 4 -> special[18] = button;
                        default -> button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                    }
                }
                else if (i == 2 && j == 1) special[21] = button;
                else if (i == 4) {
                    switch (j) {
                        case 0 -> special[23] = button;
                        case 1 -> special[24] = button;
                        case 2 -> special[25] = button;
                        case 3 -> special[26] = button;
                        case 4 -> special[27] = button;
                    }
                }
                else {
                    button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                }

                array[0] = top + i * 74.0;
                array[1] = left + j * 75.0;
                buttonMap.put(button, array);
            }
        }

        left = 570.5;
        top = 18.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Double[] array = new Double[2];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);
                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 74.0);

                if (i == 0) {
                    switch (j) {
                        case 0 -> special[5] = button;
                        case 1 -> special[6] = button;
                        case 2 -> special[7] = button;
                        case 3 -> special[8] = button;
                    }
                }
                else if(i == 2 && j == 2) special[10] = button;
                else if(i == 3) {
                    switch (j) {
                        case 1 -> special[14] = button;
                        case 3 -> special[15] = button;
                        default -> button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                    }
                }
                else {
                    button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                }

                array[0] = top + i * 74.0;
                array[1] = left + j * 74.0;
                buttonMap.put(button, array);
            }
        }

        left = 570.5;
        top = 391.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Double[] array = new Double[2];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);
                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 74.0);

                if (i == 1) {
                    switch (j) {
                        case 1 -> special[19] = button;
                        case 3 -> special[20] = button;
                        default -> button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                    }
                }
                else if (i == 2 && j == 2) special[22] = button;
                else if (i == 4) {
                    switch (j) {
                        case 0 -> special[28] = button;
                        case 1 -> special[29] = button;
                        case 2 -> special[30] = button;
                        case 3 -> special[31] = button;
                    }
                }
                else {
                    button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                }

                array[0] = top + i * 74.0;
                array[1] = left + j * 74.0;
                buttonMap.put(button, array);
            }
        }
    }


}
