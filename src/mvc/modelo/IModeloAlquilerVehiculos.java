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

    void anadirCliente(Cliente cliente);

    void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

    //void anadirDatosPrueba();
    void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo);

    void borrarCliente(String dni);

    void borrarVehiculo(String matricula);

    List<Alquiler> obtenerAlquileres();

    List<Alquiler> obtenerAlquileresAbiertos();
    
    List<Alquiler> obtenerAlquileresCliente(String dni);
    
    List <Alquiler> obtenerAlquileresVehiculo(String matricula);

    Cliente buscarCliente(String dni);

    List<Cliente> obtenerClientes();

    Vehiculo buscarVehiculo(String matricula);

    List<Vehiculo> obtenerVehiculos();

    void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

    void leerClientes();

    void escribirClientes();

    void leerVehiculos();

    void escribirVehiculos();

    void leerAlquileres();

    void escribirAlquileres();

}
