package tamagoshi.jeu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tamagoshi.graphics.TamaFrame;
import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.util.NameGenerator;

import java.util.HashMap;
import java.util.Map;

public class TamaGameGraphic extends Application {
    private GridPane root;
    int nbTama;

    @Override
    public void start(Stage primaryStage) {
        root = new GridPane();
        Scene scene = new Scene(root, 700, 300);
        primaryStage.setTitle("accueil");
        primaryStage.setScene(scene);

        affichagePourCreationTamagoshis();

        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> Platform.exit());
    }

    private void affichagePourCreationTamagoshis(){
        Map<Integer, Button> boutons = new HashMap<>(Map.of(
                2, new Button("2"),
                4, new Button("4"),
                6, new Button("6"),
                8, new Button("8")
        ));
        nbTama = 8;

        boutons.forEach((nb, button) -> button.setOnAction( e -> nbTama = nb));

        Button ok = new Button("ok");
        ok.setOnAction(event -> {
            creationTamas();
//            lancerJeu();
        });

        boutons.forEach((nb, bouton) -> root.add(bouton, nb/2, 0));
        root.add(ok, 1, 3);
    }

    private void creationTamas() {
        NameGenerator nameGenerator = new NameGenerator();
        for (int i = 0; i < nbTama; i++) {
            Stage stage = new Stage();
            stage.setWidth(500);
            stage.setHeight(500);
            new TamaFrame(stage, new Tamagoshi(nameGenerator.generateRandomName()));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
