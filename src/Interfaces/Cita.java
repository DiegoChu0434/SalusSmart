
package Interfaces;

import Sql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;


public class Cita extends javax.swing.JFrame {
    private String rolUsuario;
    private int idPaciente;
  
    public Cita(String rolUsuario, int idPaciente) {
    this.rolUsuario = rolUsuario;
    this.idPaciente = idPaciente;
    initComponents();
    cargarEspecialidades();
    cargarCentrosSalud();
    }
    private void cargarEspecialidades() {
        MedicoDAO dao = new MedicoDAO();
        List<String> especialidades = dao.obtenerEspecialidades();

        comboEspecialidades.removeAllItems(); 
        for (String esp : especialidades) {
            comboEspecialidades.addItem(esp);
        }
    }

    private void cargarCentrosSalud() {
        HospitalDAO dao = new HospitalDAO();
        List<String> nombres = dao.listarNombres();

        comboCentroSalud.removeAllItems();
        for (String nombre : nombres) {
            comboCentroSalud.addItem(nombre);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        apPLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        domLbl = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        phoneLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboCentroSalud = new javax.swing.JComboBox<>();
        comboEspecialidades = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setText("Registrar Cita");

        apPLbl.setText("Fecha ");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        domLbl.setText("Especialidad");

        button.setBackground(new java.awt.Color(18, 90, 173));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Registrar");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        phoneLbl.setText("Centro de Salud");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(apPLbl))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(domLbl)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboEspecialidades, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                        .addComponent(phoneLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(218, 218, 218))
                                    .addComponent(comboCentroSalud, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(72, 72, 72))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(553, 553, 553))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(apPLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(phoneLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCentroSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(domLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed

       try {
        String fechaHora = txtFecha.getText().trim();  
        String especialidad = (String) comboEspecialidades.getSelectedItem();
        String nombreCentro = (String) comboCentroSalud.getSelectedItem();

        if (fechaHora.isEmpty() || especialidad == null || nombreCentro == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        MedicoDAO medicoDAO = new MedicoDAO();
        int idMedico = medicoDAO.obtenerIdMedicoPorEspecialidad(especialidad);

        HospitalDAO hospitalDAO = new HospitalDAO();
        int idCentro = hospitalDAO.obtenerIdCentroPorNombre(nombreCentro);

        Interfaces.PacientesDAO pacientesDAO = new Interfaces.PacientesDAO();
        pacientesDAO.registrarSiNoExiste(idPaciente);

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM historialclinico WHERE id_paciente = ?")) {
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                try (PreparedStatement insert = conn.prepareStatement("INSERT INTO historialclinico (id_paciente) VALUES (?)")) {
                    insert.setInt(1, idPaciente);
                    insert.executeUpdate();
                }
            }
        }

        Citas cita = new Citas(fechaHora, especialidad, "Pendiente", idPaciente, idMedico, idCentro);
        CitaDAO citaDAO = new CitaDAO();
        boolean resultado = citaDAO.insertarConPaciente(cita);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Cita registrada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la cita.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    txtFecha.setText("");  
    comboEspecialidades.setSelectedIndex(-1);  
    comboCentroSalud.setSelectedIndex(-1); 
    }//GEN-LAST:event_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                   new Cita("admin", 1).setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apPLbl;
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JComboBox<String> comboCentroSalud;
    private javax.swing.JComboBox<String> comboEspecialidades;
    private javax.swing.JLabel domLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
