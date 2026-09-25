module com.rentcar.parcial_1_02N {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.rentcar.parcial_1_02N.controlador to javafx.fxml;
    exports com.rentcar.parcial_1_02N;
}