package com.rentcar.parcial_1_02N.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorMenuPrincipal {

    @FXML
    private void abrirGestionModalidades() throws IOException {
        // Usamos el cargador asegurando la ruta absoluta del recurso empaquetado
        FXMLLoader cargador = new FXMLLoader(getClass().getResource("/com/rentcar/parcial_1_02N/vista/VistaModalidades.fxml"));
        Parent root = cargador.load();

        Stage ventana = new Stage();
        ventana.setScene(new Scene(root, 650, 600));
        ventana.setTitle("Configuración de Modalidades de Alquiler (Factory + Builder)");
        ventana.show();
    }


    @FXML
    private void abrirGestionClientes() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaGestionarClientes.fxml"));
        Stage ventana = new Stage();
        ventana.setScene(new Scene(root, 600, 400));
        ventana.setTitle("Gestión de Clientes");
        ventana.show();
    }

    @FXML
    private void abrirGestionVehiculos() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaGestionarVehiculos.fxml"));

        Stage ventana = new Stage();
        ventana.setScene(new Scene(root, 750, 450));
        ventana.setTitle("Gestión de Vehículos - Patrón Prototype");
        ventana.show();
    }


    @FXML
    private void abrirGestionAlquileres() {
        System.out.println("Abrir gestión alquileres");
    }

    @FXML
    void abrirReservas(){
        System.out.println("Abrir reservas");
    }

    @FXML
    void abrirServicios(){
        System.out.println("Abrir servicios adicionales");
    }
}

