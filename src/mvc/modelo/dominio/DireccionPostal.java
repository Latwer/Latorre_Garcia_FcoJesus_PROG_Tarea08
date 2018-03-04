package mvc.modelo.dominio;

import java.io.Serializable;
import java.util.regex.*;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class DireccionPostal implements Serializable {

    private String calle;
    private String localidad;
    private String codigoPostal;

    public DireccionPostal(DireccionPostal direccionPostal) {
        calle = direccionPostal.getCalle();
        localidad = direccionPostal.getLocalidad();
        codigoPostal = direccionPostal.getCodigoPostal();
    }

    public DireccionPostal(String calle, String localidad, String codigoPostal) {
        setCalle(calle);
        setLocalidad(localidad);
        setCodgioPostal(codigoPostal);
    }

    private void setCodgioPostal(String codigoPostal) {
        if (compruebaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ExcepcionAlquilerVehiculos("Código Postal no válido");
        }
    }

    private void setLocalidad(String localidad) {
        if (localidad != null && !localidad.equals("")) {
            this.localidad = localidad;
        } else {
            throw new ExcepcionAlquilerVehiculos("Localidad no válida");
        }
    }

    private void setCalle(String calle) {
        if (calle != null && !calle.equals("")) {
            this.calle = calle;
        } else {
            throw new ExcepcionAlquilerVehiculos("Calle no válida");
        }
    }

    boolean compruebaCodigoPostal(String codigoPostal) {
        Pattern patron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
        Matcher emparejador = patron.matcher(codigoPostal);
        return emparejador.matches();
    }

    public String getCalle() {
        return calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String toString() {
        return String.format("Direccion: %s, Localidad: %s, Código Postal: %s", calle, localidad, codigoPostal);
    }

}
