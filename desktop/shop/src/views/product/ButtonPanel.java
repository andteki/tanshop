package views.product;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox {
    Button addButton;
    public ButtonPanel() {
        this.addButton = new Button("Hozzáadás");
        this.getChildren().add(this.addButton);
        HBox.setMargin(this.addButton, new Insets(10, 10, 10, 10));
    }
    public Button getAddButton() {
        return this.addButton;
    }
}
