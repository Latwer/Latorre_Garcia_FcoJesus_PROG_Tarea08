package mvc.modelo;

import java.util.List;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public interface IModeloAlquilerVehiculos {

    void addCliente(Cliente cliente);

    void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

    //void anadirDatosPrueba();
    void closeAlquiler(Cliente cliente, Vehiculo vehiculo);

    void delCliente(String dni);

    void delVehiculo(String matricula);

    Alquiler[] getAlquileres();

    Cliente getCliente(String dni);

    List<Cliente> obtenerClientes();

    Vehiculo getVehiculo(String matricula);

    List<Vehiculo> obtenerVehiculos();

    void openAlquiler(Cliente cliente, Vehiculo vehiculo);

    void leerClientes();

    void escribirClientes();

    void leerVehiculos();

    void escribirVehiculos();

    void leerAlquileres();

    void escribirAlquileres();

}
