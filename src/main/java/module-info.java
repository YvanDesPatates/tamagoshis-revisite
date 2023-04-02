module tamagoshi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;

    exports tamagoshi;

    exports tamagoshi.tamagoshis;
    exports tamagoshi.graphics;
    exports tamagoshi.jeu;
    exports tamagoshi.util;
}