/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Al
 */
public class Cliente {
    private int identificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    private String contra;
    private String rol;
    private String ciudad;

    public Cliente(int identificacion, String nombre, String direccion, String telefono, String contra, String rol, String ciudad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contra = contra;
        this.rol = rol;
        this.ciudad = ciudad;
    }

    public Cliente() {
        this.identificacion = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.contra = "";
        this.rol = "";
        this.ciudad = "";
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", contra=" + contra + ", rol=" + rol + ", ciudad=" + ciudad + '}';
    }
    
    
    
}
