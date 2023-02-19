import controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainTab;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {

        MainController mainController = new MainController();
        MainTab mainTab = mainController.getMainTab();
        stage.setTitle("Shop editor");
        
        Scene scene = new Scene(mainTab, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
