package tamagoshi.graphics;

import javafx.scene.Scene;
import javafx.stage.Stage;
import tamagoshi.jeu.TamaGameGraphic;
import tamagoshi.tamagoshis.Tamagoshi;

/**
 * convenient class used to create a window for a Tamagoshi
 */
public class TamaFrame {
    Stage stage;
    TamaJPanel tama;



    public TamaFrame(Stage stage, Tamagoshi tamagoshi, TamaGameGraphic controler) {
        this.stage = stage;

        tama = new TamaJPanel(tamagoshi, stage.getWidth(), stage.getHeight(), controler);

        Scene scene = new Scene(tama, stage.getWidth(), stage.getHeight());
        stage.setTitle(tamagoshi.getName());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * forbid the tamagoshi to eat until reactiveBoutons is called
     */
    public void desactiveBoutonManger() {
        tama.desactiveBoutonManger();
    }

    /**
     * forbid the tamagoshi to play until reactiveBoutons is called
     */
    public void desactiveBoutonJouer() {
        tama.desactiveBoutonJouer();
    }

    /**
     * allow the tamagoshi to eat and play
     */
    public void reactiveBoutons() {
        tama.reactiveBoutons();
    }
}
