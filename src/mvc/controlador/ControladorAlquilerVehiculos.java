package mvc.controlador;

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
    public void addCliente(Cliente cliente) {
        modelo.addCliente(cliente);
    }

    @Override
    public void delCliente(String dni) {
        modelo.delCliente(dni);
    }

    @Override
    public Cliente getCliente(String dni) {
        return modelo.getCliente(dni);
    }

    @Override
    public Cliente[] getClientes() {
        return modelo.getClientes();
    }

    @Override
    public void addVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        modelo.addVehiculo(vehiculo, tipoVehiculo);
    }

    @Override
    public void delVehiculo(String matricula) {
        modelo.delVehiculo(matricula);
    }

    @Override
    public Vehiculo getVehiculo(String matricula) {
        return modelo.getVehiculo(matricula);
    }

    @Override
    public Vehiculo[] getVehiculos() {
        return modelo.getVehiculos();
    }

    @Override
    public void openAlquiler(Cliente cliente, Vehiculo vehiculo) {
        modelo.openAlquiler(cliente, vehiculo);
    }

    @Override
    public void closeAlquiler(Cliente cliente, Vehiculo vehiculo) {
        modelo.closeAlquiler(cliente, vehiculo);
    }

    @Override
    public Alquiler[] getAlquileres() {
        return modelo.getAlquileres();
    }

    /* @Override
    public void anadirDatosPrueba() {
        modelo.anadirDatosPrueba();
    }*/
}
