package com.rentcar.parcial_1_02N.controlador;

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

public class ControladorEliminarCliente {

    //Campos de la vista eliminar cliente
    @FXML private TextField txtId;
    @FXML private VBox contenedorPrincipal;

    //Obtiene el administrador de clientes desde la única instancia de RentCar
    private AdministradorClientes administradorClientes = RentCarSingleton.getInstancia().getAdministradorClientes();

    //Elimina un cliente usando su ID
    @FXML
    private void eliminarCliente(){

        //Verifica que el campo ID no este vacío
        if (txtId.getText().trim().isEmpty()){

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Debe ingresar el ID del cliente");
            alerta.showAndWait();

            return;
        }

        //Intenta eliminar el cliente mediante AdministradorCLientes
        boolean eliminado = administradorClientes.eliminarCliente(txtId.getText());

        if (eliminado){

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Operación exitosa");
            alerta.setHeaderText(null);
            alerta.setContentText("Cliente eliminado exitosamente");
            alerta.showAndWait();

            txtId.clear();
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

        Stage ventana = (Stage)  contenedorPrincipal.getScene().getWindow();

        ventana.setScene(new Scene(root,600, 400));
        ventana.setTitle("Gestión de Clientes");

    }
}
