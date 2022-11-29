package View;

import Control.Controller;
import Model.Location;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Objects;

public class ButtonFactory {
    private AnchorPane anchorPane;
    private HashMap<Button, Object[]> buttonMap;
    private Button[] special;
    private Controller controller;

    /**
     * The initializer of ButtonFactory.
     * @param anchorPane  The Anchorpane that is used to build visualization.
     * @param controller  The controller that control the game.
     */
    public ButtonFactory(AnchorPane anchorPane, Controller controller){
        this.anchorPane = anchorPane;
        this.controller = controller;
        buttonMap = new HashMap<>();
        special = new Button[32];
        computeButtons();
        set_special();
    }

    /**
     * The method computeButtons() will create all the buttons
     * and collect some special buttons that represent the chess,
     * then anchor those buttons on the Anchorpane and record their coordinates into the buttonMap.
     */
    private void computeButtons(){
        double left = 195.5;
        double top = 18.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Object[] array = new Object[3];

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
                array[2] = new Location(i,j);
                buttonMap.put(button, array);
            }
        }

        top = 391.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Object[] array = new Object[3];

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
                array[2] = new Location(i + 5,j);
                buttonMap.put(button, array);
            }
        }

        left = 570.5;
        top = 18.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Object[] array = new Object[3];

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
                array[2] = new Location(i ,j + 5);
                buttonMap.put(button, array);
            }
        }

        top = 391.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Object[] array = new Object[3];

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
                array[2] = new Location(i + 5,j + 5);
                buttonMap.put(button, array);
            }
        }
    }

    /**
     * The method set_special() will set graphics of the special buttons in the array special.
     */
    private void set_special() {
        String prefix = "View/Graphics/";
        String suffix = ".png";
        for (int i = 0; i < special.length; i++) {
            Image image = new Image(prefix + i + suffix, 65, 65, true, true);
            ImageView imageView = new ImageView(image);
            special[i].setGraphic(imageView);
        }
    }

}
