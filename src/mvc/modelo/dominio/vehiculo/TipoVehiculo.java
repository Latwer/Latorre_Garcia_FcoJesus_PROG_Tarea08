package mvc.modelo.dominio.vehiculo;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public enum TipoVehiculo {
    TURISMO("Vehiculo de tipo turismo") {
        public Vehiculo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
            return new Turismo(matricula, marca, modelo, datosTecnicos);
        }
    },
    DE_CARGA("Vehiculo de carga") {
        public Vehiculo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
            return new DeCarga(matricula, marca, modelo, datosTecnicos);
        }
    },
    AUTOBUS("Vehiculo de tipo autobus") {
        public Autobus getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
            return new Autobus(matricula, marca, modelo, datosTecnicos);
        }
    };
    private String tipoVehiculo;

    private TipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public abstract Vehiculo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos);

    public String toString() {
        return tipoVehiculo;
    }

    public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
        if (esOrdinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Ordinal del tipo de vehiculo no válido");
        }
    }

    public static boolean esOrdinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1);
    }
}
