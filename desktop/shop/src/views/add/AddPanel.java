package views.add;

import controllers.AddController;
import javafx.scene.layout.VBox;
import views.InputPanel;

public class AddPanel extends VBox {
    TitlePanel titlePanel;
    InputPanel nameInput;
    InputPanel artnumberInput;
    InputPanel quantityInput;
    InputPanel priceInput;
    InputPanel imagepathInput;
    ButtonPanel buttonPanel;
    public AddPanel() {
        this.initComponent();
        this.addComponent();
        new AddController(this);
        
    }
    private void initComponent() {
        this.titlePanel = new TitlePanel();
        this.nameInput = new InputPanel("Név");
        this.artnumberInput = new InputPanel("Cikksám");
        this.quantityInput = new InputPanel("Mennyiség");
        this.priceInput = new InputPanel("Ár");
        this.imagepathInput = new InputPanel("Kép útvonala");
        this.buttonPanel = new ButtonPanel();
    }
    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.artnumberInput);
        this.getChildren().add(this.quantityInput);
        this.getChildren().add(this.priceInput);
        this.getChildren().add(this.imagepathInput);
        this.getChildren().add(this.buttonPanel);
    }
    public TitlePanel getTitlePanel() {
        return titlePanel;
    }
    public InputPanel getNameInput() {
        return nameInput;
    }
    public InputPanel getArtnumberInput() {
        return artnumberInput;
    }
    public InputPanel getQuantityInput() {
        return quantityInput;
    }
    public InputPanel getPriceInput() {
        return priceInput;
    }
    public InputPanel getImagepathInput() {
        return imagepathInput;
    }
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

}
