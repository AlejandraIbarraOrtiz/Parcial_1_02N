package com.rentcar.parcial_1_02N.validador;

import com.rentcar.parcial_1_02N.modelo.Cliente;

import java.time.LocalDate;

public class ClienteValidador {

    //Validar que el nombre no sea nulo ni esté vacío
    public static boolean validarNombre(String nombre){

        if (nombre == null || nombre.trim().isEmpty()){

            return false;
        }

        return true;
    }

    //Validar que el ID solo contenga números
    public static boolean validarId(String id){

        if (id == null || id.trim().isEmpty()){

            return false;
        }

        for (int i = 0; i < id.length(); i ++){

            if (!Character.isDigit(id.charAt(i))){

                return false;
            }
        }

        return true;
    }

    //Validar que el télefono tenga exactamente 10 digitos y solo números
    public static boolean validarTelefono(String telefono){

        if (telefono == null || telefono.length() != 10){

            return false;
        }

        //Recorre el teléfono para comprobar que todos sean números
        for (int i = 0; i < telefono.length(); i++){

            if (!Character.isDigit(telefono.charAt(i))){

                return false;
            }
        }

        return true;
    }

    //Validar que el correo tenga un formato correcto
    public static boolean validarCorreo(String correo){

       if (correo == null || correo.trim().isEmpty()){

           return false;
       }

       int posicionArroba = correo.indexOf("@");
       int posicionPunto = correo.lastIndexOf(".");

       if (posicionArroba <= 0){

           return false;
       }

       if (posicionPunto <= posicionArroba + 1){

           return false;
       }

       if (posicionPunto == correo.length() -1){

           return false;
       }

       return true;
    }

    //Validar que el cliente sea mayor de edad
    public static boolean validarEdad(int edad){

        if (edad < 18){

            return false;
        }

        return true;
    }

    //Validar que la fecha de registro no sea nula
    public static boolean validarFechaRegistro(LocalDate fechaRegistro){

        if (fechaRegistro == null){

            return false;
        }

        return true;
    }

    //Validación de los datos del cliente antes de agregarlo
    public static boolean validarCliente(Cliente cliente){

        //Verifica que el cliente exista
       if (cliente == null){

           return false;
       }

        /*Validaciones de cada uno de los datos de cliente:
        nombre, id, telefono, correo edad, fecha registro*/
        if (!validarNombre(cliente.getNombre())){

            return false;
        }

        if (!validarId(cliente.getId())){

            return false;
        }

        if (!validarTelefono(cliente.getTelefono())){

            return false;
        }

        if (!validarCorreo(cliente.getCorreo())){

            return false;
        }

        if (!validarEdad(cliente.getEdad())){

            return false;
        }

        if (!validarFechaRegistro(cliente.getFechaRegistro())){

            return false;
        }

        return true;
    }
}
