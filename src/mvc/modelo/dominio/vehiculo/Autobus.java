package mvc.modelo.dominio.vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Autobus extends Vehiculo {

    private double precioAutobus = 0.0;

    public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        super(matricula, marca, modelo, datosTecnicos);
    }

    public Autobus(Autobus autobus) {
        super(autobus);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.AUTOBUS;
    }

    @Override
    public double getPrecioEspecifico() {
        //return FACTOR_CILINDRADA / 50 + 1 * FACTOR_NUMERO_PLAZAS;
        precioAutobus = getDatosTecnicos().getCilindrada() / FACTOR_CILINDRADA + FACTOR_NUMERO_PLAZAS * getDatosTecnicos().getNumeroPlazas();
        return precioAutobus;
    }

}
