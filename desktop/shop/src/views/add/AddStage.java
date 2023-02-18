package views.add;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddStage extends Stage {
    public AddStage() {
        this.setTitle("Hozzáadás");
        this.initModality(Modality.APPLICATION_MODAL);
        AddPanel addPanel = new AddPanel();
        Scene scene = new Scene(addPanel, 400, 300);
        this.setScene(scene);
    }
}
