module tamagoshi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens tamagoshi.graphics to javafx.fxml;
    exports tamagoshi.graphics;
    exports tamagoshi.jeu;
}