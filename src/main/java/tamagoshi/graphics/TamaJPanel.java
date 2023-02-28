/*
 *  * GNU LESSER GENERAL PUBLIC LICENSE
 *  * Version 3, 29 June 2007
 *  *
 *  * Copyright © 2007 Free Software Foundation, Inc. <https://fsf.org/>
 *  *
 *  * Everyone is permitted to copy and distribute verbatim copies of this license document, but changing it is not allowed.
 *  *
 *  * This version of the GNU Lesser General Public License incorporates the terms and conditions of version 3 of the GNU General Public License, supplemented by the additional permissions listed below.
 *  *
 *  * 0. Additional Definitions.
 *  * As used herein, “this License” refers to version 3 of the GNU Lesser General Public License, and the “GNU GPL” refers to version 3 of the GNU General Public License.
 *  *
 *  * “The Library” refers to a covered work governed by this License, other than an Application or a Combined Work as defined below.
 *  *
 *  * An “Application” is any work that makes use of an interface provided by the Library, but which is not otherwise based on the Library. Defining a subclass of a class defined by the Library is deemed a mode of using an interface provided by the Library.
 *  *
 *  * A “Combined Work” is a work produced by combining or linking an Application with the Library. The particular version of the Library with which the Combined Work was made is also called the “Linked Version”.
 *  *
 *  * The “Minimal Corresponding Source” for a Combined Work means the Corresponding Source for the Combined Work, excluding any source code for portions of the Combined Work that, considered in isolation, are based on the Application, and not on the Linked Version.
 *  *
 *  * The “Corresponding Application Code” for a Combined Work means the object code and/or source code for the Application, including any data and utility programs needed for reproducing the Combined Work from the Application, but excluding the System Libraries of the Combined Work.
 *  *
 *  * 1. Exception to Section 3 of the GNU GPL.
 *  * You may convey a covered work under sections 3 and 4 of this License without being bound by section 3 of the GNU GPL.
 *  *
 *  * 2. Conveying Modified Versions.
 *  * If you modify a copy of the Library, and, in your modifications, a facility refers to a function or data to be supplied by an Application that uses the facility (other than as an argument passed when the facility is invoked), then you may convey a copy of the modified version:
 *  *
 *  * a) under this License, provided that you make a good faith effort to ensure that, in the event an Application does not supply the function or data, the facility still operates, and performs whatever part of its purpose remains meaningful, or
 *  * b) under the GNU GPL, with none of the additional permissions of this License applicable to that copy.
 *  * 3. Object Code Incorporating Material from Library Header Files.
 *  * The object code form of an Application may incorporate material from a header file that is part of the Library. You may convey such object code under terms of your choice, provided that, if the incorporated material is not limited to numerical parameters, data structure layouts and accessors, or small macros, inline functions and templates (ten or fewer lines in length), you do both of the following:
 *  *
 *  * a) Give prominent notice with each copy of the object code that the Library is used in it and that the Library and its use are covered by this License.
 *  * b) Accompany the object code with a copy of the GNU GPL and this license document.
 *  * 4. Combined Works.
 *  * You may convey a Combined Work under terms of your choice that, taken together, effectively do not restrict modification of the portions of the Library contained in the Combined Work and reverse engineering for debugging such modifications, if you also do each of the following:
 *  *
 *  * a) Give prominent notice with each copy of the Combined Work that the Library is used in it and that the Library and its use are covered by this License.
 *  * b) Accompany the Combined Work with a copy of the GNU GPL and this license document.
 *  * c) For a Combined Work that displays copyright notices during execution, include the copyright notice for the Library among these notices, as well as a reference directing the user to the copies of the GNU GPL and this license document.
 *  * d) Do one of the following:
 *  * 0) Convey the Minimal Corresponding Source under the terms of this License, and the Corresponding Application Code in a form suitable for, and under terms that permit, the user to recombine or relink the Application with a modified version of the Linked Version to produce a modified Combined Work, in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.
 *  * 1) Use a suitable shared library mechanism for linking with the Library. A suitable mechanism is one that (a) uses at run time a copy of the Library already present on the user's computer system, and (b) will operate properly with a modified version of the Library that is interface-compatible with the Linked Version.
 *  * e) Provide Installation Information, but only if you would otherwise be required to provide such information under section 6 of the GNU GPL, and only to the extent that such information is necessary to install and execute a modified version of the Combined Work produced by recombining or relinking the Application with a modified version of the Linked Version. (If you use option 4d0, the Installation Information must accompany the Minimal Corresponding Source and Corresponding Application Code. If you use option 4d1, you must provide the Installation Information in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.)
 *  * 5. Combined Libraries.
 *  * You may place library facilities that are a work based on the Library side by side in a single library together with other library facilities that are not Applications and are not covered by this License, and convey such a combined library under terms of your choice, if you do both of the following:
 *  *
 *  * a) Accompany the combined library with a copy of the same work based on the Library, uncombined with any other library facilities, conveyed under the terms of this License.
 *  * b) Give prominent notice with the combined library that part of it is a work based on the Library, and explaining where to find the accompanying uncombined form of the same work.
 *  * 6. Revised Versions of the GNU Lesser General Public License.
 *  * The Free Software Foundation may publish revised and/or new versions of the GNU Lesser General Public License from time to time. Such new versions will be similar in spirit to the present version, but may differ in detail to address new problems or concerns.
 *  *
 *  * Each version is given a distinguishing version number. If the Library as you received it specifies that a certain numbered version of the GNU Lesser General Public License “or any later version” applies to it, you have the option of following the terms and conditions either of that published version or of any later version published by the Free Software Foundation. If the Library as you received it does not specify a version number of the GNU Lesser General Public License, you may choose any version of the GNU Lesser General Public License ever published by the Free Software Foundation.
 *  *
 *  * If the Library as you received it specifies that a proxy can decide whether future versions of the GNU Lesser General Public License shall apply, that proxy's public statement of acceptance of any version is permanent authorization for you to choose that version for the Library.
 *
 */

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
