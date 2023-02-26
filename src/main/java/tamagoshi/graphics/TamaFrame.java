package tamagoshi.graphics;

import javafx.scene.Scene;
import javafx.stage.Stage;
import tamagoshi.jeu.TamaGameGraphic;
import tamagoshi.tamagoshis.Tamagoshi;

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

    public void desactiveBoutonManger() {
        tama.desactiveBoutonManger();
    }

    public void desactiveBoutonJouer() {
        tama.desactiveBoutonJouer();
    }

    public void reactiveBoutons() {
        tama.reactiveBoutons();
    }
}
