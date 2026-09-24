package com.rentcar.parcial_1_02N.modelo;

import com.rentcar.parcial_1_02N.servicio.AdministradorClientes;

public class RentCarSingleton {

   private static RentCarSingleton instancia;

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String correo;
    private String paginaWeb;

    private AdministradorClientes adminClientes;

    private RentCarSingleton(){

        nombre = "RentCar";
        nit = "901591515";
        direccion = "Avenida Las Palmas # 15-25, Medellín";
        telefono = "3217810225";
        correo = "contacto@rentcar.com";
        paginaWeb = "www.rentcar.com";

        adminClientes = new AdministradorClientes();
    }

    public static RentCarSingleton getInstance(){

        if(instancia == null){

            instancia = new RentCarSingleton();
        }

        return instancia;
    }

    public AdministradorClientes getAdminClientes(){

        return adminClientes;
    }

    //Métodos Get Y Set
    public static RentCarSingleton getInstancia() {
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
