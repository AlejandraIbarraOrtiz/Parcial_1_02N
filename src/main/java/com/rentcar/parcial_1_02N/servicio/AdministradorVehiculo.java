package com.rentcar.parcial_1_02N.servicio;

import com.rentcar.parcial_1_02N.modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministradorVehiculo {


        private final List<Vehiculo> listaVehiculos;

        public AdministradorVehiculo() {
            this.listaVehiculos = new ArrayList<>();
            // Vehículos de prueba iniciales

            listaVehiculos.add(new Vehiculo("KFX-123", "Toyota", 2024, 2024, "SUV", 150000));
            listaVehiculos.add(new Vehiculo("MZN-456", "Chevrolet", 2023, 2023, "Sedán", 95000));
        }


        public void registrarVehiculo(Vehiculo vehiculo) {
            if (buscarPorPlaca(vehiculo.getPlaca()).isPresent()) {
                throw new IllegalArgumentException("Ya existe un vehículo registrado con la placa: " + vehiculo.getPlaca());
            }
            listaVehiculos.add(vehiculo);
        }
        public Vehiculo clonarVehiculoExistente(String placaOriginal, String nuevaPlaca) {
            Vehiculo original = buscarPorPlaca(placaOriginal)
                    .orElseThrow(() -> new IllegalArgumentException("Vehículo base no encontrado."));

            if (buscarPorPlaca(nuevaPlaca).isPresent()) {
                throw new IllegalArgumentException("La nueva placa ya está ocupada por otro vehículo.");
            }

            Vehiculo clon = original.clonar();
            clon.setPlaca(nuevaPlaca); // Se le asigna su nueva identidad obligatoria
            listaVehiculos.add(clon);
            return clon;
        }

        public List<Vehiculo> obtenerTodosLosVehiculos() {
            return new ArrayList<>(listaVehiculos);
        }

        public Optional<Vehiculo> buscarPorPlaca(String placa) {
            return listaVehiculos.stream()
                    .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                    .findFirst();
        }

        public void actualizarVehiculo(String placaOriginal, Vehiculo datosNuevos) {
            Vehiculo vehiculoExistente = buscarPorPlaca(placaOriginal)
                    .orElseThrow(() -> new IllegalArgumentException("Vehículo a actualizar no encontrado."));

            vehiculoExistente.setMarca(datosNuevos.getMarca());
            vehiculoExistente.setModelo(datosNuevos.getModelo());
            vehiculoExistente.setAnio(datosNuevos.getAnio());
            vehiculoExistente.setTipo(datosNuevos.getTipo());
            vehiculoExistente.setTarifaDiaria(datosNuevos.getTarifaDiaria());
        }

        public void eliminarVehiculo(String placa) {
            Vehiculo vehiculo = buscarPorPlaca(placa)
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el vehículo a eliminar."));
            listaVehiculos.remove(vehiculo);
        }

}
