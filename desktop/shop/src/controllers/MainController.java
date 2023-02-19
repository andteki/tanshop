package controllers;

import javafx.scene.control.Button;
import views.MainTab;
import views.add.AddStage;
import views.product.MainView;

public class MainController {

    MainView mainView;
    MainTab mainTab;

    public MainController() {
        this.mainView = new MainView();
        this.mainTab = new MainTab(this.mainView);
        
        this.handleEvent();
    }
    private void handleEvent() {
        Button addButton = this.mainView.getButtonPanel().getAddButton();
        addButton.setOnAction(e -> {
            System.out.println("működik");
            AddStage addView = new AddStage();
            addView.show();
            
        });
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  

    
}
