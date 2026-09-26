package com.rentcar.parcial_1_02N.modelo;

public class ModalidadAlquilerBuilder {

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
    private boolean incluyeKilometraje;
    private boolean incluyeSeguroBasico;
    private boolean incluyeAsistenciaEnCarretera;


    ModalidadAlquilerBuilder(Builder builder){
        this.codigo = builder.codigo;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.duracionMinima = builder.duracionMinima;
        this.valorDiario = builder.valorDiario;
        this.estado = builder.estado;
        this.tipoCobertura = builder.tipoCobertura;
        this.conductoresAdicionales = builder.conductoresAdicionales;
        this.caracteristicasEspeciales = builder.caracteristicasEspeciales;
        this.duracionContratada = builder.duracionContratada;
        this.incluyeKilometraje = builder.incluyeKilometraje;
        this.incluyeSeguroBasico = builder.incluyeSeguroBasico;
        this.codigo = builder.codigo;
        this.incluyeAsistenciaEnCarretera = builder.incluyeAsistenciaEnCarretera;

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMinima() {
        return duracionMinima;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public int getConductoresAdicionales() {
        return conductoresAdicionales;
    }

    public String getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public double getDuracionContratada() {
        return duracionContratada;
    }

    public boolean isIncluyeKilometraje() {
        return incluyeKilometraje;
    }

    public boolean isIncluyeSeguroBasico() {
        return incluyeSeguroBasico;
    }

    public boolean isIncluyeAsistenciaEnCarretera() {
        return incluyeAsistenciaEnCarretera;
    }

    public static class Builder{

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
        private boolean incluyeKilometraje;
        private boolean incluyeSeguroBasico;
        private boolean incluyeAsistenciaEnCarretera;

        public Builder(
                String codigo,
                String nombre,
                String descripcion,
                int duracionMinima,
                double valorDiario,
                Estado estado){

            this.codigo = codigo;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.duracionMinima = duracionMinima;
            this.valorDiario = valorDiario;
            this.estado = estado;


        }

        public Builder tipoCobertura(String tipoCobertura){
            this.tipoCobertura = tipoCobertura;
            return this;

        }

        public Builder conductoresAdicionales(int conductoresAdicionales){
            this.conductoresAdicionales = conductoresAdicionales;
            return this;
        }

        public Builder caracteristicasEspeciales(String caracteristicasEspeciales){
            this.caracteristicasEspeciales = caracteristicasEspeciales;
            return this;
        }

        public Builder duracionContratada(double duracionContratada){
            this.duracionContratada = duracionContratada;
            return this;
        }

        public Builder incuyeKilometarje (boolean incluyeKilometraje){
            this.incluyeKilometraje = incluyeKilometraje;
            return this;
        }

        public Builder incluyeSeguroBasico(boolean incluyeSeguroBasico){
            this.incluyeSeguroBasico = incluyeSeguroBasico;
            return this;
        }

        public Builder incluyeAsistenciaEnCarretera(boolean incluyeAsistenciaEnCarretera){
            this.incluyeAsistenciaEnCarretera = incluyeAsistenciaEnCarretera;
            return this;
        }
        public ModalidadAlquilerBuilder build(){
            return new ModalidadAlquilerBuilder(this);
        }
    }
}
