package mvc.modelo.dominio.vehiculo;

import java.io.Serializable;
import java.util.regex.*;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    private DatosTecnicosVehiculo datosTecnicos;
    private String matricula, marca, modelo;
    private boolean disponible;
    public final double FACTOR_CILINDRADA = 50.0;
    public final double FACTOR_NUMERO_PLAZAS = 1.0;
    public final double FACTOR_PMA = 20.0;

    public Vehiculo(Vehiculo vehiculo) {
        matricula = vehiculo.getMatricula();
        marca = vehiculo.getMarca();
        modelo = vehiculo.getModelo();
        datosTecnicos = vehiculo.getDatosTecnicos();
        disponible = vehiculo.getDisponible();
    }

    public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        setDatosTecnicos(datosTecnicos);
    }

    private void setMatricula(String matricula) {
        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("Matrícula no válida");
        }
    }

    private boolean compruebaMatricula(String matricula) {
        Pattern patron = Pattern.compile("\\d{4}[B-DF-HJ-ÑP-TV-Z]{3}");
        Matcher emparejador = patron.matcher(matricula);
        return emparejador.matches();
    }

    private void setMarca(String marca) {
        if (marca != null && !marca.equals("")) {
            this.marca = marca;
        } else {
            throw new ExcepcionAlquilerVehiculos("Marca no válida");
        }
    }

    private void setModelo(String modelo) {
        if (modelo != null && !modelo.equals("")) {
            this.modelo = modelo;
        } else {
            throw new ExcepcionAlquilerVehiculos("Modelo no válido");
        }
    }

    private void setDatosTecnicos(DatosTecnicosVehiculo datosTecnicos) {
        if (datosTecnicos != null) {
            this.datosTecnicos = new DatosTecnicosVehiculo(datosTecnicos);
        } else {
            throw new ExcepcionAlquilerVehiculos("El vehiculo debe de tener datos técnicos definidos");
        }
    }

    public abstract TipoVehiculo getTipoVehiculo();

    public abstract double getPrecioEspecifico();

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public DatosTecnicosVehiculo getDatosTecnicos() {
        return datosTecnicos;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s, Marca: %s, Modelo: %s%n\tDatos Tecnicos: %s",
                matricula, marca, modelo, datosTecnicos);
    }
}
