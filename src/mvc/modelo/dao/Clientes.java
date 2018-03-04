package mvc.modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Clientes {

    private Cliente[] clientes;
    private final int MAX_CLIENTES = 25;
    private final String FICHERO_CLIENTES = "datos/clientes.dat";

    public Clientes() {
        clientes = new Cliente[MAX_CLIENTES];
    }

    public Cliente[] getClientes() {
        return clientes.clone();
    }
    public void leerClientes() {
        File fichero = new File(FICHERO_CLIENTES);
        ObjectInputStream entrada;
        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            try {
                clientes = (Cliente[]) entrada.readObject();
                entrada.close();
                System.out.println("Fichero clientes leído satisfactoriamente.");
                //Cliente.aumentarUltimoIdentificador(calcularUltimoIdentificador());
            } catch (ClassNotFoundException e) {
                System.out.println("No puedo encontrar la clase que tengo que leer.");
            } catch (IOException e) {
                System.out.println("Error inesperado de Entrada/Salida.");
            }
        } catch (IOException e) {
            System.out.println("No puedo abrir el fihero de clientes.");
        }
    }

    private int calcularUltimoIdentificador() {
        int ultimoIdentificador = 0;
        int i = 0;
        while (clientes[i] != null) {
            if (clientes[i].getIdentificador() > ultimoIdentificador) {
                ultimoIdentificador = clientes[i].getIdentificador();
            }
        }
        return ultimoIdentificador;
    }
    public void escribirClientes() {
        File fichero = new File(FICHERO_CLIENTES);
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject((Cliente[]) clientes);
            salida.close();
            System.out.println("Fichero clientes escrito satisfactoriamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No puedo crear el fichero de clientes");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }

    public void addCliente(Cliente cliente) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
        if (indiceNoSuperaTamano(indice)) {
            clientes[indice] = new Cliente(cliente);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
        int indice = 0;
        boolean clienteEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
            if (clientes[indice] == null) {
                clienteEncontrado = true;
            } else if (clientes[indice].getDni().equals(cliente.getDni())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < clientes.length;
    }

    public void delCliente(String dni) {
        int indice = buscarIndiceCliente(dni);
        if (indiceNoSuperaTamano(indice)) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
        }
    }

    private int buscarIndiceCliente(String dni) {
        int indice = 0;
        boolean clienteEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
            if (clientes[indice] != null && clientes[indice].getDni().equals(dni)) {
                clienteEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
            clientes[i] = clientes[i + 1];
        }
    }

    public Cliente getCliente(String dni) {
        int posicion = buscarIndiceCliente(dni);
        if (indiceNoSuperaTamano(posicion)) {
            return new Cliente(clientes[posicion]);
        } else {
            return null;
        }
    }
}
