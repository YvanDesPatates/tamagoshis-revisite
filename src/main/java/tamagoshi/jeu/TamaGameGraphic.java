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

package tamagoshi.jeu;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tamagoshi.graphics.TamaFrame;
import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.util.FileStore;
import tamagoshi.util.RandomGenerator;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/**
 * this class handle the main window and the game system by intercepting tamahgoshi's interactions
 */
public class TamaGameGraphic{
    private GridPane root;
    int nbTama;
    List<TamaFrame> tamaFrames = new ArrayList<>();
    List<Tamagoshi> tamagoshis = new ArrayList<>();
    int nbTour = 1;
    private boolean choixManger;
    private boolean choixJouer;
    TextArea derouleJeux;
    private final Logger gameLog;
    private final Stage primaryStage;
    private static ResourceBundle messages;

    /**
     * @param primaryStage has to be the primaryStage given by JavaFX to the Application
     */
    public TamaGameGraphic(Stage primaryStage) {
        gameLog = Logger.getLogger("gameLog");
        this.primaryStage = primaryStage;
        initialisationFenetre();

        affichageSelectionLangue();

        primaryStage.setOnCloseRequest(event -> Platform.exit());
    }

    private void affichageSelectionLangue() {
        AtomicReference<Locale> locale = new AtomicReference<>(Locale.getDefault());

        Button frButton = new Button("français");
        frButton.setOnAction( event -> locale.set(Locale.FRENCH));
        Button enButton = new Button("english");
        enButton.setOnAction( event -> locale.set(Locale.ENGLISH));

        Button okButton = new Button("ok");
        okButton.setOnAction( event -> {
            messages = ResourceBundle.getBundle("messages", locale.get());
            root.getChildren().clear();
            affichagePourCreationTamagoshis();
        });

        root.add(frButton, 0, 0);
        root.add(enButton,1, 0);
        root.add(okButton, 1, 1);
        root.setAlignment(Pos.CENTER);
    }

    /**
     * show the main window that allow the user to play
     */
    public void show(){
        primaryStage.show();
    }

    /**
     * initialise window
     */
    private void initialisationFenetre() {
        root = new GridPane();
        Scene scene = new Scene(root, 550, 200);
        primaryStage.setTitle("accueil");
        primaryStage.setScene(scene);
    }

    /**
     * set the necessary content in the main window to create the tamagoshis we will play with
     */
    private void affichagePourCreationTamagoshis() {
        gameLog.info("choix du nombre de tamagoshis");
        Map<Integer, Button> boutons = new HashMap<>(Map.of(
                2, new Button("2"),
                4, new Button("4"),
                6, new Button("6"),
                8, new Button("8")
        ));

        nbTama = FileStore.getInstance().getNbTama();
        Label prefix = new Label(messages.getString("nbChoisi"));
        Label nbTamaText = new Label(": "+nbTama);

        boutons.forEach((nb, button) -> button.setOnAction(e -> {
            nbTama = nb;
            nbTamaText.setText(": "+nb);
        }));

        Button ok = new Button("ok");
        ok.setOnAction(event -> {
            try {
                FileStore.getInstance().saveNbTama(nbTama);
            } catch (Exception e){
                gameLog.info(e.getMessage());
            }
            creationTamas();
            lancementPartie();
        });

        boutons.forEach((nb, bouton) -> {
            root.add(bouton, nb / 2, 0);
            root.getColumnConstraints().add(new ColumnConstraints(primaryStage.getScene().getWidth() / 6 ));
        } );
        root.add(prefix, 2, 2);
        root.add(nbTamaText, 3, 2);
        root.add(ok, 2, 3);
        root.setAlignment(Pos.CENTER);
    }

    /**
     * set the necessary content in the main window to display information to the player during the game
     */
    private void lancementPartie() {
        Tamagoshi.setLifeTime(5);
        derouleJeux = new TextArea();
        derouleJeux.setOnInputMethodTextChanged(event -> derouleJeux.setScrollTop(Double.MAX_VALUE));

        root.getChildren().clear();
        root.add(derouleJeux, 0, 0);
        root.getColumnConstraints().clear();

        afficherTextLogEtPartie("\n -- "+messages.getString("dureePartie")+" " + Tamagoshi.getLifeTime() + " "+messages.getString("tour")+" --");
        afficherTextLogEtPartie("\n -- "+messages.getString("debutTour")+" n°" + nbTour + " --");
    }

    /**
     * generate nbTama Tamagoshis and graphically launch them
     */
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

    /**
     * Method called by a Tamagoshi window after being feed
     */
    public void tamaAEteNourrit() {
        if (!choixManger) {
            tamaFrames.forEach(TamaFrame::desactiveBoutonManger);
            choixManger = true;
        }
        tourSuivant();
    }

    /**
     * Method called by a Tamagoshi window after being amused
     */
    public void tamaAJoue() {
        tamaFrames.forEach(TamaFrame::desactiveBoutonJouer);
        choixJouer = true;
        tourSuivant();
    }

    /**
     * when a Tama has ate and a Tama has played, this method put in place the end of the round and the start of the following one
     */
    private void tourSuivant() {
        if (choixManger && choixJouer) {
            if (auMoinsUnTamaEstVivant() && nbTour < Tamagoshi.getLifeTime()) {
                nbTour++;
                choixJouer = false;
                choixManger = false;
                afficherTextLogEtPartie("\n -- "+ messages.getString("debutTour")+" n°" + nbTour + " --");
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
            String prefix = "\n" + tamagoshi.getClass().getSimpleName() + " " + tamagoshi.getName();
            if (tamagoshi.isAliveWithoutCountingAge())
                afficherTextLogEtPartie(prefix +" "+ messages.getString("survivant"));
            else
                afficherTextLogEtPartie(prefix +" "+ messages.getString("mort"));
        }
        afficherTextLogEtPartie("\n ----------- Score ------------------- \nscore : " + score() + " %");
    }

    /**
     * calculate the score depending the longevity of each Tama
     * @return the score of the player
     */
    private double score() {
        double sommeScoresTama = 0;
        for (Tamagoshi tamagoshi : tamagoshis) {
            sommeScoresTama += (double) tamagoshi.getAge() * 100 / Tamagoshi.getLifeTime();
        }
        return sommeScoresTama / tamagoshis.size();
    }

    /**
     * @return true if at least one Tamagoshi is steel alive
     */
    private boolean auMoinsUnTamaEstVivant() {
        boolean survivant = false;
        for (Tamagoshi tamagoshi : tamagoshis) {
            if (tamagoshi.isAlive()) {
                survivant = true;
                break;
            }
        }
        return survivant;
    }

    /**
     * convenient method to both display and log a text
     */
    private void afficherTextLogEtPartie(String text) {
        derouleJeux.appendText(text);
        gameLog.info(text);
    }

    public static ResourceBundle getMessages() {
        return messages;
    }
}
