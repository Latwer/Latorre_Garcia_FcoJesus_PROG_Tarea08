package mvc.controlador;

import java.util.List;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public interface IControladorAlquilerVehiculos {

    void comenzar();

    void salir();

    void addCliente(Cliente cliente);

    void delCliente(String dni);

    Cliente getCliente(String dni);

    List<Cliente> obtenerClientes();

    void addVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

    void delVehiculo(String matricula);

    Vehiculo getVehiculo(String matricula);

    Vehiculo[] getVehiculos();

    void openAlquiler(Cliente cliente, Vehiculo vehiculo);

    void closeAlquiler(Cliente cliente, Vehiculo vehiculo);

    Alquiler[] getAlquileres();

}
