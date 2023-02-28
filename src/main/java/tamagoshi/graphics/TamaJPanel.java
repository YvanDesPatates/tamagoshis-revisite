package tamagoshi.graphics;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import tamagoshi.jeu.TamaGameGraphic;
import tamagoshi.tamagoshis.Tamagoshi;

import java.util.logging.Logger;

/**
 * a window representing a Tamagoshi
 */
public class TamaJPanel extends GridPane {
    private final Label etat;
    private TamaGameGraphic controler;
    private final Tamagoshi tamagoshi;
    private final Label reponse;
    private final Canvas tamaDessin;
    private Button boutonManger;
    private Button boutonJouer;
    private final Logger interfaceLog;
    boolean etaitEnVie = true;

    /**
     * this constructor build and show a new window representing a tamagoshi
     * @param tamagoshi the Tamagoshi you want to give a face
     * @param width of the window
     * @param height of the window
     * @param controler the entity which control the game
     */
    public TamaJPanel(Tamagoshi tamagoshi, double width, double height, TamaGameGraphic controler) {
        interfaceLog = Logger.getLogger("interfaceLog");

        this.tamagoshi = tamagoshi;
        etat = new Label(tamagoshi.parle());
        this.controler = controler;
        reponse = new Label("");

        etat.setMinWidth(width);
        etat.setAlignment(Pos.CENTER);
        reponse.setMinWidth(width);
        reponse.setAlignment(Pos.CENTER);

        tamaDessin = new Canvas(width, height*0.7);
        dessineTama();

        createBoutonJouer();
        createBoutonManger();

        GridPane boutons = new GridPane();
        boutons.getColumnConstraints().add(new ColumnConstraints(width/2));
        boutons.add(boutonManger, 0, 0);
        boutons.add(boutonJouer, 1, 0);
        boutons.setAlignment(Pos.CENTER);

        add(etat, 0, 0);
        add(tamaDessin, 0, 1);
        add(reponse, 0, 2);
        add(boutons, 0, 3);
    }

    /**
     * create a "play" button which will execute the jouer() method on the Tamagoshi when pressed
     */
    private void createBoutonJouer() {
        Button button = new Button("amuser");
        button.setOnMouseClicked(event -> {
            interfaceLog.info("clique sur le bouton 'amuser' de " + tamagoshi.getName());
            if (tamagoshi.jouer()) {
                reponse.setText("c'est vla drôle t'es un bon toi");
            } else {
                reponse.setText("bouge de là tu vois pas jsuis pas dispo");
            }
            refreshEtat();
            controler.tamaAJoue();
        });
        boutonJouer = button;
    }

    /**
     * create a "eat" button which will execute the manger() method on the Tamagoshi when pressed
     */
    private void createBoutonManger() {
        Button button = new Button("nourrir");
        button.setOnMouseClicked(event -> {
            interfaceLog.info("clique sur le bouton 'jouer' de " + tamagoshi.getName());
            if (tamagoshi.manger()) {
                reponse.setText("un régal ce grec");
            } else {
                reponse.setText("j'suis déjà full mon pote");
            }
            refreshEtat();
            controler.tamaAEteNourrit();
        });
        boutonManger = button;
    }

    /**
     * refresh the Tamagoshi's text depending on its feelings and redrow it if he just died
     */
    private void refreshEtat() {
        etat.setText(tamagoshi.parle());
        if ( !tamagoshi.isAlive() && etaitEnVie){
            dessineTamaMort();
            etaitEnVie = false;
        }
    }

