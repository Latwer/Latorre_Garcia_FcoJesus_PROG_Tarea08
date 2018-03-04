package aplicacion;

import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.IModeloAlquilerVehiculos;
import mvc.vista.IUTextual;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class PrincipalAlquilerVehiculos {

    public static void main(String[] args) {
        IModeloAlquilerVehiculos modelo = new AlquilerVehiculos();
        IVistaAlquilerVehiculos vista = new IUTextual();
        IControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

        controlador.comenzar();
    }
}
