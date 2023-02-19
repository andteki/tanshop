package views.product.add;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import models.Product;

public class AddDialog extends Dialog<Product> {
    AddPanel addPanel;
    public AddDialog() {
        this.initComponent();
        this.setDialog();
    }
    private void initComponent() {
        this.addPanel = new AddPanel();
    }
    private void setDialog() {
        ButtonType okType = new ButtonType("Mentés", ButtonData.OK_DONE);
        ButtonType cancelType = new ButtonType("Mégsem", ButtonData.CANCEL_CLOSE);

        this.getDialogPane().getButtonTypes().addAll(okType, cancelType);
        this.getDialogPane().setContent(addPanel);
        this.setResultConverter(dialogButton -> {
            if (dialogButton == okType) {
                return this.getProduct();
            }
            return null;
        });

    }
    private Product getProduct() {
        String name = addPanel.getNameInput().getValue();
        String artnumber = addPanel.getArtnumberInput().getValue();
        String quantityStr = addPanel.getQuantityInput().getValue();
        int quantity = Integer.parseInt(quantityStr);
        String priceStr = addPanel.getPriceInput().getValue();
        double price = Double.parseDouble(priceStr);
        String imagepath = addPanel.getImagepathInput().getValue();
        Product product = new Product(name, artnumber, quantity, price, imagepath);
        return product;
    }
}
