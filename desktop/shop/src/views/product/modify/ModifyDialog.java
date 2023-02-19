package views.product.modify;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import models.Product;

public class ModifyDialog extends Dialog<Product> {
    ModifyPanel modifyPanel;
    public ModifyDialog() {
        this.initComponent();
        this.setDialog();        
    }
    private void initComponent() {
        this.modifyPanel = new ModifyPanel();
    }    
    private void setDialog() {
        ButtonType okType = new ButtonType("Mentés", ButtonData.OK_DONE);
        ButtonType cancelType = new ButtonType("Mégsem", ButtonData.CANCEL_CLOSE);

        this.getDialogPane().getButtonTypes().addAll(okType, cancelType);
        this.getDialogPane().setContent(this.modifyPanel);
        this.setResultConverter(dialogButton -> {
            if (dialogButton == okType) {
                return this.getProduct();
            }
            return null;
        });
    }    
    private Product getProduct() {
        String idStr = modifyPanel.getIdInput().getValue();
        int id = Integer.parseInt(idStr);
        String name = modifyPanel.getNameInput().getValue();
        String artnumber = modifyPanel.getArtnumberInput().getValue();
        String quantityStr = modifyPanel.getQuantityInput().getValue();
        int quantity = Integer.parseInt(quantityStr);
        String priceStr = modifyPanel.getPriceInput().getValue();
        double price = Double.parseDouble(priceStr);
        String imagepath = modifyPanel.getImagepathInput().getValue();
        Product product = new Product(id, name, artnumber, quantity, price, imagepath);
        return product;
    }
    public void setProduct(Product product) {
        this.modifyPanel.setProduct(product);
    }
}
