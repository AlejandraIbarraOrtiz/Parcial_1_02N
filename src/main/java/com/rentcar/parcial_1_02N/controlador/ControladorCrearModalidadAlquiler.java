package com.rentcar.parcial_1_02N.controlador;


import com.rentcar.parcial_1_02N.modelo.*;
import com.rentcar.parcial_1_02N.servicio.AdministradorModalidadesAlquiler;
import patronesCreacionales.Modalidad;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class ControladorCrearModalidadAlquiler {

    @FXML private ComboBox<TipoModalidad> cmbTipoModalidad;
    @FXML private ComboBox<Estado> cmbEstado;

    // Datos obligatorios
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextArea txtDescripcion;
    @FXML private TextField txtDuracionMinima;
    @FXML private TextField txtValorDiario;

    // Datos opcionales (Booleans)
    @FXML private CheckBox chkKilometraje;
    @FXML private CheckBox chkSeguroBasico;
    @FXML private CheckBox chkAsistencia;

    // Datos exclusivos de Premium
    @FXML private TextField txtTipoCobertura;
    @FXML private TextField txtConductoresProd;
    @FXML private TextArea txtCaracterísticasEspeciales;
    @FXML private TextField txtDuracionContratada;

    @FXML private Button btnGuardar;

    // Instancia de tu clase de servicio
    private final AdministradorModalidadesAlquiler administrador;

    public ControladorCrearModalidadAlquiler() {
        this.administrador = new AdministradorModalidadesAlquiler();
    }

    @FXML
    public void initialize() {
        // Llenar los ComboBox con los Enums correspondientes
        cmbTipoModalidad.setItems(FXCollections.observableArrayList(TipoModalidad.values()));
        cmbEstado.setItems(FXCollections.observableArrayList(Estado.values()));

        // Listener para habilitar/deshabilitar campos Premium según la selección
        cmbTipoModalidad.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean esPremium = (newVal == TipoModalidad.PREMIUM);
            txtTipoCobertura.setDisable(!esPremium);
            txtConductoresProd.setDisable(!esPremium);
            txtCaracterísticasEspeciales.setDisable(!esPremium);
            txtDuracionContratada.setDisable(!esPremium);
        });
    }

    @FXML
    private void handleGuardarModalidad() {
        try {
            // 1. Validaciones básicas de tipos numéricos
            int duracionMin = Integer.parseInt(txtDuracionMinima.getText());
            double valorDia = Double.parseDouble(txtValorDiario.getText());

            // Valores premium condicionales
            int conductores = txtConductoresProd.getText().isEmpty() ? 0 : Integer.parseInt(txtConductoresProd.getText());
            double duracionContratada = txtDuracionContratada.getText().isEmpty() ? 0.0 : Double.parseDouble(txtDuracionContratada.getText());

            // 2. Construcción del objeto de configuración usando tu patrón Builder
            ModalidadAlquilerBuilder.Builder builderFluido = new ModalidadAlquilerBuilder.Builder(
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    duracionMin,
                    valorDia,
                    cmbEstado.getValue()
            );

            // Se añaden los atributos fluidamente pasados desde los controles de la UI
            ModalidadAlquilerBuilder datosConfigurados = builderFluido
                    .incluyeKilometraje(chkKilometraje.isSelected()) // Usando el nombre exacto de tu clase
                    .incluyeSeguroBasico(chkSeguroBasico.isSelected())
                    .incluyeAsistenciaEnCarretera(chkAsistencia.isSelected())
                    .tipoCobertura(txtTipoCobertura.getText())
                    .conductoresAdicionales(conductores)
                    .caracteristicasEspeciales(txtCaracterísticasEspeciales.getText())
                    .duracionContratada(duracionContratada)
                    .build();

            // 3. Ejecución del patrón Factory a través de tu Administrador
            TipoModalidad tipoSeleccionado = cmbTipoModalidad.getValue();
            Modalidad nuevaModalidad = administrador.crearModalidad(tipoSeleccionado, datosConfigurados);

            // 4. Feedback al usuario
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Modalidad creada correctamente",
                    "Se ha creado una modalidad de tipo: " + nuevaModalidad.getClass().getSimpleName());

            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de formato", "Campos numéricos inválidos",
                    "Por favor verifica que la duración y los valores diarios sean números válidos.");
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo crear", e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtDuracionMinima.clear();
        txtValorDiario.clear();
        chkKilometraje.setSelected(false);
        chkSeguroBasico.setSelected(false);
        chkAsistencia.setSelected(false);
        txtTipoCobertura.clear();
        txtConductoresProd.clear();
        txtCaracterísticasEspeciales.clear();
        txtDuracionContratada.clear();
    }
}
