package com.rentcar.parcial_1_02N.modelo;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private int edad;
    private LocalDate fechaRegistro;


    public Cliente(String nombre, String id, String telefono, String correo, int edad,
                   LocalDate fechaRegistro) {

        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
    }

    //Métodos Get y Set
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

}
