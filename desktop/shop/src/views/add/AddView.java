package views.add;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddView extends Stage {
    TitlePanel titlePanel;
    public AddView() {
        this.titlePanel = new TitlePanel();        
        this.setTitle("Hozzáadás");

        Scene scene = new Scene(this.titlePanel, 300, 200);
        this.setScene(scene);

    }

}
