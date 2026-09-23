module com.biblioteca.parcial_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.biblioteca.parcial_1 to javafx.fxml;
    exports com.biblioteca.parcial_1;
}