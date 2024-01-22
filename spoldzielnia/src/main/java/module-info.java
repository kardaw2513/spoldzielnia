module core.spoldzielnia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens core to javafx.fxml;
    opens Controllers to javafx.fxml;
    exports core;
    exports DataClasses;
    exports Controllers;
    opens DataClasses to javafx.fxml;
}