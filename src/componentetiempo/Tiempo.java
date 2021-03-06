/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetiempo;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

/**
 *
 * @author Eli
 */
public class Tiempo extends javax.swing.JPanel implements Serializable {

    Calendar calendario;
    int dia, mes, año, hora, minutos, segundos;
    String horas, fechas;

    public Tiempo() {
        initComponents();
        reloj();
    }

    private void reloj() {
        calendario = new GregorianCalendar();
        segundos = calendario.get(Calendar.SECOND);
        Timer timer = new Timer(1000, (java.awt.event.ActionEvent ae) -> {
            java.util.Date actual = new java.util.Date();
            calendario.setTime(actual);
            dia = calendario.get(Calendar.DAY_OF_MONTH);
            mes = (calendario.get(Calendar.MONTH) + 1);
            año = calendario.get(Calendar.YEAR);
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            horas = String.format("%02d : %02d : %02d", hora, minutos, segundos);
            fechas = String.format("%02d / %02d / %02d", dia, mes, año);
            etiHora.setText(horas + "     " + fechas);
        });
        timer.start();
    }
    
    public void setTamanioFuente(int t){
        etiHora.setFont(new Font(Font.SANS_SERIF, Font.BOLD, t));
    }
    public void setCambiaColor(String color) {
        Color eti_color = Color.BLACK;
        switch (color) {
            case "negro": {
                eti_color = Color.black;
                break;
            }
            case "azul": {
                eti_color = Color.blue;
                break;
            }
            case "amarillo": {
                eti_color = Color.YELLOW;
                break;
            }

        }
        etiHora.setForeground(eti_color);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        etiHora = new javax.swing.JLabel();

        etiHora.setText("hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(etiHora, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(etiHora, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JLabel etiHora;
    // End of variables declaration                   
}
