package views;

import javafx.scene.layout.VBox;

public class MainView extends VBox{
    ButtonPanel buttonPanel;
    TablePanel tablePanel;
    public MainView() {
        this.buttonPanel = new ButtonPanel();
        this.tablePanel = new TablePanel();
        this.getChildren().add(this.buttonPanel);
        this.getChildren().add(this.tablePanel);
    }
    public ButtonPanel getButtonPanel() {
        return this.buttonPanel;
    }
}
