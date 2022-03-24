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
public class Conductor {
    
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private Date fechaIngreso;
    private Date fechaAsiRuta;

    public Conductor(String identificacion, String nombres, String apellidos, String telefono, String direccion, Date fechaIngreso, Date fechaAsiRuta) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.fechaAsiRuta = fechaAsiRuta;
    }

    public Conductor() {
        this.identificacion = "";
        this.nombres = "";
        this.apellidos = "";
        this.telefono = "";
        this.direccion = "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataFormateada = formato.parse("0/0/0");
            this.fechaIngreso = dataFormateada;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error..." + ex);
        }
        try {
            Date dataFormateada = formato.parse("0/0/0");
            this.fechaAsiRuta = dataFormateada;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error..." + ex);
        }
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaAsiRuta() {
        return fechaAsiRuta;
    }

    public void setFechaAsiRuta(Date fechaAsiRuta) {
        this.fechaAsiRuta = fechaAsiRuta;
    }

    @Override
    public String toString() {
        return "Conductor{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaIngreso=" + fechaIngreso + ", fechaAsiRuta=" + fechaAsiRuta + '}';
    }
    
    
    
    
    
    
    
}
