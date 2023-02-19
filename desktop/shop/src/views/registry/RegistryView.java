package views.registry;

import controllers.RegistryController;
import javafx.scene.layout.VBox;
import views.InputPanel;
import views.LabelPanel;

public class RegistryView extends VBox {
    LabelPanel titlePanel;
    InputPanel nameInput;
    InputPanel emailInput;
    InputPanel passInput;
    InputPanel confirmpassInput;
    ButtonPanel buttonPanel;
    RegistryController registryController;

    public RegistryView() {
        this.initComponent();
        this.addComponent();
        this.registryController = new RegistryController(this);
    }
    private void initComponent() {
        this.titlePanel = new LabelPanel("Felhasználó felvétele");
        this.nameInput = new InputPanel("Név");
        this.emailInput = new InputPanel("E-mail");
        this.passInput = new InputPanel("Jelszó");
        this.confirmpassInput = new InputPanel("Jelszó újra");
        this.buttonPanel = new ButtonPanel();
    }
    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.emailInput);
        this.getChildren().add(this.passInput);
        this.getChildren().add(this.confirmpassInput);
        this.getChildren().add(this.buttonPanel);
    }
    public ButtonPanel getButtonPanel() {
        return this.buttonPanel;
    }
    public LabelPanel getTitlePanel() {
        return titlePanel;
    }
    public InputPanel getNameInput() {
        return nameInput;
    }
    public InputPanel getEmailInput() {
        return emailInput;
    }
    public InputPanel getPassInput() {
        return passInput;
    }
    public InputPanel getConfirmpassInput() {
        return confirmpassInput;
    }
    public RegistryController getRegistryController() {
        return registryController;
    }

    
}
