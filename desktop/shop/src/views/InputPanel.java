package views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class InputPanel extends HBox {
    Label label;
    TextField field;
    public InputPanel() {
        this.initComponent();
        this.addComponent();
    }
    public InputPanel(String text) {
        this.initComponent();
        this.setComponent();
        this.addComponent();
        this.label.setText(text);
    }

    private void initComponent() {
        this.label = new Label();
        this.field = new TextField();
    }
    private void setComponent() {
        HBox.setMargin(this.label, new Insets(5, 10, 5, 10));
        HBox.setMargin(this.field, new Insets(5, 10, 5, 10));
        this.label.setMinWidth(100);
    }
    private void addComponent() {
        this.getChildren().add(this.label);
        this.getChildren().add(this.field);
    }
    public String getText() {
        return label.getText();
    }
    public void setText(String text) {
        this.label.setText(text);
    }
    public String getValue() {
        return field.getText();
    }
    public void setValue(String value) {
        this.field.setText(value);
    }
    
    
}
