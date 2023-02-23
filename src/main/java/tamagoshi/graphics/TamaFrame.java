package tamagoshi.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tamagoshi.tamagoshis.Tamagoshi;

public class TamaFrame extends Application {
    Stage stage;
    Tamagoshi tamagoshi;

    @Override
    public void start(Stage stage) {
        stage.setWidth(500);
        stage.setHeight(500);
        this.stage = stage;
        this.tamagoshi = new Tamagoshi("à remettre dans le constructeur");

        TamaJPanel root = new TamaJPanel(tamagoshi, stage.getWidth(), stage.getHeight());

        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());

        stage.setTitle(tamagoshi.getName());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
