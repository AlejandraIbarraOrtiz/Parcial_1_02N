package com.rentcar.parcial_1_02N.controlador;

import com.rentcar.parcial_1_02N.modelo.Cliente;
import com.rentcar.parcial_1_02N.modelo.RentCarSingleton;
import com.rentcar.parcial_1_02N.servicio.AdministradorClientes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorBuscarCliente {

    @FXML private TextField txtTelefono;
    @FXML private VBox contenedorPrincipal;

    //Obtiene el administrador de clientes desde la única instancia de RentCar
    private AdministradorClientes administradorClientes = RentCarSingleton.getInstancia().getAdministradorClientes();

    //Buscar un cliente mediante su número de teléfono
    @FXML
    private void buscarCliente(){

        //Verifica que el campo teléfono no esté vacío
        if (txtTelefono.getText().trim().isEmpty()) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Debe ingresar el teléfono del cliente");
            alerta.showAndWait();

            return;
        }

        //Busca el cliente mediante AdministradorClientes
        Cliente cliente = administradorClientes.buscarClienteTelefono(txtTelefono.getText());

        //Verifica si el cliente fue encontrado
        if (cliente != null){

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cliente encontrado");
            alerta.setHeaderText(null);

            alerta.setContentText(
                    "Nombre: " + cliente.getNombre() +
                    "\nID: " + cliente.getId() +
                    "\nTeléfono: " + cliente.getTelefono() +
                    "\nCorreo: " + cliente.getCorreo() +
                    "\nEdad: " + cliente.getEdad() +
                    "\nFecha de registro: " + cliente.getFechaRegistro()
            );

            alerta.showAndWait();
        }else {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Cliente no encontrado");
            alerta.showAndWait();
        }
    }

    //Regresa a la vista para gestionar clientes
    @FXML
    private void volverGestionClientes() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaGestionarClientes.fxml"));

        Stage ventana = (Stage) contenedorPrincipal.getScene().getWindow();

        ventana.setScene(new Scene(root, 600, 400));
        ventana.setTitle("Gestión de clientes");
    }
}
