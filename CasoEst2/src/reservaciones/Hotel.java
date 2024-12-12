/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservaciones;

/**
 *
 * @author tamar
 */
public class Hotel {
    private Habitacion[][] habitaciones;

    public Hotel(int pisos, int habitacionesPorPiso) {
        habitaciones = new Habitacion[pisos][habitacionesPorPiso];
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < habitacionesPorPiso; j++) {
                int numero = (i * habitacionesPorPiso) + j + 1;
                String tipo = (j % 2 == 0) ? "Simple" : "Doble";
                double precio = (tipo.equals("Simple")) ? 40.0 + Math.random() * 10 : 80.0 + Math.random() * 20;
                String estado = generarEstadoAleatorio();
                habitaciones[i][j] = new Habitacion(numero, tipo, precio);
                habitaciones[i][j].setEstado(estado);
            }
        }
    }
    //GENERAR ESTADO ALEATORIO
    private String generarEstadoAleatorio() {
        double rand = Math.random();
        if (rand < 0.33) {
            return "Libre";
        } else if (rand < 0.66) {
            return "Ocupada";
        } else {
            return "Sucia";
        }
    }
    
    
    //MOSTRAR HABITACIONES
    public void mostrarHabitaciones() {
        System.out.println("HOTEL SIN NOMBRE");
        for (int i = habitaciones.length - 1; i >= 0; i--) {  // Mostrar desde el último piso
            System.out.println("Piso " + (i + 1));
            for (Habitacion habitacion : habitaciones[i]) {
                System.out.println(habitacion);
            }
            System.out.println();
        }
    }
    
    
    // BUSCAR HABITACIONES
    public Habitacion buscarHabitacionLibre(String tipo) {
        for (Habitacion[] piso : habitaciones) {
            for (Habitacion habitacion : piso) {
                if (habitacion.getTipo().equals(tipo) && habitacion.getEstado().equals("Libre")) {
                    return habitacion;
                }
            }
        }
        return null;
    }
    
    // EDITAR HABITACION
    public void modificarHabitacion(int numero, String nuevoEstado, String nuevoTipo, double nuevoPrecio) {
        for (Habitacion[] piso : habitaciones) {
            for (Habitacion habitacion : piso) {
                if (habitacion.getNumero() == numero) {
                    habitacion.setEstado(nuevoEstado);
                    habitacion.setTipo(nuevoTipo);
                    habitacion.setPrecio(nuevoPrecio);
                    return;
                }
            }
        }
    }
    
    //GENERAR RESUMEN
    public void generarResumen() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancias = 0.0;

        for (Habitacion[] piso : habitaciones) {
            for (Habitacion habitacion : piso) {
                switch (habitacion.getEstado()) {
                    case "Libre" -> libres++;
                    case "Ocupada" -> {
                        ocupadas++;
                        ganancias += habitacion.getPrecio();
                    }
                    case "Sucia" -> sucias++;
                }
            }
        }

        int total = libres + ocupadas + sucias;
        double porcentajeLibres = ((double) libres / total) * 100;
        double porcentajeOcupadas = ((double) ocupadas / total) * 100;
        double porcentajeSucias = ((double) sucias / total) * 100;

        System.out.println("Resumen del Estado del Hotel:");
        System.out.println("Total de habitaciones libres: " + libres + " (" + String.format("%.2f", porcentajeLibres) + "%)");
        System.out.println("Total de habitaciones ocupadas: " + ocupadas + " (" + String.format("%.2f", porcentajeOcupadas) + "%)");
        System.out.println("Total de habitaciones sucias: " + sucias + " (" + String.format("%.2f", porcentajeSucias) + "%)");
        System.out.println("Ganancias actuales: $" + String.format("%.2f", ganancias));
    }
}