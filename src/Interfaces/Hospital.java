package Interfaces;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;


public class Hospital extends javax.swing.JFrame {
    private String rolUsuario;
    private PanelMapa panelMapa;
    public Hospital(String rolUsuario) {
        this.rolUsuario = rolUsuario;
        initComponents();
        setLocationRelativeTo(null);
        panelMapa = new PanelMapa();
        getContentPane().setLayout(new BorderLayout());
        setSize(1000, 600);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        folioLbl = new javax.swing.JLabel();
        txtHospital = new javax.swing.JTextField();
        libroIdLbl = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        libroIdLbl1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura de pantalla 2025-06-05 112252.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        folioLbl.setText("Nombre Hospital");

        txtHospital.setToolTipText("");

        libroIdLbl.setText("Ubicacion");

        btnRegistrar.setBackground(new java.awt.Color(18, 90, 173));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        libroIdLbl1.setText("Direccion");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addGap(199, 199, 199))
                            .addComponent(txtHospital)
                            .addComponent(txtDireccion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(libroIdLbl1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(libroIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(folioLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(libroIdLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(libroIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombre = txtHospital.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (nombre.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
            return;
        }

        Hospitales hospital = new Hospitales(0,nombre, direccion);


        HospitalDAO dao = new HospitalDAO();
        boolean exito = dao.insertar(hospital);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Hospital registrado correctamente.");
             txtHospital.setText("");
            txtDireccion.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar hospital.");
        } 
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Menu men = new Menu(rolUsuario);
         men.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hospital("admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JLabel libroIdLbl1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtHospital;
    // End of variables declaration//GEN-END:variables
}
