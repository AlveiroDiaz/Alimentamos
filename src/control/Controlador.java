/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author Al
 */
public class Controlador implements ActionListener {

    FramePrincipal vPrincipal;
    VentanaAddRuta vAddRuta;
    AgregarPiloto vAddPiloto;
    ventanaAddCiudad vAddCiudad;
    login vLogin;
    VentanaAddProveedor vAddProveedor;
    ventanaCliente vCliente;
    Conexion conn;
    Cliente cliente = null;

    public Controlador() {
        this.vPrincipal = new FramePrincipal();
        this.vAddRuta = new VentanaAddRuta();
        this.vAddPiloto = new AgregarPiloto();
        this.vAddCiudad = new ventanaAddCiudad();
        this.conn = new Conexion();
        this.vLogin = new login();
        this.vCliente = new ventanaCliente();
    }

    public void iniciar() {
        vPrincipal.getAddRuta().addActionListener(this);
        vPrincipal.getAddPilot().addActionListener(this);
        vLogin.getBtnLogin().addActionListener(this);
        vLogin.getBtnRegistrarU().addActionListener(this);
        vAddRuta.getComboBox().addActionListener(this);
        vAddRuta.getBotonAddRuta().addActionListener(this);
        vAddPiloto.getBotonAddPiloto().addActionListener(this);
        vCliente.getBtnConsultarPedido().setVisible(false);
        vCliente.getBtnGenPedido().setVisible(false);
        vCliente.setVisible(true);
        abrirVentana(vLogin);
                
    }
       

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource() == vLogin.getBtnLogin()){
            conn.conectar();
            cliente = conn.login(vLogin.getTxtUsuario().getText(), vLogin.getTxtPass().getText());
            
            if(cliente.getRol() != null){
                if(cliente.getRol().equals("admin")){
                vCliente.setVisible(false);
                vPrincipal.setVisible(true);
                vLogin.setVisible(false);
            }else{
                if(cliente.getRol().equals("cliente")){
                    vLogin.setVisible(false);
                    vCliente.getBtnConsultarPedido().setVisible(true);
                    vCliente.getBtnGenPedido().setVisible(true);
                }
                }
            }
            
            
        }

        if (e.getSource() == vPrincipal.getAddRuta()) {
            vAddRuta.getjTextArea1().setText("");
            vAddRuta.getComboBox().setSelectedIndex(0);
            abrirVentana(vAddRuta);
            ArrayList<Conductor> conductor = new ArrayList<>();
            conn.conectar();
            conn.conductores(conductor);
            conn.desconectar();
            for (Conductor con : conductor) {
                vAddRuta.getComboBox().addItem(con.getNombres() + " " + con.getApellidos());
            }
        }

        if (e.getSource() == vPrincipal.getAddPilot()) {
            abrirVentana(vAddPiloto);
        }

        if (e.getSource() == vAddRuta.getComboBox()) {

            if (vAddRuta.getComboBox().getSelectedItem() != "Seleccione conductor") {
                vAddRuta.getjTextArea1().setText(vAddRuta.getjTextArea1().getText() + vAddRuta.getComboBox().getSelectedItem() + "\n");
                vAddRuta.getComboBox().removeItem(vAddRuta.getComboBox().getSelectedItem());
            }

        }

        if (e.getSource() == vAddRuta.getBotonAddRuta()) {
            try {
                if(vAddRuta.getTxtFechaApe().toString() != ""){
                    String[] parts = vAddRuta.getTxtFechaApe().toString().split("/");
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataFormateada = formato.parse(parts[2] + "/" + parts[1] + "/" + parts[0]);

                    Calendar calendar = Calendar.getInstance();
                    Ruta objRuta = new Ruta(vAddRuta.getTxtNombre().toString(), dataFormateada,  vAddRuta.getTxtCiudad().toString(), Integer.parseInt(vAddRuta.getTxtCosto().toString()), calendar.getTime());

                    ArrayList<Conductor> conductor = new ArrayList<>();
                    conn.conectar();
                    conn.conductores(conductor);
                    conn.desconectar();
                }
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Ruta objRuta = new Ruta(vAddRuta.getTxtNombre().toString(), calendar.getTime(), vAddRuta.getTxtCiudad().toString(), Integer.parseInt(vAddRuta.getTxtCosto().toString()), calendar.getTime());
                
                ArrayList<Conductor> conductor = new ArrayList<>();
                conn.conectar();
                conn.conductores(conductor);
                conn.desconectar();
                
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Por favor ingresar la fecha de esta manera: dia/mes/año");
            }

        }

        if (e.getSource() == vAddPiloto.getBotonAddPiloto()) {

            Conductor objPiloto = new Conductor();

            objPiloto.setNombres(vAddPiloto.getTxtNombre().getText());
            objPiloto.setApellidos(vAddPiloto.getTxtApellidos().getText());

            System.out.println("" + objPiloto.toString());

            /*listaPilot.getConductores().add(objPiloto);*/
        }
    }

    public void abrirVentana(JInternalFrame frm) {
        try {
            vAddRuta.setVisible(false);
            vAddPiloto.setVisible(false);
            vPrincipal.getjDesktopPane1().add(frm);
            vCliente.getjDesktopPane1().add(frm);
        } catch (Exception e) {
            vPrincipal.getjDesktopPane1().remove(frm);
            vPrincipal.getjDesktopPane1().add(frm);
            vCliente.getjDesktopPane1().add(frm);
            vCliente.getjDesktopPane1().remove(frm);
        }
        frm.setVisible(true);
    }
}
