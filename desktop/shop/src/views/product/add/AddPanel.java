package views.product.add;

import javafx.scene.layout.VBox;
import views.InputPanel;

public class AddPanel extends VBox {
    TitlePanel titlePanel;
    InputPanel nameInput;
    InputPanel artnumberInput;
    InputPanel quantityInput;
    InputPanel priceInput;
    InputPanel imagepathInput;
    public AddPanel() {
        this.initComponent();
        this.addComponent();
    }
    private void initComponent() {
        this.titlePanel = new TitlePanel();
        this.nameInput = new InputPanel("Név");
        this.artnumberInput = new InputPanel("Cikksám");
        this.quantityInput = new InputPanel("Mennyiség");
        this.priceInput = new InputPanel("Ár");
        this.imagepathInput = new InputPanel("Kép útvonala");
    }
    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.artnumberInput);
        this.getChildren().add(this.quantityInput);
        this.getChildren().add(this.priceInput);
        this.getChildren().add(this.imagepathInput);
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
}
