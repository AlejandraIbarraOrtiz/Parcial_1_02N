module com.rentcar.parcial_1_02N {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rentcar.parcial_1_02N to javafx.fxml;
    exports com.rentcar.parcial_1_02N;
}