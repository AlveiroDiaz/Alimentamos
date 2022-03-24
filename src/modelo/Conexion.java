/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonia Pinzón
 */
public class Conexion {

    private Connection conexion;
    private String bd, usuario, clave;
    private Statement stmtC;

    public Conexion(Connection conexion, String bd, String usuario, String clave, Statement stmtC) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.stmtC = stmtC;
    }

    public Conexion() {
        this.conexion = null;
        this.bd = "alimentamos";
        this.usuario = "postgres";
        this.clave = "1205";
        this.stmtC = null;
    }

    public void conectar() {
        try {
            
            String ruta = "jdbc:postgresql://localhost/"+bd;
            conexion = DriverManager.getConnection(ruta, usuario, clave);
            JOptionPane.showMessageDialog(null, "Conexión exitosa...");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "No se puede conectar con PGSQL...");
        }
    }

    public void desconectar() {
        try {
            conexion.close();
            stmtC.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha cerrado la conexion...");
        }
    }

    public ArrayList conductores(ArrayList<Conductor> conductor) {
        try {
            String busqueda = ("Select * from conductor where Fecha_asignacion isnull");
            stmtC = conexion.createStatement();
            ResultSet rsC = stmtC.executeQuery(busqueda);
            if (rsC.next()) {
                String[] parts = rsC.getString("Fecha_ingreso").split("-");
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaIngreso = null;
                try {
                    Date dataFormateada = formato.parse(parts[2] + "/" + parts[1] + "/" + parts[0]);
                    fechaIngreso = dataFormateada;
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error..." + ex);
                }
                
                Conductor con = new Conductor(rsC.getString("Identificacion"), rsC.getString("Nombres"), rsC.getString("Apellidos"), "", rsC.getString("Direccion"), fechaIngreso,null);
                conductor.add(con);
            } else {
                JOptionPane.showMessageDialog(null, "No hay conductores disponibles");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error de consulta...");
        }
        return conductor;
    }
}