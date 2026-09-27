package com.rentcar.parcial_1_02N.validador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// CORRECCIÓN: Volvemos a ponerle el nombre exacto del archivo físico para quitar lo rojo
public class AplicacionRentCar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/rentcar/parcial_1_02N/vista/VistaMenuPrincipal.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Sistema RentCar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
