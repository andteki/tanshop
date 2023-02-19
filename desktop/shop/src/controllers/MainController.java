package controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import models.Product;
import models.api.ProductApi;
import views.MainTab;
import views.add.AddDialog;
import views.product.MainView;

public class MainController {

    MainView mainView;
    MainTab mainTab;
    AddDialog addDialog;
    ProductApi api;
    public MainController() {
        this.mainView = new MainView();
        this.mainTab = new MainTab(this.mainView);
        this.addDialog = new AddDialog();
        this.handleEvent();
        this.api = new ProductApi();
    }
    private void handleEvent() {
        Button addButton = this.mainView.getButtonPanel().getAddButton();
        Button delButton = this.mainView.getButtonPanel().getDelButton();
        addButton.setOnAction(e -> {
            this.onActionAddButton();
        });
        delButton.setOnAction(e -> {
            this.onActionDelButton();
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
        TableView<Product> productTable = this.mainView.getTablePanel().getTableView();
        int selected = productTable.getSelectionModel().getSelectedIndex();
        System.out.println("választott: " + selected);

        Product product = productTable.getItems().get(selected);

        this.api.delProduct(product.getId());
        mainView.getTablePanel().getProducts();
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  

    
}
