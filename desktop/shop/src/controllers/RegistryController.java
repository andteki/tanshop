package controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import models.api.AuthService;
import views.registry.RegistryView;

public class RegistryController {
    RegistryView registryView;
    public RegistryController(RegistryView registryView) {
        this.registryView = registryView;
        this.handleEvent();
    }
    private void handleEvent() {
        Button saveButton = registryView.getButtonPanel().getSaveButton();
        saveButton.setOnAction(e -> {
            this.saveUser();
        });
    }
    private void saveUser() {
        System.out.println("Felhasználó mentése");
        String name = registryView.getNameInput().getValue();
        String email = registryView.getEmailInput().getValue();
        String pass = registryView.getPassInput().getValue();
        String confirmpass = registryView.getConfirmpassInput().getValue();

        if (pass.equals(confirmpass)) {
            AuthService auth = new AuthService();
            auth.registry(name, email, pass);
        }else {
            this.showMsg();
        }
        

    }
    private void showMsg() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);        
        alert.setTitle("Jelszavak");
        alert.setHeaderText("Hiba");
        alert.setContentText("A jelszavak nem egyeznek");
        alert.showAndWait();        
    }
}
