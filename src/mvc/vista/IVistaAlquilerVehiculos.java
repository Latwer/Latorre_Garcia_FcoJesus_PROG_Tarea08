package mvc.vista;

import mvc.controlador.IControladorAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public interface IVistaAlquilerVehiculos {

    void setControlador(IControladorAlquilerVehiculos controlador);

    void comenzar();

}
