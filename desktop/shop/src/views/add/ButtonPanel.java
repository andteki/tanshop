package views.add;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox {
    Button saveButton;
    public ButtonPanel() {
        this.saveButton = new Button("Mentés");
        HBox.setMargin(this.saveButton, new Insets(10, 10, 10, 10));        
        this.getChildren().add(this.saveButton);
        
    }
    public Button getSaveButton() {
        return this.saveButton;
    }
    
}
