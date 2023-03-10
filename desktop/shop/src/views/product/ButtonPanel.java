package views.product;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox {
    Button addButton;
    Button delButton;
    Button modifyButton;
    public ButtonPanel() {
        this.initComponent();
        this.setComponent();
        this.addComponent();
    }
    private void initComponent() {
        this.addButton = new Button("Hozzáadás");
        this.delButton = new Button("Törlés");
        this.modifyButton = new Button("Módosítás");
    }
    private void setComponent() {
        HBox.setMargin(this.addButton, new Insets(10, 10, 10, 10));
        HBox.setMargin(this.delButton, new Insets(10, 10, 10, 10));
        HBox.setMargin(this.modifyButton, new Insets(10, 10, 10, 10));
    }
    private void addComponent() {
        this.getChildren().add(this.addButton);
        this.getChildren().add(this.delButton);
        this.getChildren().add(this.modifyButton);
    }
    public Button getAddButton() {
        return this.addButton;
    }
    public Button getDelButton() {
        return this.delButton;
    }
    public Button getModifyButton() {
        return this.modifyButton;
    }
}
