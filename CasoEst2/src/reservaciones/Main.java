/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservaciones;

import javax.swing.JOptionPane;


/**
 *
 * @author tamar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // PROFE HICE LO QUE PUDE, ESTE EXAMEN ME VOLVIO LOCA, UNA DISCULPA SI NO CUMPLO CON LAS ESPECTATIVAS :(((((
        
        Hotel hotel = new Hotel(5, 5); // 5 pisos con 5 habitaciones cada uno
        hotel.mostrarHabitaciones();

        // Reservar habitación
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de habitación a reservar (Simple o Doble):");
        Habitacion habitacion = hotel.buscarHabitacionLibre(tipo);

        if (habitacion != null) {
            habitacion.setEstado("Ocupada");
            JOptionPane.showMessageDialog(null, "Habitación reservada: " + habitacion);
        } else {
            JOptionPane.showMessageDialog(null, "No hay habitaciones libres del tipo solicitado.");
        }

        hotel.mostrarHabitaciones();

        // Modificar información de una habitación
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la habitación a modificar:"));
        String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado (Libre, Ocupada, Sucia):");
        String nuevoTipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo (Simple o Doble):");
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio por noche:"));

        hotel.modificarHabitacion(numero, nuevoEstado, nuevoTipo, nuevoPrecio);
        hotel.mostrarHabitaciones();

        // Generar resumen del estado del hotel
        hotel.generarResumen();
    }
}


