package modelo;

import patronesCreacionales.Modalidad;
import patronesCreacionales.ModalidadAlquilerFactory;

public class ModalidadPremiumFactory implements ModalidadAlquilerFactory {

    private ModalidadAlquilerBuilder builder;

    public ModalidadPremiumFactory(ModalidadAlquilerBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Modalidad crearModalidad(){
        return new ModalidadAlquilerPremium (
                builder.getCodigo(),
                builder.getNombre(),
                builder.getDescripcion(),
                builder.getDuracionMinima(),
                builder.getValorDiario(),
                builder.getEstado(),
                builder.getTipoCobertura(),
                builder.getConductoresAdicionales(),
                builder.getCaracteristicasEspeciales(),
                builder.getDuracionContratada()
        );
    }
}

