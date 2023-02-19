package controllers;

import javafx.scene.control.Button;
import views.MainTab;
import views.add.AddStage;
import views.product.MainView;

public class MainController {

    MainView mainView;
    MainTab mainTab;
    AddStage addView;
    public MainController() {
        this.mainView = new MainView();
        this.mainTab = new MainTab(this.mainView);
        this.addView = new AddStage();
        this.handleEvent();
    }
    private void handleEvent() {
        Button addButton = this.mainView.getButtonPanel().getAddButton();
        addButton.setOnAction(e -> {
            System.out.println("Hozzáadás...");            
            addView.showAndWait();

            System.out.println("Az adatok újrakérése");
            mainView.getTablePanel().getProducts();
            
        });
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  

    
}
