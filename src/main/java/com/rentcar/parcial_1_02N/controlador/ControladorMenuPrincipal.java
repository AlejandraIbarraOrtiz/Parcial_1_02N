package com.rentcar.parcial_1_02N.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorMenuPrincipal {

    @FXML
    private void abrirGestionClientes() throws IOException {

        //Carga la vista de gestión de clientes
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaGestionarClientes.fxml"));

        Stage ventana = new Stage();

        ventana.setScene(new Scene(root, 600, 400));
        ventana.setTitle("Gestión de Clientes");
        ventana.show();
    }

    @FXML
    private void abrirGestionVehiculos() {

        System.out.println("Abrir gestión vehículos");
    }

    @FXML
    private void abrirGestionAlquileres() {

        System.out.println("Abrir gestión alquileres");
    }

    @FXML void abrirReservas(){

        System.out.println("Abrir reservas");
    }

    @FXML void abrirServicios(){

        System.out.println("Abrir servicios adicionales");
    }
}
