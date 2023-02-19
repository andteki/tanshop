package views.product.modify;

import javafx.scene.layout.VBox;
import models.Product;
import views.InputPanel;
import views.LabelPanel;

public class ModifyPanel extends VBox {
    LabelPanel labelPanel;
    InputPanel idInput;
    InputPanel nameInput;
    InputPanel artnumberInput;
    InputPanel quantityInput;
    InputPanel priceInput;
    InputPanel imagepathInput;
    public ModifyPanel() {
        this.initComponent();
        this.addComponent();
    }
    private void initComponent() {
        this.labelPanel = new LabelPanel("Módosítás");
        this.idInput = new InputPanel("Azonosító");
        this.nameInput = new InputPanel("Név");
        this.artnumberInput = new InputPanel("Cikksám");
        this.quantityInput = new InputPanel("Mennyiség");
        this.priceInput = new InputPanel("Ár");
        this.imagepathInput = new InputPanel("Kép útvonala");
    }
    private void addComponent() {
        this.getChildren().add(this.labelPanel);
        this.getChildren().add(this.idInput);
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.artnumberInput);
        this.getChildren().add(this.quantityInput);
        this.getChildren().add(this.priceInput);
        this.getChildren().add(this.imagepathInput);
    }
    public void setProduct(Product product) {
        this.idInput.setValue(Integer.toString(product.getId()));
        this.nameInput.setValue(product.getName());
        this.artnumberInput.setValue(product.getArtnumber());
        this.quantityInput.setValue(Integer.toString(product.getQuantity()));
        this.priceInput .setValue(Double.toString(product.getPrice()));
        this.imagepathInput.setValue(product.getImagepath());
        
    }
    public LabelPanel getTitlePanel() {
        return labelPanel;
    }
    public InputPanel getIdInput() {
        return idInput;
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
