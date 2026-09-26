module com.rentcar.parcial_1_02N {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< HEAD
    requires com.rentcar.parcial_1_02N;
=======
    requires java.desktop;
>>>>>>> 17fc44f9809b5af150e31d87f6833c307a8e6e74


    opens com.rentcar.parcial_1_02N.controlador to javafx.fxml;
    exports com.rentcar.parcial_1_02N;
}