module com.example.facecreator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.facecreator to javafx.fxml;
    exports com.example.facecreator;
}