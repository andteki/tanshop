package controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import models.Product;
import models.api.ProductApi;
import views.MainTab;
import views.product.MainView;
import views.product.add.AddDialog;
import views.product.modify.ModifyDialog;

public class MainController {

    MainView mainView;
    MainTab mainTab;
    AddDialog addDialog;
    ModifyDialog modifyDialog;
    ProductApi api;
    TableView<Product> productTable;
    public MainController() {
        this.mainView = new MainView();
        this.mainTab = new MainTab(this.mainView);
        this.addDialog = new AddDialog();
        this.modifyDialog = new ModifyDialog();
        this.handleEvent();
        this.api = new ProductApi();
        productTable = this.mainView.getTablePanel().getTableView();
    }
    private void handleEvent() {
        Button addButton = this.mainView.getButtonPanel().getAddButton();
        Button delButton = this.mainView.getButtonPanel().getDelButton();
        Button modifyButton = this.mainView.getButtonPanel().getModifyButton();
        addButton.setOnAction(e -> {
            this.onActionAddButton();
        });
        delButton.setOnAction(e -> {
            this.onActionDelButton();
        });
        modifyButton.setOnAction(e -> {
            this.onActionModifyButton();
        });
    }
    private void onActionAddButton() {
        System.out.println("Hozzáadás...");
        addDialog.showAndWait()                
            .ifPresent(product -> {
                this.api.addProduct(product);
                mainView.getTablePanel().getProducts();
            });
    }
    private void onActionDelButton() {
        System.out.println("Törlés ...");
        int selected = productTable.getSelectionModel().getSelectedIndex();
        if (selected == -1) {
            this.warningSelection();
        }else {
            if (this.confirmDelete()) {            
                Product product = productTable.getItems().get(selected);        
                this.api.delProduct(product.getId());
                mainView.getTablePanel().getProducts();
            }
        }
    }
    private void onActionModifyButton() {
        System.out.println("módosítás...");
        int selected = productTable.getSelectionModel().getSelectedIndex();
        if (selected == -1) {
            this.warningSelection();
        }else {
            Product product = productTable.getItems().get(selected);        
            mainView.getTablePanel().getProducts();
            modifyDialog.setProduct(product);
            modifyDialog.showAndWait()                
            .ifPresent(res -> {
                System.out.println("Módosítás");
                System.out.println(res.getQuantity());
                Product newProduct = res;
                this.api.modifyProduct(newProduct);
                mainView.getTablePanel().getProducts();
            });    
        }
    }
    private boolean confirmDelete() {
        Alert alert = new Alert(AlertType.CONFIRMATION );
        alert.setTitle("Törlés");
        alert.setHeaderText("Törlés");
        alert.setContentText("Biztosan törlöd?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) 
            return true;
        else 
            return false;
    }
    private void warningSelection() {
        Alert selectionAlert = new Alert(AlertType.WARNING);
        selectionAlert.setContentText("Nincs kiválasztva sor");
        selectionAlert.show();
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  

    
}
