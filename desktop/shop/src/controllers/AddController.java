package controllers;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Product;
import models.api.Restapi;
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
            this.addProduct();
            this.close();
        });
    }
    private void close() {
        Stage stage = (Stage) addPanel.getScene().getWindow();
        stage.close();
    }
    private void addProduct() {
        String name = addPanel.getNameInput().getValue();
        String artnumber = addPanel.getArtnumberInput().getValue();
        String quantityStr = addPanel.getQuantityInput().getValue();
        int quantity = Integer.parseInt(quantityStr);
        String priceStr = addPanel.getPriceInput().getValue();
        double price = Double.parseDouble(priceStr);
        String imagepath = addPanel.getImagepathInput().getValue();
        Product product = new Product(name, artnumber, quantity, price, imagepath);
        Restapi api = new Restapi();
        api.addProduct(product);
        this.refreshTable();
    }
    private void refreshTable() {
        // addPanel.getParent().getParent().
    }
}
