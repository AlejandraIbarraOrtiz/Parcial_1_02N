package com.rentcar.parcial_1_02N.modelo;

import patronesCreacionales.Modalidad;
import patronesCreacionales.ModalidadAlquilerFactory;

public class ModalidadEjecutivaFactory implements ModalidadAlquilerFactory {
    private ModalidadAlquilerBuilder builder;

    public ModalidadEjecutivaFactory(ModalidadAlquilerBuilder builder) {
        this.builder = builder;
    }


    @Override
    public Modalidad crearModalidad(){
        return new ModalidadAlquilerEjecutiva(
                builder.getCodigo(),
                builder.getNombre(),
                builder.getDescripcion(),
                builder.getDuracionMinima(),
                builder.getValorDiario(),
                builder.getEstado(),
                builder.isIncluyeKilometraje(),
                builder.isIncluyeSeguroBasico(),
                builder.isIncluyeAsistenciaEnCarretera()
        );
    }
}
