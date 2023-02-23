package tamagoshi.graphics;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import tamagoshi.tamagoshis.Tamagoshi;

public class TamaJPanel extends GridPane {
    private final Label etat;
    private final Tamagoshi tamagoshi;
    private final Label reponse;
    private final Canvas tamaDessin;


    public TamaJPanel(Tamagoshi tamagoshi, double width, double height) {
        this.tamagoshi = tamagoshi;
        etat = new Label(tamagoshi.parle());
        reponse = new Label("reponse en bas de page");

        etat.setMinWidth(width);
        etat.setAlignment(Pos.CENTER);
        reponse.setMinWidth(width);
        reponse.setAlignment(Pos.CENTER);

        tamaDessin = new Canvas(width, height*0.8);
        dessineTama();

        GridPane boutons = new GridPane();
        boutons.getColumnConstraints().add(new ColumnConstraints(width/2));
        boutons.add(boutonManger(), 0, 0);
        boutons.add(boutonJouer(), 1, 0);
        boutons.setAlignment(Pos.CENTER);

        add(etat, 0, 0);
        add(tamaDessin, 0, 1);
        add(reponse, 0, 2);
        add(boutons, 0, 3);
    }

    private Node boutonJouer() {
        Button button = new Button("amuser");
        button.setOnMouseClicked(event -> {
            if (tamagoshi.jouer()) {
                reponse.setText("c'est vla drôle t'es un bon toi");
            } else {
                reponse.setText("bouge de là tu vois pas jsuis pas dispo");
            }
            refreshEtat();
        });
        return button;
    }

    private Button boutonManger() {
        Button button = new Button("nourrir");
        button.setOnMouseClicked(event -> {
            if (tamagoshi.manger()) {
                reponse.setText("un régal ce grec");
            } else {
                reponse.setText("j'suis déjà full mon pote");
            }
            refreshEtat();
        });
        return button;
    }

    private void refreshEtat() {
        etat.setText(tamagoshi.parle());
    }

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
}
