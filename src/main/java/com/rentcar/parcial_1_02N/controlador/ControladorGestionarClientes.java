package com.rentcar.parcial_1_02N.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorGestionarClientes {

    //Contenedor principal de la vista
    @FXML
    private VBox contenedorPrincipal;

    //Abre la vista para agregar clientes
    @FXML
    private void abrirAgregarCliente() throws IOException{

        //Carga la vista para agregar un cliente
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaAgregarCliente.fxml"));

        //Obtiene la ventana actual
        Stage ventana = (Stage) contenedorPrincipal.getScene().getWindow();

        //Cambia el contenido de la ventana
        ventana.setScene(new Scene(root, 600, 400));

        //Cambia el título de la ventana
        ventana.setTitle("Agregar Cliente");
    }

    //Abre la vista para modificar un cliente
    @FXML
    private void abrirModificarCliente() throws IOException{

        //Carga la vista para modificar un cliente
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaModificarCliente.fxml"));

        //Obtiene la ventana actual
        Stage ventana = (Stage) contenedorPrincipal.getScene().getWindow();

        //Cambia el contenido de la ventana
        ventana.setScene(new Scene(root, 600, 400));

        //Cambia el título de la ventana
        ventana.setTitle("Modificar cliente");
    }

    // Abre la vista para eliminar un cliente
    @FXML
    private void abrirEliminarCliente() {
        System.out.println("Abrir eliminar cliente");
    }

    // Regresa al menú principal
    @FXML
    private void volverMenuPrincipal() {
        System.out.println("Volver al menú principal");
    }
}