    /**
     * draw the Tamagoshi on the canvas
     */
    private void dessineTama() {
        double centerX = tamaDessin.getWidth()/2;
        double centerY = tamaDessin.getHeight()/2;
        Color couleurTama = Color.CADETBLUE;

        Cercle tete = new Cercle(new Point2D(centerX, centerY), tamaDessin.getWidth()/1.5, couleurTama);

        double ecartementYeux = tete.getRayon()/4.5;
        double hauteurYeux = tete.getCentre().getY() - tete.getRayon()/7;
        double tailleYeux = tete.getRayon()/3;

        Cercle oeilG = new Cercle( new Point2D(centerX - ecartementYeux, hauteurYeux), tailleYeux, couleurTama);
        Cercle oeilD = new Cercle( new Point2D(centerX + ecartementYeux, hauteurYeux), tailleYeux, couleurTama);

        double largeurPupille = oeilD.getRayon()*0.15;
        double hauteurPupille = oeilD.getRayon()*0.4;
        Color couleurPupille = Color.DARKOLIVEGREEN;
        Rectangle pupilleG = new Rectangle(oeilG.getCentre().getX() - largeurPupille/2,
                                            oeilG.getCentre().getY() - hauteurPupille/2,
                                            largeurPupille, hauteurPupille, couleurPupille);
        Rectangle pupilleD = new Rectangle(oeilD.getCentre().getX() - largeurPupille/2,
                oeilD.getCentre().getY() - hauteurPupille/2,
                largeurPupille, hauteurPupille, couleurPupille);

        tete.dessineToi(tamaDessin.getGraphicsContext2D());
        oeilG.dessineToi(tamaDessin.getGraphicsContext2D());
        oeilD.dessineToi(tamaDessin.getGraphicsContext2D());
        pupilleG.colorieToi(tamaDessin.getGraphicsContext2D());
        pupilleD.colorieToi(tamaDessin.getGraphicsContext2D());
    }

    /**
     * draw the died Tamagoshi on the canvas
     */
    private void dessineTamaMort() {
        double centerX = tamaDessin.getWidth()/2;
        double centerY = tamaDessin.getHeight()/2;
        Color couleurTama = Color.INDIANRED;

        Cercle tete = new Cercle(new Point2D(centerX, centerY), tamaDessin.getWidth()/1.5, couleurTama);

        double ecartementYeux = tete.getRayon()/4.5;
        double hauteurYeux = tete.getCentre().getY() - tete.getRayon()/7;
        double tailleYeux = tete.getRayon()/4;
        double centreXOeilG = centerX - ecartementYeux;
        double centreXOeilD = centerX + ecartementYeux;
        int epaisseurTrait = 5;

        Trait oeilG1 = new Trait(centreXOeilG-tailleYeux/2, hauteurYeux-tailleYeux/2,
                                centreXOeilG+tailleYeux/2, hauteurYeux+tailleYeux/2,
                couleurTama);
        Trait oeilG2 = new Trait(centreXOeilG-tailleYeux/2, hauteurYeux+tailleYeux/2,
                centreXOeilG+tailleYeux/2, hauteurYeux-tailleYeux/2,
                couleurTama);

        Trait oeilD1 = new Trait(centreXOeilD-tailleYeux/2, hauteurYeux-tailleYeux/2,
                centreXOeilD+tailleYeux/2, hauteurYeux+tailleYeux/2,
                couleurTama);
        Trait oeilD2 = new Trait(centreXOeilD-tailleYeux/2, hauteurYeux+tailleYeux/2,
                centreXOeilD+tailleYeux/2, hauteurYeux-tailleYeux/2,
                couleurTama);

        tamaDessin.getGraphicsContext2D().clearRect(0, 0, tamaDessin.getWidth(), tamaDessin.getHeight());

        tete.dessineToi(tamaDessin.getGraphicsContext2D());
        oeilG1.dessineToi(tamaDessin.getGraphicsContext2D(), epaisseurTrait);
        oeilG2.dessineToi(tamaDessin.getGraphicsContext2D(), epaisseurTrait);
        oeilD1.dessineToi(tamaDessin.getGraphicsContext2D(), epaisseurTrait);
        oeilD2.dessineToi(tamaDessin.getGraphicsContext2D(), epaisseurTrait);
    }

    /**
     * forbid the tamagoshi to eat until reactiveBoutons is called
     */
    public void desactiveBoutonManger() {
        boutonManger.setDisable(true);
        refreshEtat();
    }

    /**
     * forbid the tamagoshi to play until reactiveBoutons is called
     */
    public void desactiveBoutonJouer(){
        boutonJouer.setDisable(true);
        refreshEtat();
    }

    /**
     * allow the tamagoshi to eat and play
     */
    public void reactiveBoutons() {
        if (tamagoshi.isAlive()) {
            boutonJouer.setDisable(false);
            boutonManger.setDisable(false);
        }
        refreshEtat();
    }
}
