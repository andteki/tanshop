package controllers;

import views.MainTab;
import views.TablView;

public class MainController {

    TablView mainView;
    MainTab mainTab;

    public MainController() {
        this.mainView = new TablView();
        this.mainTab = new MainTab(this.mainView);
        
    }
    public MainTab getMainTab() {
        return this.mainTab;
    }  
}
