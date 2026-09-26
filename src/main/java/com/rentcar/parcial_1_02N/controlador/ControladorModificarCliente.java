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

public class ControladorModificarCliente {

    @FXML private TextField txtId;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private VBox contenedorPrincipal;

    //Obtiene el administrador de clientes desde la única instancia de RentCar
    private AdministradorClientes administradorClientes = RentCarSingleton.getInstancia().getAdministradorClientes();

    //Modifica el télefono y correo de un cliente
    @FXML
    private void modificarCliente() {

        //Verifica que ningún campo este vacío
        if (txtId.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty() ||
                txtCorreo.getText().trim().isEmpty()) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Todos los campos son obligatorios");
            alerta.showAndWait();

            return;
        }

        //Intenta modificar el cliente usando su ID
        boolean modificado = administradorClientes.modificarCliente(txtId.getText(), txtTelefono.getText(),
                txtCorreo.getText());

        if (modificado) {

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Operación exitosa");
            alerta.setHeaderText(null);
            alerta.setContentText("Cliente modificado exitosamente");
            alerta.showAndWait();

            limpiarCampos();

        } else {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Cliente no encontrado o datos inválidos");
            alerta.showAndWait();
        }
    }

    //Metodo para limpiar los campos del formulario
    private void limpiarCampos() {
        txtId.clear();
        txtTelefono.clear();
        txtCorreo.clear();
    }

    //Volver a gestión de clientes
    @FXML
    private void volverGestionClientes() throws IOException{

        //Carga la vista para gestionar clientes
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaGestionarClientes.fxml"));

        //Obtiene la vista actual
        Stage ventana = (Stage) contenedorPrincipal.getScene().getWindow();


        //Cambia el contenido de la ventana
        ventana.setScene(new Scene(root, 600,400));

        //Cambia el título de la ventana
        ventana.setTitle("Gestión de Clientes");
    }
}
