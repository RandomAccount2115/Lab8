module pl.lublin.java.lab8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.lublin.java.lab8 to javafx.fxml;
    exports pl.lublin.java.lab8;
}