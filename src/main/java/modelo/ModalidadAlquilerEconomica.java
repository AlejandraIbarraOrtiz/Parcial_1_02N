package modelo;

import patronesCreacionales.Modalidad;
import patronesCreacionales.ModalidadAlquilerFactory;

public class ModalidadAlquilerEconomica implements Modalidad {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMinima; // Días
    private double valorDiario;
    private Estado estado;

    public ModalidadAlquilerEconomica(String codigo, String nombre, String descripcion, int duracionMinima, double valorDiario, Estado estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinima = duracionMinima;
        this.valorDiario = valorDiario;
        this.estado = estado;
    }


    @Override
    public ModalidadAlquilerBuilder definirModalidad() {
        return new ModalidadAlquilerBuilder.Builder(codigo,nombre,descripcion,duracionMinima, valorDiario, estado)
                .incluyeAsistenciaEnCarretera(true)
                .incluyeSeguroBasico(false)
                .incuyeKilometarje(false)
                .build();
    }
}
