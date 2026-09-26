package com.rentcar.parcial_1_02N.servicio;

import com.rentcar.parcial_1_02N.modelo.Cliente;
import com.rentcar.parcial_1_02N.validador.ClienteValidador;
import java.util.ArrayList;
import java.util.List;

public class AdministradorClientes {

    //Lista para almacenar clientes
    private List<Cliente> listaClientes;


    //Inicializa la lista de clientes
    public AdministradorClientes(){

        listaClientes = new ArrayList<>();
    }

    //Agregar el cliente si los datos son válidos y el ID no está registrado
    public boolean agregarCliente(Cliente cliente){


        //Verifica que los datos del cliente sean válidos
        if (!ClienteValidador.validarCliente(cliente)){

            return false;
        }

        //Verifica que no exista otro cliente con el mismo ID
        if (buscarClienteId(cliente.getId()) != null){

            return false;
        }

        listaClientes.add(cliente);
        return true;
    }

    //Eliminar cliente buscándolo por ID
    public boolean eliminarCliente(String id){

        for (int i = 0; i < listaClientes.size(); i++){

            if (listaClientes.get(i).getId().equals(id)){

                listaClientes.remove(i);

                return true;
            }
        }

        return false;
    }

    /*Modifica los datos de cliente:
    correo y telefono*/
    public boolean modificarCliente(String id, String telefono, String correo){

        //Busca el cliente que se quiere modificar
        Cliente cliente = buscarClienteId(id);

        if (cliente != null){

            //Verifica que el teléfono y el correo sean válidos
            if (ClienteValidador.validarTelefono(telefono) && ClienteValidador.validarCorreo(correo)){

                cliente.setTelefono(telefono);
                cliente.setCorreo(correo);

                return true;
            }
        }

        return false;
    }

    //Buscar cliente por ID
    public Cliente buscarClienteId(String id){

        for (int i = 0; i < listaClientes.size(); i++){

            if (listaClientes.get(i).getId().equals(id)){

                return listaClientes.get(i);
            }
        }

        return null;
    }

    //Buscar cliente mediante número de teléfono
    public Cliente buscarClienteTelefono(String telefono){

        for (int i = 0; i < listaClientes.size(); i++){

            if (listaClientes.get(i).getTelefono().equals(telefono)){

                return listaClientes.get(i);
            }
        }

        return null;
    }

    //Retorna la lista completa de clientes
    public List<Cliente> getListaClientes() {

        return listaClientes;
    }
}
