package com.rentcar.parcial_1_02N.servicio;

import com.rentcar.parcial_1_02N.modelo.*;
import patronesCreacionales.Modalidad;
import patronesCreacionales.ModalidadAlquilerFactory;

public class AdministradorModalidadesAlquiler {

    public Modalidad crearModalidad (
            TipoModalidad tipo,
            ModalidadAlquilerBuilder builder){
        ModalidadAlquilerFactory factory = obtenerFactory(tipo, builder);
        return factory.crearModalidad();
    }

    public ModalidadAlquilerFactory obtenerFactory(TipoModalidad tipo, ModalidadAlquilerBuilder builder){

        ModalidadAlquilerFactory factory;

        switch (tipo){
            case PREMIUM:
                return new ModalidadPremiumFactory(builder);

            case EJECUTIVA:
                return new ModalidadEjecutivaFactory(builder);


            case ECONOMICA:
                return new ModalidadEconomicaFactory(builder);

            default:
                throw new IllegalArgumentException("El tipo de modalidad escogido no valido");
        }

    }
}
