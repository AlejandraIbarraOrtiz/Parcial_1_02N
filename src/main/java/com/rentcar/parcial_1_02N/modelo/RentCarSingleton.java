package com.rentcar.parcial_1_02N.modelo;

import com.rentcar.parcial_1_02N.servicio.AdministradorClientes;

public class RentCarSingleton {

    //Guardar única instancia de RentCarSingleton
    private static RentCarSingleton instancia;

    //Atributos empresa
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String correo;
    private String paginaWeb;

    //Administra las operaciones relacionadas con el cliente
    private AdministradorClientes administradorClientes;

    private RentCarSingleton(){

        nombre = "RentCar";
        nit = "901591515";
        direccion = "Avenida Las Palmas # 15-25, Medellín";
        telefono = "3217810225";
        correo = "contacto@rentcar.com";
        paginaWeb = "www.rentcar.com";

        //Crea el administrador de clientes
        administradorClientes = new AdministradorClientes();
    }

    //Retorna la única instancia de RentCarSingleton
    public static RentCarSingleton getInstancia(){

        if(instancia == null){

            instancia = new RentCarSingleton();
        }

        return instancia;
    }

    //Retorna el administrador de clientes
    public AdministradorClientes getAdminClientes(){

        return administradorClientes;
    }

    //Métodos Get
    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }
}
