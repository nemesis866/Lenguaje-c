/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Paulo Andrade <source.compu at gmail.com>
 */
public class CreacionVentana extends javax.swing.JFrame
{
    JLabel lblTexto1;
    JLabel lblTexto2;

    /**
     * Creates new form CreacionVentana
     */
    public CreacionVentana() {
        initComponents();
        this.creacionVentana();
    }
    
    // Creamos la ventana principal
    private void creacionVentana()
    {
        // Ventana principal
        this.setTitle("Proyecto eventos con raton");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        // Configuracion lblTexto1
        lblTexto1 = new JLabel();
        lblTexto1.setText("---");
        lblTexto1.setBounds(50, 10, 300, 20);
        this.getContentPane().add(lblTexto1);
        
        // Configuracion lblTexto2
        lblTexto2 = new JLabel();
        lblTexto2.setText("");
        lblTexto2.setBounds(50, 50, 300, 250);
        lblTexto2.setOpaque(true);
        lblTexto2.setBackground(Color.RED);
        this.getContentPane().add(lblTexto2);
        
        // Eventos del raton de la zona color roja
        lblTexto2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                lblTexto2mouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt){
                lblTexto2mouseExited(evt);
            }
            @Override
            public void mousePressed(MouseEvent evt){
                lblTexto2mousePressed(evt);
            }
        });
    }
    
    // Cuando el mouse entra en la zona
    public void lblTexto2mouseEntered(MouseEvent evt)
    {
        lblTexto1.setText("El raton acaba de entrar a la zona");
    }
    
    // Cuando el raton sale de la zona
    public void lblTexto2mouseExited(MouseEvent evt)
    {
        lblTexto1.setText("El raton acaba de salir a la zona");
    }
    
    // Cuando se da clic con el mouse en la zona
    public void lblTexto2mousePressed(MouseEvent evt)
    {
        // Verificamos cual boton fue presionado
        switch (evt.getButton()) {
            case MouseEvent.BUTTON1:
                lblTexto1.setText("Se hizo clic con el boton izquierdo");
                break;
            case MouseEvent.BUTTON2:
                lblTexto1.setText("Se hizo clic con el boton central");
                break;
            case MouseEvent.BUTTON3:
                lblTexto1.setText("Se hizo clic con el boton derecho");
                break;
            default:
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreacionVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreacionVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreacionVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreacionVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreacionVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
