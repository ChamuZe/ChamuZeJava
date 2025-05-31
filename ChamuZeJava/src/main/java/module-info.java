module br.pucpr.chamuzejava {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.pucpr.chamuzejava to javafx.fxml;
    exports br.pucpr.chamuzejava;
}