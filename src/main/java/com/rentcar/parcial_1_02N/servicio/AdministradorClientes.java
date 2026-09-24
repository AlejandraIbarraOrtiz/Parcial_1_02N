package com.rentcar.parcial_1_02N.servicio;

import com.rentcar.parcial_1_02N.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AdministradorClientes {

    private List<Cliente> clientes;

    public AdministradorClientes(){

        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){

        clientes.add(cliente);
    }

    public boolean eliminarCliente(String id){

        for (int i = 0; i < clientes.size(); i++){

            if (clientes.get(i).getId().equals(id)){

                clientes.remove(i);

                return true;
            }
        }

        return false;
    }

    public boolean modificarCliente(String id, String telefono, String correo){

        Cliente cliente = buscarClienteId(id);

        if (cliente != null){

            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);

            return true;
        }

        return false;
    }

    public Cliente buscarClienteId(String id){

        for (int i = 0; i < clientes.size(); i++){

            if (clientes.get(i).getId().equals(id)){

                return clientes.get(i);
            }
        }

        return null;
    }

    public List<Cliente> getClientes(){

        return clientes;
    }
}
