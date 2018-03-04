package mvc.modelo.dominio.vehiculo;

import java.io.Serializable;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class DatosTecnicosVehiculo implements Serializable{

    private int cilindrada, numeroPlazas, pma;

    public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicosVehiculo) {
        cilindrada = datosTecnicosVehiculo.getCilindrada();
        numeroPlazas = datosTecnicosVehiculo.getNumeroPlazas();
        pma = datosTecnicosVehiculo.getPma();
    }

    public DatosTecnicosVehiculo(int cilindrada, int numeroPlazas, int pma) {
        setCilindrada(cilindrada);
        setNumeroPlazas(numeroPlazas);
        setPma(pma);
    }

    private void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    private void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    private void setPma(int pma) {
        this.pma = pma;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public int getPma() {
        return pma;
    }

    @Override
    public String toString() {
        return String.format("Cilindrada: %d, Numero de plazas: %d, PMA: %d%n",
                cilindrada, numeroPlazas, pma);
    }
}
