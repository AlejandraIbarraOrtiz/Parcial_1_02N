package com.rentcar.parcial_1_02N.modelo;

import patronesCreacionales.Modalidad;

public class ModalidadAlquilerPremium implements Modalidad {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMinima; // Días
    private double valorDiario;
    private Estado estado;
    private String tipoCobertura;
    private int conductoresAdicionales;
    private String caracteristicasEspeciales;
    private double duracionContratada;

    public ModalidadAlquilerPremium(
            String codigo,
            String nombre,
            String descripcion,
            int duracionMinima,
            double valorDiario,
            Estado estado,
            String tipoCobertura,
            int conductoresAdicionales,
            String caracteristicasEspeciales,
            double duracionContratada) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinima = duracionMinima;
        this.valorDiario = valorDiario;
        this.estado = estado;
        this.tipoCobertura = tipoCobertura;
        this.conductoresAdicionales = conductoresAdicionales;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.duracionContratada = duracionContratada;
    }

    @Override
    public ModalidadAlquilerBuilder definirModalidad(){
        return  new ModalidadAlquilerBuilder.Builder(codigo, nombre, descripcion, duracionMinima, valorDiario, estado)
                .incluyeAsistenciaEnCarretera(true)
                .incluyeSeguroBasico(true)
                .incuyeKilometarje(true)
                .tipoCobertura(tipoCobertura)
                .conductoresAdicionales(conductoresAdicionales)
                .caracteristicasEspeciales(caracteristicasEspeciales)
                .duracionContratada(duracionContratada)
                .build();

    }
}
