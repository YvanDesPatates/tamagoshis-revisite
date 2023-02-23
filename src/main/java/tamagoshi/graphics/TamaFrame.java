package tamagoshi.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tamagoshi.tamagoshis.Tamagoshi;

public class TamaFrame {
    Stage stage;
    Tamagoshi tamagoshi;

    public TamaFrame(Stage stage, Tamagoshi tamagoshi) {
        this.stage = stage;
        this.tamagoshi = tamagoshi;

        TamaJPanel root = new TamaJPanel(tamagoshi, stage.getWidth(), stage.getHeight());

        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());

        stage.setTitle(tamagoshi.getName());
        stage.setScene(scene);
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
