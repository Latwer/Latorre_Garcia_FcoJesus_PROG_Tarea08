package mvc.modelo.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Alquileres {

    private List<Alquiler> alquileres;
    private final String FICHERO_ALQUILERES = "datos/alquileres.dat";

    public Alquileres() {
        alquileres = new Vector<Alquiler>();
    }

    public List<Alquiler> getAlquileres() {
        return new Vector<Alquiler>(alquileres);
    }

    public void leerAlquileres() {
        File fichero = new File(FICHERO_ALQUILERES);
        ObjectInputStream entrada;

        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            try {
                while (true) {
                    Alquiler alquiler = (Alquiler) entrada.readObject();
                    alquileres.add(alquiler);
                }
            } catch (EOFException eo) {
                entrada.close();
                System.out.println("Fichero de alquileres leído correctamente");
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: no se encuentra la clase que hay que leer.");
            } catch (IOException e) {
                System.out.println("ERROR: Error inesperado de Entrada/Salida");
            }
        } catch (IOException e) {
            System.out.println("ERROR: No se puede abrir el fichero de alquileres");
        }
    }

    public void escribirAlquileres() {
        File fichero = new File(FICHERO_ALQUILERES);

        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
            for (Alquiler alquiler : alquileres) {
                salida.writeObject(alquiler);
            }
            salida.close();
            System.out.println("Fichero de alquileres escrito correctamente");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: no puedo crear el fichero de clientes");
        } catch (IOException e) {
            System.out.println("ERROR: Error inesperado de Entrada/Salida");
        }
    }

    private void compruebaExistenciaOtroAbierto(Cliente cliente, Vehiculo vehiculo) {
        int indice = 0;

        while (indiceNoSuperaTamano(indice)) {
            if (alquileres.get(indice).getVehiculo().getMatricula().equals(vehiculo.getMatricula())
                    && alquileres.get(indice).getDias() == 0) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para ese vehículo.");
            } else {
                indice++;
            }
        }
    }

    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
        compruebaExistenciaOtroAbierto(cliente, vehiculo);
        alquileres.add(new Alquiler(cliente, vehiculo));
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < alquileres.size();
    }

    public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int indice = buscarAlquilerAbierto(cliente, vehiculo);

        if (indiceNoSuperaTamano(indice)) {
            alquileres.get(indice).close();
            vehiculo.setDisponible(true);
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese vehículo.");
        }
    }

    private int buscarAlquilerAbierto(Cliente cliente, Vehiculo vehiculo) {
        int indice = 0;
        boolean encontrado = false;

        while (indiceNoSuperaTamano(indice) && !encontrado) {
            if (alquileres.get(indice).getVehiculo().getMatricula().equals(vehiculo.getMatricula())
                    && alquileres.get(indice).getDias() == 0) {
                encontrado = true;
            } else {
                indice++;
            }
        }
        return encontrado ? indice : alquileres.size();
    }

    public List<Alquiler> obtenerAlquileresAbiertos() {
        int posicion = 0;

        List<Alquiler> alquileresAbiertos = new Vector<Alquiler>();
        while (posicion < alquileres.size()) {
            if (alquileres.get(posicion).getDias() == 0) {
                alquileresAbiertos.add(alquileres.get(posicion));
            }
            posicion++;
        }

        return alquileresAbiertos;
    }

    public List<Alquiler> obtenerAlquileresCliente(String dni) {
        int posicion = 0;
        List<Alquiler> alquileresCliente = new Vector<Alquiler>();

        while (posicion < alquileres.size()) {
            if (alquileres.get(posicion).getCliente().getDni().equals(dni)) {
                alquileresCliente.add(alquileres.get(posicion));
            }

            posicion++;
        }

        return alquileresCliente;

    }

    public List<Alquiler> obtenerAlquileresVehiculo(String matricula) {
        int posicion = 0;
        List<Alquiler> alquileresVehiculo = new Vector<Alquiler>();

        while (posicion < alquileres.size()) {
            if (alquileres.get(posicion).getVehiculo().getMatricula().equals(matricula)) {
                alquileresVehiculo.add(alquileres.get(posicion));
            }

            posicion++;
        }

        return alquileresVehiculo;
    }
}
