package View;

import Control.Controller;
import Model.Location;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.HashMap;

public class ButtonFactory {
    private AnchorPane anchorPane;
    private ArrayList<Object[]> buttonlist;
    private Button[] special;
    private Controller controller;
    private Viewer viewer;
    private int prev = -1;

    /**
     * The initializer of ButtonFactory.
     * @param anchorPane  The Anchorpane that is used to build visualization.
     * @param controller  The controller that control the game.
     */
    public ButtonFactory(AnchorPane anchorPane, Controller controller,Viewer viewer){
        this.anchorPane = anchorPane;
        this.controller = controller;
        this.viewer = viewer;
        buttonlist = new ArrayList<>();
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
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Object[] array = new Object[4];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);

                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 75.0);

                array[0] = button;
                array[1] = top + i * 74.0;
                array[2] = left + j * 75.0;
                array[3] = new Location(i,j);
                buttonlist.add(array);

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
                        default -> {
                            button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                            button.setOnAction(e -> handle_nullButton(button));
                        }
                    }
                }
                else {
                    button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                    button.setOnAction(e -> handle_nullButton(button));
                }
            }
        }

        top = 391.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Object[] array = new Object[4];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);

                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 75.0);

                array[0] = button;
                array[1] = top + i * 74.0;
                array[2] = left + j * 75.0;
                array[3] = new Location(i + 5,j);
                buttonlist.add(array);

                if (i == 1) {
                    switch (j) {
                        case 0 -> special[16] = button;
                        case 2 -> special[17] = button;
                        case 4 -> special[18] = button;
                        default -> {
                            button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                            button.setOnAction(e -> handle_nullButton(button));
                        }
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
                    button.setOnAction(e -> handle_nullButton(button));
                }
            }
        }

        left = 570.5;
        top = 18.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Object[] array = new Object[4];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);

                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 74.0);

                array[0] = button;
                array[1] = top + i * 74.0;
                array[2] = left + j * 74.0;
                array[3] = new Location(i,j + 5);
                buttonlist.add(array);

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
                        default -> {
                            button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                            button.setOnAction(e -> handle_nullButton(button));
                        }
                    }
                }
                else {
                    button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                    button.setOnAction(e -> handle_nullButton(button));
                }
            }
        }

        top = 391.0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Object[] array = new Object[4];

                Button button = new Button();
                button.setShape(new Circle(30));
                button.setMaxSize(60,60);
                button.setMinSize(60,60);

                anchorPane.getChildren().add(button);
                AnchorPane.setTopAnchor(button,top + i * 74.0);
                AnchorPane.setLeftAnchor(button, left + j * 74.0);

                array[0] = button;
                array[1] = top + i * 74.0;
                array[2] = left + j * 74.0;
                array[3] = new Location(i + 5,j + 5);
                buttonlist.add(array);

                if (i == 1) {
                    switch (j) {
                        case 1 -> special[19] = button;
                        case 3 -> special[20] = button;
                        default -> {
                            button.setStyle("-fx-background-color: rgba(0,0,0,0)");
                            button.setOnAction(e -> handle_nullButton(button));
                        }
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
                    button.setOnAction(e -> handle_nullButton(button));
                }
            }
        }
    }

    /**
     * The method set_special() will set graphics and actions of the special buttons in the array special.
     */
    private void set_special() {
        String prefix = "View/Graphics/";
        String suffix = ".png";
        for (int i = 0; i < special.length; i++) {
            String link = prefix + i + suffix;
            Image image = new Image(link, 65, 65, true, true);
            ImageView imageView = new ImageView(image);

            Button curr_chess = special[i];
            curr_chess.setGraphic(imageView);

            String selected = prefix + "_" + i + suffix;
            int curr = i;

            curr_chess.setOnAction(e -> {
                if (!viewer.checkEnd()) {
                    int state = -1;
                    Object[] target = new Object[0];
                    for (Object[] obj : buttonlist) {
                        if (obj[0].equals(curr_chess)){
                            target = obj;
                            state = controller.addClick((Location) obj[3], viewer.getRound());
                            break;
                        }
                    }
                    switch (state) {
                        case 0 -> {
                            if (prev != -1) {
                                Image origin = new Image(prefix + prev + suffix, 65, 65, true, true);
                                ImageView origin_view = new ImageView(origin);
                                special[prev].setGraphic(origin_view);
                            }

                            Image select = new Image(selected, 65, 65, true, true);
                            ImageView selected_view = new ImageView(select);
                            curr_chess.setGraphic(selected_view);
                            prev = curr;
                        }
                        case 1, 3 -> {
                            Button prevButton = special[prev];
                            anchorPane.getChildren().remove(curr_chess);

                            Button deadChess = new Button();
                            deadChess.setShape(new Circle(30));
                            deadChess.setMaxSize(60,60);
                            deadChess.setMinSize(60,60);

                            for (Object[] obj : buttonlist) {
                                if (obj[0].equals(prevButton)) {
                                    obj[0] = deadChess;
                                    anchorPane.getChildren().add(deadChess);
                                    AnchorPane.setTopAnchor(deadChess, (double) obj[1]);
                                    AnchorPane.setLeftAnchor(deadChess, (double) obj[2]);
                                    break;
                                }
                            }

                            deadChess.setStyle("-fx-background-color: rgba(0,0,0,0)");
                            deadChess.setOnAction(a -> handle_nullButton(deadChess));

                            target[0] = prevButton;
                            AnchorPane.setTopAnchor(prevButton, (double) target[1]);
                            AnchorPane.setLeftAnchor(prevButton, (double) target[2]);

                            Image origin = new Image(prefix + prev + suffix, 65, 65, true, true);
                            ImageView origin_view = new ImageView(origin);
                            prevButton.setGraphic(origin_view);

                            viewer.reportCheckMate(controller.isCheckMate());

                            prev = -1;
                            if (state == 3) {
                                viewer.endGame();
                            }
                            else{
                                viewer.nextRound();
                            }

                        }
                        case 2 -> {
                            if (prev != -1) {
                                Image origin = new Image(prefix + prev + suffix, 65, 65, true, true);
                                ImageView origin_view = new ImageView(origin);
                                special[prev].setGraphic(origin_view);
                                prev = -1;
                            }
                        }
                    }
                }

            });
        }
    }

    /**
     * The method handle_nullButton will set the action for the null_buttons
     * that are not chess.
     * @param null_button  A button that is not chess.
     */
    private void handle_nullButton(Button null_button) {
        if (!viewer.checkEnd()) {
            int state = -1;
            Object[] target = new Object[0];
            for (Object[] obj : buttonlist) {
                if (obj[0].equals(null_button)){
                    target = obj;
                    state = controller.addClick((Location) obj[3], viewer.getRound());
                    break;
                }
            }
            switch (state) {
                case 1 -> {
                    Button prev_button = special[prev];
                    System.out.println("null_button (before) = ");
                    System.out.println(target[1]);
                    System.out.println(target[2]);
                    System.out.println(target[3]);

                    for (Object[] obj : buttonlist) {
                        if (obj[0].equals(prev_button)) {
                            obj[0] = null_button;
                            target[0] = prev_button;
                            AnchorPane.setTopAnchor(null_button, (Double) obj[1]);
                            AnchorPane.setLeftAnchor(null_button, (Double) obj[2]);
                            System.out.println("null_button (after) = ");
                            System.out.println(obj[1]);
                            System.out.println(obj[2]);
                            System.out.println(obj[3]);
                            break;
                        }
                    }

                    AnchorPane.setTopAnchor(prev_button, (double) target[1]);
                    AnchorPane.setLeftAnchor(prev_button, (double) target[2]);


                    Image origin = new Image("View/Graphics/" + prev + ".png", 65, 65, true, true);
                    ImageView origin_view = new ImageView(origin);
                    prev_button.setGraphic(origin_view);

                    viewer.reportCheckMate(controller.isCheckMate());

                    prev = -1;
                    viewer.nextRound();
                }

                case 2 -> {
                    if (prev != -1) {
                        Image origin = new Image("View/Graphics/" + prev + ".png", 65, 65, true, true);
                        ImageView origin_view = new ImageView(origin);
                        special[prev].setGraphic(origin_view);
                        prev = -1;
                    }
                }
            }
        }

    }

}
