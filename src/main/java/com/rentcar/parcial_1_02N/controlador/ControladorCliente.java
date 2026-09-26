package com.rentcar.parcial_1_02N.controlador;

import com.rentcar.parcial_1_02N.modelo.Cliente;
import com.rentcar.parcial_1_02N.modelo.RentCarSingleton;
import com.rentcar.parcial_1_02N.servicio.AdministradorClientes;
import com.rentcar.parcial_1_02N.validador.ClienteValidador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class ControladorCliente {

    //Campos de texto de la vista Agregar Cliente
    @FXML private TextField txtNombre;
    @FXML private TextField txtId;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtEdad;
    @FXML private VBox contenedorPrincipal;

    //Amdin operaciones relacionadas con clientes
    private AdministradorClientes administradorClientes = RentCarSingleton.getInstancia().getAdministradorClientes();


    //Toma los datos de la vista y agrega un nuevo cliente
    @FXML
    private void onAgregarCliente(){

        //Verifica que ningún campo esté vacío
        if (txtNombre.getText().trim().isEmpty() || txtId.getText().trim().isEmpty() ||
                txtTelefono.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() ||
                txtEdad.getText().trim().isEmpty()){

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Todos los campos son obligatorios");
            alerta.show();

            return;
        }

        try {

            //Convertir edad a int
            int edad = Integer.parseInt(txtEdad.getText());

            //Verifica que la edad sea mayor a cero
            if (edad < 18){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("Debe ser mayor de edad.");
                alerta.showAndWait();

                return;

            }

            //Verifica que el ID contenga solamente números
            if (!ClienteValidador.validarId(txtId.getText())){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("El ID solo puede contener números");
                alerta.showAndWait();

                return;
            }

            //Verifica que el teléfono tenga exactamente 10 digitos
            if (!ClienteValidador.validarTelefono(txtTelefono.getText())){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("El teléfono debe contener exactamente 10 dígitos y solo puede contener números");
                alerta.showAndWait();

                return;
            }

            //Verifica que el correo tenga un formato válido
            if (!ClienteValidador.validarCorreo(txtCorreo.getText())){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("El correo electrónico no tiene un formato válido");
                alerta.showAndWait();

                return;
            }

            //Crear cliente con los datos ingresados en la vista
            Cliente cliente = new Cliente(txtNombre.getText(), txtId.getText(), txtTelefono.getText(),
                    txtCorreo.getText(), edad, LocalDate.now());

            //Intenta agregar el cliente mediante AdministradorClientes
            if (administradorClientes.agregarCliente(cliente)){

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Operación exitosa");
                alerta.setHeaderText(null);
                alerta.setContentText("Cliente agregado exitosamente");
                alerta.showAndWait();

                limpiarCampos();
            }else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("Datos inválidos o ID ya registrado");
                alerta.showAndWait();
            }
        }catch (NumberFormatException excepcion){

            //Se ejecuta cuando la edad contiene letras o no es un número entero
            Alert alerta =  new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("La edad debe contener solamente números");
            alerta.showAndWait();
        }
    }

    //Metodo para limpiar los campos del formulario luego de agregar un cliente
    private void limpiarCampos() {

        txtNombre.clear();
        txtId.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtEdad.clear();
    }

    @FXML
    private void volverGestionClientes() throws IOException{

        //Carga la vista para gestionar clientes
        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/rentcar/parcial_1_02N/vista/VistaGestionarClientes.fxml"));

        //Obtiene la ventana actual
        Stage ventana = (Stage) contenedorPrincipal.getScene().getWindow();

        //Cambia el contenido de la ventana
        ventana.setScene(new Scene(root, 600, 400));

        //Cambia el título de la ventana
        ventana.setTitle("Gestión de Clientes");
    }
}