module core.spoldzielnia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens core to javafx.fxml;
    exports core;
}