/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Al
 */
public class Ruta {
    
    
    private String nombre;
    private Date fechaApertura;
    private String ciudadDestino;
    private double costo;
    private Date fechaCambio;

    public Ruta(String nombre, Date fechaApertura, String ciudadDestino, double costo, Date fechaCambio) {
        this.nombre = nombre;
        this.fechaApertura = fechaApertura;
        this.ciudadDestino = ciudadDestino;
        this.costo = costo;
        this.fechaCambio = fechaCambio;
    }
    
    public Ruta() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataFormateada = formato.parse("0/0/0");
            this.fechaApertura = dataFormateada;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error..." + ex);
        }
        this.nombre = "";
        this.ciudadDestino = "";
        this.costo = 0;
        try {
            Date dataFormateada = formato.parse("0/0/0");
            this.fechaCambio = dataFormateada;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error..." + ex);
        }   
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    @Override
    public String toString() {
        return "Ruta{" + "nombre=" + nombre + ", fechaApertura=" + fechaApertura + ", ciudadDestino=" + ciudadDestino + ", costo=" + costo + ", fechaCambio=" + fechaCambio + '}';
    }
    
    
    
    
    
}
