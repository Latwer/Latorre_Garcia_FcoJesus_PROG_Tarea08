package mvc.modelo.dominio;

import java.io.Serializable;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Date fecha;
    private int dias;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30.0;

    public Alquiler(Cliente cliente, Vehiculo vehiculo) {
        setCliente(cliente);
        setVehiculo(vehiculo);
        fecha = new Date();
        dias = 0;
        vehiculo.setDisponible(false);
    }

    private void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = new Cliente(cliente);
        } else {
            throw new ExcepcionAlquilerVehiculos("El alquiler debe tener un cliente identificado");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            this.vehiculo = vehiculo;
        } else {
            throw new ExcepcionAlquilerVehiculos("El alquiler debe tener un vehiculo identificado");
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getDias() {
        return dias;
    }

    public void close() {
        Date ahora = new Date();
        dias = difDias(ahora, fecha);
        vehiculo.setDisponible(true);
    }

    private int difDias(Date fechaFin, Date fechaInicio) {
        long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
        long dias = milisegundos / MS_DIA;
        return (int) dias + 1;
    }

    public double getPrecio() {
        return getPrecioFijo() + vehiculo.getPrecioEspecifico();
    }

    public double getPrecioFijo() {
        return PRECIO_DIA * dias;
    }

    @Override
    public String toString() {
        return String.format("Fecha entrada: %s, Días: %d, Precio: %.2f, Precio Fijo: %.2f%n\tCliente: %s%n\tVehiculo: %s",
                FORMATO_FECHA.format(fecha), dias, getPrecio(), getPrecioFijo(), cliente, vehiculo);
    }
}
