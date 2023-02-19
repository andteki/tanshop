package views.product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Product;
import models.ShopProperty;
import models.api.CheckApi;
import models.api.ProductApi;

public class TablePanel extends VBox{
    Label productLabel;
    ProductApi restapi;
    TableView<Product> tableView;
    public TablePanel() {
        productLabel = new Label("Termékek");
        
        this.initData();
        this.initTable();
        this.getChildren().add(productLabel);
        this.getChildren().add(tableView);
    }
    private void initTable() {
        tableView = new TableView<>();
        
        TableColumn<Product, Integer> idCol = new TableColumn<>("Az");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<Product, String> nameCol = new TableColumn<>("Név");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Product, String> artnumberCol = new TableColumn<>("Cikkszám");
        artnumberCol.setMinWidth(50);
        artnumberCol.setCellValueFactory(new PropertyValueFactory<>("artnumber"));

        TableColumn<Product, Integer> quantityCol = new TableColumn<>("Darab");
        quantityCol.setMinWidth(50);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        TableColumn<Product, Double> priceCol = new TableColumn<>("Ár");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> imagepathCol = new TableColumn<>("Kép útvonala");
        imagepathCol.setMinWidth(50);
        imagepathCol.setCellValueFactory(new PropertyValueFactory<>("imagepath"));

        ShopProperty pro = new ShopProperty();
        String host = pro.getProperty("restapi.host");
        CheckApi checkApi = new CheckApi();
        if(checkApi.checkUrl(host)) {
            this.getProducts();
        }

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(artnumberCol);
        tableView.getColumns().add(quantityCol);
        tableView.getColumns().add(priceCol);
        tableView.getColumns().add(imagepathCol);
        
    }
    private ObservableList<Product> getProductsAsObservableList() {
        ObservableList<Product> productList = 
        FXCollections.observableArrayList(restapi.getProducts());
        return productList;
    }
    private void initData() {
        this.restapi = new ProductApi();
    }
    public void getProducts() {
        tableView.setItems(this.getProductsAsObservableList());
    }
    public TableView<Product> getTableView() {
        return this.tableView;
    }
}