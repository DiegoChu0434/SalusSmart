package Interfaces;

import Sql.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class Paciente extends javax.swing.JFrame {
     private String rolUsuario;
     private Connection conn;

    public Paciente(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        PacientesDAO dao = new PacientesDAO();
        List<Usuario> lista = dao.obtenerTodosLosUsuarios();
        llenarTablaConPacientes(lista);
    }
    private void llenarTablaConPacientes(List<Usuario> lista) {
        String[] columnas = {"ID", "Nombre", "Apellido", "DNI", "Fecha Nac.", "Celular", "Dirección", "Correo", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);


        for (Usuario u : lista) {
            Object[] fila = new Object[] {
                u.getId_usuario(),
                u.getNombre(),
                u.getApellido(),
                u.getDni(),
                u.getFechaNacimiento(),
                u.getDireccion(),
                u.getCelular(),
                u.getCorreo(),
                u.getRol()
            };
            modelo.addRow(fila);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bntActulizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setBackground(new java.awt.Color(18, 90, 173));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido ", "Dni", "Fecha Nacimiento", "Celular", "Direccion", "Correo", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        bntActulizar.setBackground(new java.awt.Color(18, 90, 173));
        bntActulizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bntActulizar.setForeground(new java.awt.Color(255, 255, 255));
        bntActulizar.setText("Actulizar");
        bntActulizar.setBorderPainted(false);
        bntActulizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bntActulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActulizarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        title.setText("USUARIOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(539, 539, 539)
                                .addComponent(bntActulizar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(bntActulizar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
                String dni = txtdni.getText().trim();
                List<Usuario> lista = new ArrayList<>();
                String sql = "SELECT id_usuario, nombres, apellidos, dni, fecha_nacimiento, contacto, direccion, correo, rol FROM Usuario WHERE dni = ?";


                try (Connection conn = Conexion.getConexion();
                     PreparedStatement ps = conn.prepareStatement(sql)) {

                    ps.setString(1, dni);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Usuario u = new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nombres"),        
                            rs.getString("apellidos"),
                            rs.getInt("dni"),
                            rs.getString("fecha_nacimiento"),
                            rs.getString("contacto"),
                            rs.getString("direccion"),
                            rs.getString("correo"),
                            "",  
                            rs.getString("rol")
                        );
                        lista.add(u);
                    }


                   

                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar paciente.");
                }
                txtdni.setText("");
                llenarTablaConPacientes(lista);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed

    }//GEN-LAST:event_jTable1MousePressed

    private void bntActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActulizarActionPerformed
        PacientesDAO dao = new PacientesDAO();
    List<Usuario> lista = dao.obtenerTodosLosUsuarios();
    llenarTablaConPacientes(lista);
    }//GEN-LAST:event_bntActulizarActionPerformed

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
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paciente("admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActulizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtdni;
    // End of variables declaration//GEN-END:variables
}
