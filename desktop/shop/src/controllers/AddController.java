package controllers;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.add.AddPanel;

public class AddController {
    AddPanel addPanel;
    public AddController(AddPanel addPanel) {
        this.addPanel = addPanel;
        this.handleEvent();
    }
    private void handleEvent() {
        Button saveButton = this.addPanel.getButtonPanel().getSaveButton();
        saveButton.setOnAction(e -> {
            System.out.println("Mentés");
            this.close();
        });
    }
    private void close() {
        Stage stage = (Stage) addPanel.getScene().getWindow();
        stage.close();
        stage = null;
    }
}
