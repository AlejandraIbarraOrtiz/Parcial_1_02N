package com.rentcar.parcial_1_02N.controlador;

import com.rentcar.parcial_1_02N.modelo.Vehiculo;
import com.rentcar.parcial_1_02N.servicio.AdministradorVehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class ControladorGestionarVehiculos {

    @FXML private TableView<Vehiculo> tblVehiculos;
    @FXML private TableColumn<Vehiculo, String> colPlaca;
    @FXML private TableColumn<Vehiculo, String> colMarca;
    @FXML private TableColumn<Vehiculo, Integer> colModelo;
    @FXML private TableColumn<Vehiculo, Integer> colAnio;
    @FXML private TableColumn<Vehiculo, String> colTipo;
    @FXML private TableColumn<Vehiculo, Double> colTarifa;

    @FXML private TextField txtPlaca;
    @FXML private TextField txtMarca;
    @FXML private TextField txtModelo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtTipo;
    @FXML private TextField txtTarifa;

    private final AdministradorVehiculo administrador;
    private final ObservableList<Vehiculo> vehiculosObservable;

    public ControladorGestionarVehiculos() {
        this.administrador = new AdministradorVehiculo();
        this.vehiculosObservable = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        // Enlazar columnas con las propiedades del objeto Vehiculo
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifaDiaria"));

        refrescarTabla();

        // Cargar datos en el formulario al seleccionar una fila
        tblVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtPlaca.setText(newSelection.getPlaca());
                txtMarca.setText(newSelection.getMarca());
                txtModelo.setText(String.valueOf(newSelection.getModelo()));
                txtAnio.setText(String.valueOf(newSelection.getAnio()));
                txtTipo.setText(newSelection.getTipo());
                txtTarifa.setText(String.valueOf(newSelection.getTarifaDiaria()));
            }
        });
    }

    @FXML
    private void handleCrear() {
        try {
            Vehiculo nuevo = obtenerVehiculoDesdeFormulario();
            administrador.registrarVehiculo(nuevo);
            refrescarTabla();
            limpiarFormulario();
        } catch (Exception e) {
            mostrarAlerta("Error al crear", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleActualizar() {
        Vehiculo seleccionado = tblVehiculos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un vehículo de la tabla para actualizar.", Alert.AlertType.WARNING);
            return;
        }
        try {
            Vehiculo datosNuevos = obtenerVehiculoDesdeFormulario();
            administrador.actualizarVehiculo(seleccionado.getPlaca(), datosNuevos);
            refrescarTabla();
            limpiarFormulario();
        } catch (Exception e) {
            mostrarAlerta("Error al actualizar", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEliminar() {
        Vehiculo seleccionado = tblVehiculos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un vehículo de la tabla para eliminar.", Alert.AlertType.WARNING);
            return;
        }
        try {
            administrador.eliminarVehiculo(seleccionado.getPlaca());
            refrescarTabla();
            limpiarFormulario();
        } catch (Exception e) {
            mostrarAlerta("Error al eliminar", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleClonarPrototype() {
        Vehiculo seleccionado = tblVehiculos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Seleccione un vehículo en la tabla para usarlo como prototipo base.", Alert.AlertType.WARNING);
            return;
        }

        // Diálogo para solicitar la nueva placa para el clon
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Clonar Vehículo (Prototype)");
        dialogo.setHeaderText("Prototipo Base Seleccionado: " + seleccionado.getMarca() + " (" + seleccionado.getPlaca() + ")");
        dialogo.setContentText("Ingrese la placa del nuevo vehículo clonado:");

        Optional<String> resultado = dialogo.showAndWait();
        resultado.ifPresent(nuevaPlaca -> {
            if (nuevaPlaca.trim().isEmpty()) {
                mostrarAlerta("Error", "La placa no puede estar vacía.", Alert.AlertType.ERROR);
                return;
            }
            try {
                administrador.clonarVehiculoExistente(seleccionado.getPlaca(), nuevaPlaca.trim().toUpperCase());
                refrescarTabla();
                mostrarAlerta("Éxito", "Vehículo clonado mediante el patrón Prototype correctamente.", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Error al clonar", e.getMessage(), Alert.AlertType.ERROR);
            }
        });
    }

    private Vehiculo obtenerVehiculoDesdeFormulario() {
        return new Vehiculo(
                txtPlaca.getText().trim().toUpperCase(),
                txtMarca.getText().trim(),
                Integer.parseInt(txtModelo.getText().trim()),
                Integer.parseInt(txtAnio.getText().trim()),
                txtTipo.getText().trim(),
                Double.parseDouble(txtTarifa.getText().trim())
        );
    }

    private void refrescarTabla() {
        vehiculosObservable.setAll(administrador.obtenerTodosLosVehiculos());
        tblVehiculos.setItems(vehiculosObservable);
    }

    private void limpiarFormulario() {
        txtPlaca.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtAnio.clear();
        txtTipo.clear();
        txtTarifa.clear();
        tblVehiculos.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
