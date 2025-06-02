module br.pucpr.chamuzejava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens br.pucpr.chamuzejava to javafx.fxml;
    exports br.pucpr.chamuzejava.app;
}