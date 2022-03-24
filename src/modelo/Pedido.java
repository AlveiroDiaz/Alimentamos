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
 * @author anca2
 */
public class Pedido {
    private String nroPedido;
    private double valor;
    private Date fechaEntrega;

    public Pedido(String nroPedido, double valor, Date fechaEntrega) {
        this.nroPedido = nroPedido;
        this.valor = valor;
        this.fechaEntrega = fechaEntrega;
    }

    public Pedido() {
        this.nroPedido = "";
        this.valor = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataFormateada = formato.parse("0/0/0");
            this.fechaEntrega = dataFormateada;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error..." + ex);
        }
    }

    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
}
