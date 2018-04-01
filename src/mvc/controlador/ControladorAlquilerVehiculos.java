package mvc.controlador;

import java.util.List;
import mvc.modelo.IModeloAlquilerVehiculos;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos {

    private IModeloAlquilerVehiculos modelo;
    private IVistaAlquilerVehiculos vista;

    public ControladorAlquilerVehiculos(IVistaAlquilerVehiculos vista, IModeloAlquilerVehiculos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setControlador(this);
    }

    @Override
    public void comenzar() {
        modelo.leerClientes();
        modelo.leerVehiculos();
        modelo.leerAlquileres();
        vista.comenzar();
    }

    @Override
    public void salir() {
        modelo.escribirClientes();
        modelo.escribirVehiculos();
        modelo.escribirAlquileres();
    }

    @Override
    public void anadirCliente(Cliente cliente) {
        modelo.anadirCliente(cliente);
    }

    @Override
    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return modelo.buscarCliente(dni);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return modelo.obtenerClientes();
    }

    @Override
    public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        modelo.anadirVehiculo(vehiculo, tipoVehiculo);
    }

    @Override
    public void borrarVehiculo(String matricula) {
        modelo.borrarVehiculo(matricula);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula) {
        return modelo.buscarVehiculo(matricula);
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return modelo.obtenerVehiculos();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
        modelo.abrirAlquiler(cliente, vehiculo);
    }

    @Override
    public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        modelo.cerrarAlquiler(cliente, vehiculo);
    }

    @Override
    public List<Alquiler> obtenerAlquileres() {
        return modelo.obtenerAlquileres();
    }

    @Override
    public List<Alquiler> obtenerAlquileresAbiertos() {
        return modelo.obtenerAlquileresAbiertos();
    }

    @Override
    public List<Alquiler> obtenerAlquileresCliente(String dni) {
        return modelo.obtenerAlquileresCliente(dni);
    }

    @Override
    public List<Alquiler> obtenerAlquileresVehiculo(String matricula) {
        return modelo.obtenerAlquileresVehiculo(matricula);
    }
    /* @Override
    public void anadirDatosPrueba() {
        modelo.anadirDatosPrueba();
    }*/
}
