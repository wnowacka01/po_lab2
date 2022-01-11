module wyszukiwarka.wyszukiwarka {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires persistence.api;
    requires java.sql;

    opens wyszukiwarka to javafx.fxml;
    exports wyszukiwarka;
    exports wyszukiwarka.Controller;
    exports wyszukiwarka.Config;
    opens wyszukiwarka.Controller to javafx.fxml;

}