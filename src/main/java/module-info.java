module tamagoshi.graphics {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens tamagoshi.graphics to javafx.fxml;
    exports tamagoshi.graphics;
}