package tamagoshi.jeu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tamagoshi.graphics.TamaFrame;
import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.util.RandomGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TamaGameGraphic extends Application {
    private GridPane root;
    int nbTama;
    List<TamaFrame> tamaFrames = new ArrayList<>();
    List<Tamagoshi> tamagoshis = new ArrayList<>();
    int nbTour = 1;
    private boolean choixManger;
    private boolean choixJouer;
    TextArea derouleJeux;
    private final Logger gameLog;
    private Stage primaryStage;

    public TamaGameGraphic() {
        gameLog = Logger.getLogger("gameLog");
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initialisationFenetre();

        affichagePourCreationTamagoshis();

        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> Platform.exit());
    }

    private void initialisationFenetre() {
        root = new GridPane();
        Scene scene = new Scene(root, 550, 200);
        primaryStage.setTitle("accueil");
        primaryStage.setScene(scene);
    }

    private void affichagePourCreationTamagoshis() {
        gameLog.info("choix du nombre de tamagoshis");
        Map<Integer, Button> boutons = new HashMap<>(Map.of(
                2, new Button("2"),
                4, new Button("4"),
                6, new Button("6"),
                8, new Button("8")
        ));
        nbTama = 8;

        boutons.forEach((nb, button) -> button.setOnAction(e -> nbTama = nb));

        Button ok = new Button("ok");
        ok.setOnAction(event -> {
            creationTamas();
            lancementPartie();
        });

        boutons.forEach((nb, bouton) -> root.add(bouton, nb / 2, 0));
        root.add(ok, 1, 3);
    }

    private void lancementPartie() {
        Tamagoshi.setLifeTime(5);
        derouleJeux = new TextArea();
        derouleJeux.setOnInputMethodTextChanged(event -> derouleJeux.setScrollTop(Double.MAX_VALUE));

        root.getChildren().clear();
        root.add(derouleJeux, 0, 0);

        afficherTextLogEtPartie("\n -- la partie durera " + Tamagoshi.getLifeTime() + " tours --");
        afficherTextLogEtPartie("\n -- début du tour n°" + nbTour + " --");
    }

    private void creationTamas() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double size = Math.min(screenSize.getWidth() / Math.min(nbTama, 4), 500);
        int x = 0;
        int y = 0;
        for (int i = 0; i < nbTama; i++) {
            Stage stage = new Stage();
            stage.setWidth(size);
            stage.setHeight(size);
            if (i == 4) {
                y += size + 30;
                x = 0;
            }
            stage.setX(x);
            stage.setY(y);
            x += stage.getWidth();

            Tamagoshi tamagoshi = RandomGenerator.generateRandomTamagoshi();
            tamaFrames.add(new TamaFrame(stage, tamagoshi, this));
            tamagoshis.add(tamagoshi);

            primaryStage.setY(screenSize.getHeight() - (primaryStage.getHeight() + 100));
            primaryStage.setAlwaysOnTop(true);
        }

    }

    public void tamaAEteNourrit() {
        if (!choixManger) {
            tamaFrames.forEach(TamaFrame::desactiveBoutonManger);
            choixManger = true;
        }
        tourSuivant();
    }

    public void tamaAJoue() {
        tamaFrames.forEach(TamaFrame::desactiveBoutonJouer);
        choixJouer = true;
        tourSuivant();
    }

    private void tourSuivant() {
        if (choixManger && choixJouer) {
            if (AuMoinsUnTamaEstVivant() && nbTour < Tamagoshi.getLifeTime()) {
                nbTour++;
                choixJouer = false;
                choixManger = false;
                afficherTextLogEtPartie("\n -- début du tour n°" + nbTour + " --");
                tamaFrames.forEach(TamaFrame::reactiveBoutons);
                tamagoshis.forEach(Tamagoshi::endOfADay);
            } else {
                tamaFrames.forEach(TamaFrame::desactiveBoutonJouer);
                tamaFrames.forEach(TamaFrame::desactiveBoutonManger);
                afficheScore();
            }
        }
    }

    /**
     * print the final results of the game
     */
    private void afficheScore() {
        afficherTextLogEtPartie("\n\n----------------------- Bilan -----------------------");
        for (Tamagoshi tamagoshi : tamagoshis) {
            String prefix = "\nle " + tamagoshi.getClass().getSimpleName() + " " + tamagoshi.getName();
            if (tamagoshi.isAliveWithoutCountingAge())
                afficherTextLogEtPartie(prefix + " est toujours en vie et danse la guigandélire (✯◡✯)");
            else
                afficherTextLogEtPartie(prefix + " est mort par ta faute (×_×)");
        }
        afficherTextLogEtPartie("\n ----------- Score ------------------- \nscore : " + score() + " %");
    }

    /**
     * calculate the score depending the longevity of each Tama
     *
     * @return the score of the player
     */
    private double score() {
        double sommeScoresTama = 0;
        for (Tamagoshi tamagoshi : tamagoshis) {
            sommeScoresTama += (double) tamagoshi.getAge() * 100 / Tamagoshi.getLifeTime();
        }
        return sommeScoresTama / tamagoshis.size();
    }

    private boolean AuMoinsUnTamaEstVivant() {
        boolean survivant = false;
        for (Tamagoshi tamagoshi : tamagoshis) {
            if (tamagoshi.isAlive()) {
                survivant = true;
                break;
            }
        }
        return survivant;
    }

    private void afficherTextLogEtPartie(String text) {
        derouleJeux.appendText(text);
        gameLog.info(text);
    }

    public static void main(String[] args) {
        launch();
    }
}
