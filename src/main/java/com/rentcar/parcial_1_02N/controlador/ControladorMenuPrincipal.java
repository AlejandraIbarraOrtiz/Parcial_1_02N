package com.rentcar.parcial_1_02N.controlador;

import javafx.fxml.FXML;

public class ControladorMenuPrincipal {

    @FXML
    private void abrirGestionClientes() {

        System.out.println("Abrir gestión de clientes");
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
