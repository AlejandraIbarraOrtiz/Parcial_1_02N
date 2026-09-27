module com.rentcar.parcial_1_02N {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.rentcar.parcial_1_02N.controlador to javafx.fxml;
    exports com.rentcar.parcial_1_02N;

    // 1. Esto permite que JavaFX cargue las vistas asociadas a tus controladores
    opens com.rentcar.parcial_1_02N to javafx.fxml;

    // 2. SOLUCIÓN AL ERROR: Abre el modelo para que la TableView lea las propiedades por reflexión
    opens com.rentcar.parcial_1_02N.modelo to javafx.base;
}