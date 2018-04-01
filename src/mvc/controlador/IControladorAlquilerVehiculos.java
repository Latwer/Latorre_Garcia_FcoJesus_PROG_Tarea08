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

    void anadirCliente(Cliente cliente);

    void borrarCliente(String dni);

    Cliente buscarCliente(String dni);

    List<Cliente> obtenerClientes();

    void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

    void borrarVehiculo(String matricula);

    Vehiculo buscarVehiculo(String matricula);

    List<Vehiculo> obtenerVehiculos();

    void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

    void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo);

    List<Alquiler> obtenerAlquileres();

    List<Alquiler> obtenerAlquileresAbiertos();
    
    List <Alquiler> obtenerAlquileresCliente(String dni);
    
    List <Alquiler> obtenerAlquileresVehiculo(String matricula);

}
