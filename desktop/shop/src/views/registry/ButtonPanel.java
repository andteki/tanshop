package views.registry;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox {
    Button saveButton;
    public ButtonPanel() {
        this.saveButton = new Button("Mentés");
        this.getChildren().add(this.saveButton);
        HBox.setMargin(this.saveButton, new Insets(10, 10, 10, 10));
    }
    public Button getSaveButton() {
        return saveButton;
    }
    
    
}
