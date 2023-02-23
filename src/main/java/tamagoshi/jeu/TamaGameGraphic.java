package tamagoshi.jeu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tamagoshi.graphics.TamaFrame;
import tamagoshi.tamagoshis.Parieur;
import tamagoshi.tamagoshis.Tamagoshi;

public class TamaGameGraphic extends Application {


    @Override
    public void start(Stage primaryStage) {
        Stage stage1 = new Stage();
        stage1.setWidth(500);
        stage1.setHeight(500);
        new TamaFrame(stage1, new Tamagoshi("un"));
        Stage stage2 = new Stage();
        stage2.setWidth(500);
        stage2.setHeight(500);
        new TamaFrame(stage2, new Tamagoshi("deux"));
        Stage stage3 = new Stage();
        stage3.setWidth(500);
        stage3.setHeight(500);
        new TamaFrame(stage3, new Parieur("trois"));

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 700, 300);
        primaryStage.setTitle("accueil");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> Platform.exit());
    }

    public static void main(String[] args) {
        launch();
    }
}
