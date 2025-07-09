
package Interfaces;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Perfil extends javax.swing.JFrame {
    private String rolUsuario;
    HistorialDAO historialDAO = new HistorialDAO();
    List<Historiales> lista;

   public Perfil(String rolUsuario) {
        this.rolUsuario = rolUsuario;
        initComponents();
        setLocationRelativeTo(null);
        cargarDatosUsuario();
        cargarTablaHistorial();
    }

    private void cargarDatosUsuario() {
        Usuario usuario = Sesion.getUsuarioActual();
        if (usuario != null) {
            jLabel3.setText("Nombre: " + usuario.getNombre());
            jLabel4.setText("Apellido: " + usuario.getApellido());
            jLabel5.setText("DNI: " + usuario.getDni());
            jLabel6.setText("Correo: " + usuario.getCorreo());
            jLabel7.setText("Rol: " + usuario.getRol());
        } else {
            jLabel3.setText("Nombre: -");
            jLabel4.setText("Apellido: -");
            jLabel5.setText("DNI: -");
            jLabel6.setText("Correo: -");
            jLabel7.setText("Rol: -");
        }
    }
  private void cargarTablaHistorial() {
    Usuario usuario = Sesion.getUsuarioActual();
    if (usuario == null) return;

    lista = historialDAO.listarHistorialPorUsuario(usuario.getId_usuario());

    String[] columnas = {"ID","Fecha Cita", "Hora", "Doctor", "Especialidad", "Centro Salud", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);

    for (Historiales h : lista) {
        String fechaHora = h.getFechaCita(); 
        String fecha = fechaHora.length() >= 10 ? fechaHora.substring(0, 10) : fechaHora;
        String hora = fechaHora.length() >= 16 ? fechaHora.substring(11, 16) : "";

        Object[] fila = {
            h.getIdCita(), 
            fecha,                
            hora,                
            h.getNombreMedico(),  
            h.getEspecialidad(),
            h.getCentroSalud(),
            h.getEstado()
        };
        modelo.addRow(fila);
    }

    jTable1.setModel(modelo);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Fecha Cita", "Hora", "Doctor", "Especialidad", "Centro Salud", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu men = new Menu(rolUsuario);
        men.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
       
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                int idCita = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());

                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Está seguro de cancelar esta cita?",
                        "Confirmar cancelación",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {

                    
                    boolean citaEliminada = historialDAO.eliminarCitaPorId(idCita);

                    
                    boolean historialEliminado = historialDAO.eliminarHistorialPorIdCita(idCita);

                    if (citaEliminada && historialEliminado) {
                        JOptionPane.showMessageDialog(this, "✅ Cita cancelada correctamente.");
                    } else if (citaEliminada) {
                        JOptionPane.showMessageDialog(this, "⚠️ Cita cancelada");
                    } else if (historialEliminado) {
                        JOptionPane.showMessageDialog(this, "⚠️ Historial eliminado, pero no se eliminó la cita.");
                    } else {
                        JOptionPane.showMessageDialog(this, "❌ Error al cancelar la cita");
                    }

                    cargarTablaHistorial(); 
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID de cita no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cita para cancelar.");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCita = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());
            CitaDAO citaDAO = new CitaDAO();
            Citas cita = citaDAO.obtenerCitaPorId(idCita);
            if (cita != null) {
                System.out.println("Abriendo ventana de edición para cita con ID: " + idCita);             
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo cargar la cita para modificar.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cita para modificar.");
        }

    }//GEN-LAST:event_btnModificarActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Usuario dummy = new Usuario(1, "Juan", "Perez", 12345678, "2000-01-01", "Dirección", "999999999", "correo@mail.com", "1234", "Administrador");
            Sesion.setUsuarioActual(dummy);
            new Perfil(dummy.getRol()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
