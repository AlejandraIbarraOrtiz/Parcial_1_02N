package com.rentcar.parcial_1_02N.modelo;

import patronesCreacionales.VehiculoPrototype;

public class Vehiculo implements VehiculoPrototype {
    private String placa;
    private String marca;
    private int modelo;
    private  int anio;
    private String tipo;
    private  double tarifaDiaria;

    public Vehiculo(String placa, String marca, int modelo, int anio, String tipo, double tarifaDiaria) {
        this.placa= placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
        this.tarifaDiaria = tarifaDiaria;
    }

    @Override
    public Vehiculo clonar(){
        return new Vehiculo(
                this.placa,
                this.marca,
                this.modelo,
                this.anio,
                this.tipo,
                this.tarifaDiaria);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }
}
