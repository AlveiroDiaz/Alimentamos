/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author anca2
 */
public class Proveedor {
    private int nit;
    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;

    public Proveedor(int nit, String nombre, String contacto, String direccion, String telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Proveedor() {
        this.nit = 0;
        this.nombre = "";
        this.contacto = "";
        this.direccion = "";
        this.telefono = "";
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
