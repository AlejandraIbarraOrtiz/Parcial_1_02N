package modelo;

import patronesCreacionales.Modalidad;
import patronesCreacionales.ModalidadAlquilerFactory;

public class ModalidadEconomicaFactory implements ModalidadAlquilerFactory {
    private ModalidadAlquilerBuilder builder;

    public ModalidadEconomicaFactory(ModalidadAlquilerBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Modalidad crearModalidad(){
        return new ModalidadAlquilerEconomica(
                builder.getCodigo(),
                builder.getNombre(),
                builder.getDescripcion(),
                builder.getDuracionMinima(),
                builder.getValorDiario(),
                builder.getEstado()
        );
    }
}
