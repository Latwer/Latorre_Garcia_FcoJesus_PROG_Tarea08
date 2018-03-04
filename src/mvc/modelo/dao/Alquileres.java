package mvc.modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Alquileres {

    private Alquiler[] alquileres;
    private final int MAX_ALQUILERES = 25;
    private final String FICHERO_ALQUILERES = "datos/alquileres.dat";

    public Alquileres() {
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    public Alquiler[] getAlquileres() {
        return alquileres.clone();
    }

    public void leerAlquileres() {
        File fichero = new File(FICHERO_ALQUILERES);
        ObjectInputStream entrada;
        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            try {
                alquileres = (Alquiler[]) entrada.readObject();
                entrada.close();
                System.out.println("Fichero alquileres leído satisfactoriamente.");
            } catch (ClassNotFoundException e) {
                System.out.println("No puedo encontrar la clase que tengo que leer.");
            } catch (IOException e) {
                System.out.println("Error inesperado de Entrada/Salida.");
            }
        } catch (IOException e) {
            System.out.println("No puedo abrir el fihero de alquileres.");
        }
    }

    public void escribirAlquileres() {
        File fichero = new File(FICHERO_ALQUILERES);
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject((Alquiler[]) alquileres);
            salida.close();
            System.out.println("Fichero alquileres escrito satisfactoriamente");
        } catch (FileNotFoundException e) {
            System.out.println("No puedo crear el fichero de alquileres");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }

    public void openAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(cliente, vehiculo);

        if (indiceNoSuperaTamano(indice)) {
            alquileres[indice] = new Alquiler(cliente, vehiculo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de alquileres está lleno.");
        }

    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < alquileres.length;
    }

    private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Cliente cliente, Vehiculo vehiculos) {
        int indice = 0;
        boolean encontrado = false;

        while (indiceNoSuperaTamano(indice) && !encontrado) {
            if (alquileres[indice] == null) {
                encontrado = true;
            } else if (alquileres[indice].getVehiculo().getMatricula().equals(vehiculos.getMatricula())
                    && alquileres[indice].getVehiculo().getDisponible() == false) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para ese vehiculo.");
            } else {
                indice++;
            }
        }
        return indice;
    }

    public void closeAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int indice = buscarAlquilerAbierto(cliente, vehiculo);

        if (indiceNoSuperaTamano(indice)) {
            alquileres[indice].close();
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese vehículo.");
        }
    }

    private int buscarAlquilerAbierto(Cliente cliente, Vehiculo vehiculo) {
        int indice = 0;
        boolean encontrado = false;

        while (indiceNoSuperaTamano(indice) && !encontrado) {
            if (alquileres[indice] != null && alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
                    && alquileres[indice].getCliente().getDni().equals(cliente.getDni())
                    && alquileres[indice].getVehiculo().getDisponible() == false && alquileres[indice].getDias() == 0) {//Mirar esto
                encontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }
}
