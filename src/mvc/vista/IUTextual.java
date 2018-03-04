package mvc.vista;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.utilidades.Consola;
import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.controlador.IControladorAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class IUTextual implements IVistaAlquilerVehiculos {

    IControladorAlquilerVehiculos controlador;

    public IUTextual() {
        Opcion.setVista(this);
    }

    @Override
    public void setControlador(IControladorAlquilerVehiculos controlador) {
        this.controlador = controlador;
    }

    @Override
    public void comenzar() {
        int ordinalOpcion;
        do {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
    }

    public void salir() {
        System.out.println("Hasta la proxima!");
        controlador.salir();
    }

    public void anadirCliente() {
        Consola.mostrarCabecera("Añadir cliente");
        Cliente cliente = Consola.leerCliente();
        try {
            controlador.addCliente(cliente);
            System.out.println("Cliente añadido satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void borrarCliente() {
        Consola.mostrarCabecera("Borrar cliente");
        String dni = Consola.leerDni();
        try {
            controlador.delCliente(dni);
            System.out.println("Cliente borrado satisfactoriamente\n");
        } catch (Exception e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void buscarCliente() {
        Consola.mostrarCabecera("Buscar cliente");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.getCliente(dni);
        String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
        System.out.printf("%s%n%n", mensaje);
    }

    public void listarClientes() {
        Consola.mostrarCabecera("Listar clientes");
        for (Cliente cliente : controlador.getClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }
        System.out.println("");
    }

    public void anadirVehiculo() {
        Consola.mostrarCabecera("Añadir vehiculo");
        Vehiculo vehiculo = Consola.leerVehiculo();
        int tipoVehiculo = Consola.elegirTipoVehiculo();
        try {
            controlador.addVehiculo(vehiculo, TipoVehiculo.getTipoVehiculoSegunOrdinal(tipoVehiculo));
            System.out.println("Vehiculo añadido satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void borrarVehiculo() {
        Consola.mostrarCabecera("Borrar turismo");
        String matricula = Consola.leerMatricula();
        try {
            controlador.delVehiculo(matricula);
            System.out.println("Vehiculo borrado satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void buscarVehiculo() {
        Consola.mostrarCabecera("Buscar turismo");
        String matricula = Consola.leerMatricula();
        Vehiculo vehiculoBuscado = controlador.getVehiculo(matricula);
        String mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "El vehiculo no existe";
        System.out.printf("%s%n%n", mensaje);
    }

    public void listarVehiculos() {
        Consola.mostrarCabecera("Listar vehiculos");
        for (Vehiculo vehiculo : controlador.getVehiculos()) {
            if (vehiculo != null) {
                System.out.println(vehiculo);
            }
        }
        System.out.println("");
    }

    public void abrirAlquiler() {
        Consola.mostrarCabecera("Abrir alquiler");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.getCliente(dni);
        String matricula = Consola.leerMatricula();
        Vehiculo turismo = controlador.getVehiculo(matricula);
        if (cliente == null && turismo == null) {
            System.out.println("ERROR: No existe un cliente con dicho dni o un vehículo con dicha matrícula\n");
        } else {
            try {
                controlador.openAlquiler(cliente, turismo);
                System.out.println("Alquiler abierto satisfactoriamente\n");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
            }
        }
    }

    public void cerrarAlquiler() {
        Consola.mostrarCabecera("Cerrar alquiler");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.getCliente(dni);
        String matricula = Consola.leerMatricula();
        Vehiculo turismo = controlador.getVehiculo(matricula);
        if (cliente == null && turismo == null) {
            System.out.println("ERROR: No existe un cliente con dicho dni o un vehículo con dicha matrícula\n");
        } else {
            try {
                controlador.closeAlquiler(cliente, turismo);
                System.out.println("Alquiler cerrado satisfactoriamente\n");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
            }
        }
    }

    public void listarAlquileres() {
        Consola.mostrarCabecera("Listar alquileres");
        for (Alquiler alquiler : controlador.getAlquileres()) {
            if (alquiler != null) {
                System.out.println(alquiler);
            }
        }
        System.out.println("");
    }
    /*public static void main(String[] args) {
        AlquilerVehiculos miAlquiler = new AlquilerVehiculos();
        Cliente cliente1 = new Cliente("Juanma", "11111111A", new DireccionPostal("calle esmeralda", "Almería", "04001"));
        Cliente cliente2 = new Cliente("Sergio", "22222222B", new DireccionPostal("calle granada", "Almería", "04002"));
        miAlquiler.addCliente(cliente1);
        miAlquiler.addCliente(cliente2);
        Vehiculo turismo1 = new Vehiculo("1111BBB", "Nissan", "Skyline", 1900);
        Vehiculo turismo2 = new Vehiculo("2222BBB", "Opel", "Corsa", 1600);
        miAlquiler.addVehiculo(turismo1);
        miAlquiler.addVehiculo(turismo2);
        miAlquiler.openAlquiler(cliente1, turismo1);
        miAlquiler.openAlquiler(cliente2, turismo2);
        miAlquiler.closeAlquiler(cliente1, turismo1);
        miAlquiler.openAlquiler(cliente1, turismo1);
        for (Cliente cliente : miAlquiler.getClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }
        System.out.println("--------------");
        for (Vehiculo turismo : miAlquiler.getTurismos()) {
            if (turismo != null) {
                System.out.println(turismo);
            }
        }
        System.out.println("--------------");
        for (Alquiler alquiler : miAlquiler.getAlquileres()) {
            if (alquiler != null) {
                System.out.println(alquiler);
            }
        }

        int opcion;
        do {
            System.out.println("Alquiler de Vehículos");
            System.out.println("---------------");
            System.out.println("1.- Añadir cliente");
            System.out.println("2.- Borrar cliente");
            System.out.println("3.- Listar clientes");
            System.out.println("4.- Añadir turismo");
            System.out.println("5.- Borrar turismo");
            System.out.println("6.- Listar turismos");
            System.out.println("7.- Abrir Alquiler");
            System.out.println("8.- Cerrar Alquiler");
            System.out.println("9.- Listar Alquileres");
            System.out.println("0.- Salir");

            do {
                System.out.print("\nElige una opción (0-9): ");
                opcion = Entrada.entero();
            } while (opcion < 0 || opcion > 9);
            switch (opcion) {
                case 1:
            anadirCliente(miAlquiler);
                    break;
                case 2:
                    System.out.println("\nBorrar cliente");
                    System.out.println("--------------");
                    System.out.print("\nIntroduce el DNI del cliente a borrar: ");
                    String dniBorrar = Entrada.cadena();
                    try {
                        miAlquiler.delCliente(dniBorrar);
                        System.out.println("Cliente borrado satisfactoriamente\n");
                    } catch (Exception e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\nListado de clientes");
                    System.out.println("-------------------");
                    for (Cliente cliente : miAlquiler.getClientes()) {
                        if (cliente != null) {
                            System.out.println(cliente);
                        }
                    }
                    System.out.println("");
                    break;
                case 4:
                    Vehiculo nuevoTurismo = null;
                    System.out.println("\nAñadir turismo");
                    System.out.println("---------------");
                    System.out.print("Matrícula: ");
                    String matricula = Entrada.cadena();
                    System.out.print("Marca: ");
                    String marca = Entrada.cadena();
                    System.out.print("Modelo: ");
                    String modelo = Entrada.cadena();
                    System.out.print("Cilindrada: ");
                    int cilindrada = Entrada.entero();
                    try {
                        nuevoTurismo = new Vehiculo(matricula, marca, modelo, cilindrada);
                        miAlquiler.addVehiculo(nuevoTurismo);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\nBorrar turismo");
                    System.out.println("---------------");
                    System.out.print("\nIntroduce la matrícula del turismo a borrar: ");
                    String matriculaBorrar = Entrada.cadena();
                    try {
                        miAlquiler.delTurismo(matriculaBorrar);
                        System.out.println("Vehiculo borrado satisfactoriamente\n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\nListado de turismos");
                    System.out.println("--------------------");
                    for (Vehiculo turismo : miAlquiler.getTurismos()) {
                        if (turismo != null) {
                            System.out.println(turismo);
                        }
                    }
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("\nAbrir Alquiler");
                    System.out.println("-------------");
                    System.out.print("\nIntroduce el DNI del cliente: ");
                    String dniBuscar = Entrada.cadena();
                    Cliente clienteBuscado = miAlquiler.getCliente(dniBuscar);
                    System.out.print("\nIntroduce la matrícula del Vehiculo: ");
                    String matriculaBuscar = Entrada.cadena();
                    Vehiculo turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
                    if (turismoBuscado == null | clienteBuscado == null) {
                        System.out.println("ERROR: No existe un cliente con dicho DNI o un turismo con dicha matrícula\n");
                    } else {
                        try {
                            miAlquiler.openAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler abierto satisfactoriamente\n");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("ERROR: %s%n%n", e.getMessage());
                        }
                    }
                    break;
                case 8:
                    System.out.println("\nCerrar Alquiler");
                    System.out.println("--------------");
                    System.out.print("\nIntroduce el DNI del cliente: ");
                    dniBuscar = Entrada.cadena();
                    clienteBuscado = miAlquiler.getCliente(dniBuscar);
                    System.out.print("\nIntroduce la matrícula del turismo: ");
                    matriculaBuscar = Entrada.cadena();
                    turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
                    if (turismoBuscado == null | clienteBuscado == null) {
                        System.out.println("ERROR: No existe un cliente con dicho DNI o un turismo con dicha matrícula\n");
                    } else {
                        try {
                            miAlquiler.closeAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler cerrado satisfactoriamente");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("ERROR: %s%n%n", e.getMessage());
                        }
                    }
                    break;
                case 9:
                    System.out.println("\nListado de Alquileres");
                    System.out.println("---------------------");
                    for (Alquiler alquiler : miAlquiler.getAlquileres()) {
                        if (alquiler != null) {
                            System.out.println(alquiler);
                        }
                    }
                    System.out.println("");
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    private static void anadirCliente(AlquilerVehiculos miAlquiler) {
        Cliente addCliente = null;
        do {
            System.out.println("\nAñadir cliente");
            System.out.println("--------------");
            System.out.print("Nombre: ");
            String nombre = Entrada.cadena();
            System.out.print("DNI: ");
            String dni = Entrada.cadena();
            System.out.print("Dirección: ");
            String calle = Entrada.cadena();
            System.out.print("Localidad: ");
            String localidad = Entrada.cadena();
            System.out.print("Código postal: ");
            String codigoPostal = Entrada.cadena();
            try {
                addCliente = new Cliente(nombre, dni, new DireccionPostal(calle, localidad, codigoPostal));
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
                System.out.println("Vuelve a introducir los datos de forma correcta");
            }
        } while (addCliente == null);
        try {
            miAlquiler.addCliente(addCliente);
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }*/
}
