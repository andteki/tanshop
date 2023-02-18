package views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LabelPanel extends VBox {
    Label label;
    public LabelPanel() {
        this.label = new Label();
        this.getChildren().add(this.label);
    }
    public LabelPanel(String text) {
        this.label = new Label(text);
    }
    public void setText(String text) {
        label.setText(text);
    }
    
}
