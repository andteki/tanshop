package views;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox {
    Button addButton;
    public ButtonPanel() {
        this.addButton = new Button("Hozzáadás");
        this.getChildren().add(this.addButton);
    }
    public Button getAddButton() {
        return this.addButton;
    }
}
