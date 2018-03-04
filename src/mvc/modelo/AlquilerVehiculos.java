package mvc.modelo;

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
    public Vehiculo[] getVehiculos() {
        return vehiculos.getVehiculos();
    }

    @Override
    public Cliente[] getClientes() {
        return clientes.getClientes();
    }

    @Override
    public Alquiler[] getAlquileres() {
        return alquileres.getAlquileres();
    }

    @Override
    public void addVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        //comprobarDisponibilidadTurismo(vehiculo);
        vehiculos.addVehiculo(vehiculo, tipoVehiculo);
    }

    @Override
    public void delVehiculo(String matricula) {
        vehiculos.delVehiculo(matricula);
    }

    @Override
    public Vehiculo getVehiculo(String matricula) {
        return vehiculos.getVehiculo(matricula);
    }

    @Override
    public void addCliente(Cliente cliente) {
        clientes.addCliente(cliente);
    }

    @Override
    public void delCliente(String dni) {
        clientes.delCliente(dni);
    }

    @Override
    public Cliente getCliente(String dni) {
        return clientes.getCliente(dni);
    }

    @Override
    public void openAlquiler(Cliente cliente, Vehiculo vehiculo) {
        //comprobarDisponibilidadTurismo(cliente, turismo);
        alquileres.openAlquiler(cliente, vehiculo);
    }

    @Override
    public void closeAlquiler(Cliente cliente, Vehiculo vehiculo) {
        //comprobarExistenciaClienteTurismo(cliente, vehiculo);
        alquileres.closeAlquiler(cliente, vehiculo);
    }

    /*private void comprobarDisponibilidadTurismo(Cliente cliente, Vehiculo turismo) {
        if (clientes.buscarCliente(turismo.getPropietario().getDni()) == null) {
            throw new ExcepcionAlquilerVehiculos("El propietario del vehículo no existe");
        }
    }*/
 /*private void comprobarExistenciaClienteTurismo(Cliente cliente, Vehiculo vehiculo) {
        if (vehiculos.getVehiculo(vehiculo.getMatricula()) == null && clientes.getCliente(cliente.getDni()) == null) {
            throw new ExcepcionAlquilerVehiculos("El cliente o turismo no existe");
        }
    }*/
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
