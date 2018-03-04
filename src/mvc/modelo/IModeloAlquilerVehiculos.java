package mvc.modelo;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public interface IModeloAlquilerVehiculos {

    void addCliente(Cliente cliente);

    void addVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

    //void anadirDatosPrueba();
    void closeAlquiler(Cliente cliente, Vehiculo vehiculo);

    void delCliente(String dni);

    void delVehiculo(String matricula);

    Alquiler[] getAlquileres();

    Cliente getCliente(String dni);

    Cliente[] getClientes();

    Vehiculo getVehiculo(String matricula);

    Vehiculo[] getVehiculos();

    void openAlquiler(Cliente cliente, Vehiculo vehiculo);

    void leerClientes();

    void escribirClientes();

    void leerVehiculos();

    void escribirVehiculos();

    void leerAlquileres();

    void escribirAlquileres();

}
