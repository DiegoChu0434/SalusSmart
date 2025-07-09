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
    private Citas citaEditar;
 

    public Cita(String rolUsuario, int idPaciente) {
        this.rolUsuario = rolUsuario;
        this.idPaciente = idPaciente;
        initComponents();
        cargarEspecialidades();
        cargarCentrosSalud();
        cargarHoras();
        cargarMinutos();
        String especialidad = (String) comboEspecialidades.getSelectedItem();
        cargarDoctoresPorEspecialidad(especialidad);
    }
    

 
    
    private void cargarDatosCitaEditar() {
    try {
       
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date fecha = sdf.parse(citaEditar.getFechaHora());
        jCalendar1.setDate(fecha);

       
        String horaStr = citaEditar.getFechaHora().substring(11, 13);
        String minutosStr = citaEditar.getFechaHora().substring(14, 16);
        comboHora.setSelectedItem(horaStr);
        comboMinutos.setSelectedItem(minutosStr);

        
        comboEspecialidades.setSelectedItem(citaEditar.getTipoAtencion());

        HospitalDAO hospitalDAO = new HospitalDAO();
        String nombreCentro = hospitalDAO.obtenerNombreCentroPorId(citaEditar.getIdCentro());
        comboCentroSalud.setSelectedItem(nombreCentro);

        
        cargarDoctoresPorEspecialidad(citaEditar.getTipoAtencion());

        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoDAO.obtenerMedicoPorId(citaEditar.getIdMedico());
        if (medico != null) {
            comboDoctores.setSelectedItem(medico);
        }

        button.setText("Actualizar"); 

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error cargando datos para edición: " + e.getMessage());
        }
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
    
    private void cargarHoras() {
        comboHora.removeAllItems();
        for (int i = 0; i < 24; i++) {
            comboHora.addItem(String.format("%02d", i));
        }
        comboHora.setSelectedItem("08"); // ACA LA HORA POR DEFECTO QUE MAYORMENTE COMIENZAN 8 AM 
    }

    private void cargarMinutos() {
        comboMinutos.removeAllItems();
        for (int i = 0; i < 60; i += 15) {  //DIEGO ACA CADA 15 MIN AVANZA POR QUE UNA CITA PROX DURA 15 MIN CREO
            comboMinutos.addItem(String.format("%02d", i));
        }
        comboMinutos.setSelectedItem("00"); // Y ACA VAN LOS MINUTOS MANITO
    }

    private void cargarDoctoresPorEspecialidad(String especialidad) {
        MedicoDAO medicoDAO = new MedicoDAO();
        List<Medico> medicos = medicoDAO.obtenerMedicosPorEspecialidad(especialidad);
        comboDoctores.removeAllItems();
        for (Medico medico : medicos) {
            comboDoctores.addItem(medico);
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
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        comboDoctores = new javax.swing.JComboBox<>();
        apPLbl1 = new javax.swing.JLabel();
        comboHora = new javax.swing.JComboBox<>();
        comboMinutos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        title.setText("Registrar Cita");

        apPLbl.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
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

        comboCentroSalud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCentroSaludActionPerformed(evt);
            }
        });

        comboEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEspecialidadesActionPerformed(evt);
            }
        });

        jLabel1.setText("Doctores");

        comboDoctores.setForeground(new java.awt.Color(0, 153, 255));
        comboDoctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDoctoresActionPerformed(evt);
            }
        });

        apPLbl1.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        apPLbl1.setText("Hora");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reloj.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                .addGap(10, 10, 10))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apPLbl)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(apPLbl1))
                                .addGap(36, 36, 36)
                                .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(comboMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboEspecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(phoneLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addGap(218, 218, 218))
                            .addComponent(comboCentroSalud, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(domLbl)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDoctores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(phoneLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCentroSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(domLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apPLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(apPLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(115, 115, 115)
                .addComponent(jButton1)
                .addContainerGap())
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
            .addGap(0, 882, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
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
        java.util.Date fechaSeleccionada = jCalendar1.getDate();
        String especialidad = (String) comboEspecialidades.getSelectedItem();
        String nombreCentro = (String) comboCentroSalud.getSelectedItem();
        String hora = (String) comboHora.getSelectedItem();
        String minutos = (String) comboMinutos.getSelectedItem();

        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha.");
            return;
        }
        if (especialidad == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una especialidad.");
            return;
        }
        if (nombreCentro == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un centro de salud.");
            return;
        }
        if (hora == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una hora.");
            return;
        }
        if (minutos == null) {
            JOptionPane.showMessageDialog(this, "Seleccione los minutos.");
            return;
        }

        Medico medicoSeleccionado = (Medico) comboDoctores.getSelectedItem();
        if (medicoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un doctor.");
            return;
        }
        int idMedico = medicoSeleccionado.getId();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fechaHora = sdf.format(fechaSeleccionada) + " " + hora + ":" + minutos + ":00";

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
        jCalendar1.setDate(null);
        comboEspecialidades.setSelectedIndex(-1);
        comboCentroSalud.setSelectedIndex(-1);
        comboHora.setSelectedItem("09");
        comboMinutos.setSelectedItem("00");
        comboDoctores.setSelectedIndex(-1);
    }//GEN-LAST:event_buttonActionPerformed

 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Menu men = new Menu(rolUsuario);
         men.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboDoctoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDoctoresActionPerformed
     
    }//GEN-LAST:event_comboDoctoresActionPerformed

    private void comboEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEspecialidadesActionPerformed
      String especialidad = (String) comboEspecialidades.getSelectedItem();
    cargarDoctoresPorEspecialidad(especialidad);
    }//GEN-LAST:event_comboEspecialidadesActionPerformed

    private void comboCentroSaludActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCentroSaludActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCentroSaludActionPerformed

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
    private javax.swing.JLabel apPLbl1;
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JComboBox<String> comboCentroSalud;
    private javax.swing.JComboBox<Medico> comboDoctores;
    private javax.swing.JComboBox<String> comboEspecialidades;
    private javax.swing.JComboBox<String> comboHora;
    private javax.swing.JComboBox<String> comboMinutos;
    private javax.swing.JLabel domLbl;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
