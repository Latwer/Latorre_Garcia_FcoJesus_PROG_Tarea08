package mvc.modelo;

import java.util.List;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.modelo.dominio.*;
import mvc.modelo.dao.*;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class AlquilerVehiculos implements IModeloAlquilerVehiculos {

    private Clientes clientes;
    private Vehiculos vehiculos;
    private Alquileres alquileres;

    public AlquilerVehiculos() {
        clientes = new Clientes();
        vehiculos = new Vehiculos();
        alquileres = new Alquileres();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos.getVehiculos();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clientes.getClientes();
    }

    @Override
    public List<Alquiler> obtenerAlquileres() {
        return alquileres.getAlquileres();
    }

    @Override
    public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        vehiculos.anadirVehiculo(vehiculo, tipoVehiculo);
    }

    @Override
    public void borrarVehiculo(String matricula) {
        vehiculos.borrarVehiculo(matricula);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula) {
        return vehiculos.buscarVehiculo(matricula);
    }

    @Override
    public void anadirCliente(Cliente cliente) {
        clientes.anadirCliente(cliente);
    }

    @Override
    public void borrarCliente(String dni) {
        clientes.borrarCliente(dni);
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return clientes.buscarCliente(dni);
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
        comprobarExistenciaVehiculo(vehiculo);
        alquileres.abrirAlquiler(cliente, vehiculo);
    }

    @Override
    public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        comprobarExistenciaVehiculo(vehiculo);
        alquileres.cerrarAlquiler(cliente, vehiculo);
    }

    private void comprobarExistenciaVehiculo(Vehiculo vehiculo) {
        if (vehiculos.buscarVehiculo(vehiculo.getMatricula()) == null) {
            throw new ExcepcionAlquilerVehiculos("El vehículo no existe");
        }
    }

    @Override
    public void leerClientes() {
        clientes.leerClientes();
    }

    @Override
    public void escribirClientes() {
        clientes.escribirClientes();
    }

    @Override
    public void leerVehiculos() {
        vehiculos.leerVehiculos();
    }

    @Override
    public void escribirVehiculos() {
        vehiculos.escribirVehiculos();
    }

    @Override
    public void leerAlquileres() {
        alquileres.leerAlquileres();
    }

    @Override
    public void escribirAlquileres() {
        alquileres.escribirAlquileres();
    }

    @Override
    public List<Alquiler> obtenerAlquileresAbiertos() {
        return alquileres.obtenerAlquileresAbiertos();
    }

    @Override
    public List<Alquiler> obtenerAlquileresCliente(String dni) {
        return alquileres.obtenerAlquileresCliente(dni);
    }

    @Override
    public List<Alquiler> obtenerAlquileresVehiculo(String matricula) {
        return alquileres.obtenerAlquileresVehiculo(matricula);
    }

    /*@Override
    public void anadirDatosPrueba() {
        Cliente cliente1 = new Cliente("Juanma", "11111111A", new DireccionPostal("calle esmeralda", "Almería", "04001"));
        Cliente cliente2 = new Cliente("Sergio", "22222222B", new DireccionPostal("calle granada", "Almería", "04002"));
        Cliente cliente3 = new Cliente("Mario", "75728705B", new DireccionPostal("calle lupa", "Almería", "04008"));
        addCliente(cliente1);
        addCliente(cliente2);
        addCliente(cliente3);
        Vehiculo vehiculo1 = TipoVehiculo.TURISMO.getInstancia("1111BBB", "Nissan", "Skyline", new DatosTecnicosVehiculo (1600, 5, 400));
        Vehiculo vehiculo2 = TipoVehiculo.DE_CARGA.getInstancia("2222BBB", "CAT", "Carguero", new DatosTecnicosVehiculo (5000, 5, 25000));
        Vehiculo vehiculo3 = TipoVehiculo.AUTOBUS.getInstancia("3333BBB", "SUR", "BUS", new DatosTecnicosVehiculo (5000, 70, 5000));
        addVehiculo(vehiculo1, TipoVehiculo.TURISMO);
	addVehiculo(vehiculo2, TipoVehiculo.DE_CARGA);
	addVehiculo(vehiculo3, TipoVehiculo.AUTOBUS);
        openAlquiler(cliente1, vehiculo1);
        openAlquiler(cliente2, vehiculo2);
        openAlquiler(cliente3, vehiculo3);
        closeAlquiler(cliente1, vehiculo1);
        closeAlquiler(cliente2, vehiculo2);
        closeAlquiler(cliente3, vehiculo3);
    }*/
}
