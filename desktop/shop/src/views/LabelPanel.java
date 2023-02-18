package views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LabelPanel extends VBox {
    Label label;
    public LabelPanel() {
        this.label = new Label();
        this.setComponent();        
    }
    public LabelPanel(String text) {
        this.label = new Label(text);
        this.setComponent();
    }
    private void setComponent() {
        VBox.setMargin(this.label, new Insets(10, 10, 10, 10));
        this.getChildren().add(this.label);
    }
    public void setText(String text) {
        label.setText(text);
    }
    
}
