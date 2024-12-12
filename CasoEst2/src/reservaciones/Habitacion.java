/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservaciones;

/**
 *
 * @author tamar
 */
public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    private String estado;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = Math.round(precio * 100.0) / 100.0; 
        this.estado = "Libre";
    }
    
    //SETTERS Y GETTERS
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = Math.round(precio * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "\nNumero: " + numero +"\n"+
                "Tipo: " + tipo + "\n" +
                "Precio: " + precio + "\n" +
                "Estado: " + estado + "\n";
    }
}