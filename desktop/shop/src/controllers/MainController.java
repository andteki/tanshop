package controllers;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.MainTab;
import views.MainView;
import views.add.AddView;

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
            AddView addView = new AddView();
            addView.show();
            
        });
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  

    
}
