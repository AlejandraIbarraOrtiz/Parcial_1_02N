package com.rentcar.parcial_1_02N.modelo;

import patronesCreacionales.Modalidad;

public class ModalidadAlquilerEconomica implements Modalidad {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMinima; // Días
    private double valorDiario;
    private Estado estado;
    private boolean incluyeKilometraje;
    private boolean incluyeSeguroBasico;
    private boolean incluyeAsistenciaEnCarretera;

    public ModalidadAlquilerEconomica
            (String codigo,
             String nombre,
             String descripcion,
             int duracionMinima,
             double valorDiario,
             Estado estado,
             boolean incluyeKilometraje,
             boolean incluyeSeguroBasico,
             boolean incluyeAsistenciaEnCarretera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinima = duracionMinima;
        this.valorDiario = valorDiario;
        this.estado = estado;
        this.incluyeKilometraje = incluyeKilometraje;
        this.incluyeSeguroBasico = incluyeSeguroBasico;
        this.incluyeAsistenciaEnCarretera = incluyeAsistenciaEnCarretera;
    }


    @Override
    public ModalidadAlquilerBuilder definirModalidad() {
        return new ModalidadAlquilerBuilder.Builder(codigo,nombre,descripcion,duracionMinima, valorDiario, estado)
                .incluyeAsistenciaEnCarretera(incluyeAsistenciaEnCarretera)
                .incluyeSeguroBasico(incluyeSeguroBasico)
                .incluyeKilometraje(incluyeKilometraje)
                .build();
    }
}
