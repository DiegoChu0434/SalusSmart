package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JOptionPane;
import java.util.List;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import java.io.IOException;

public class Menu extends javax.swing.JFrame {
    private String rolUsuario;
 
    public Menu(String rolUsuario) {
        this.rolUsuario = rolUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        if ("admin".equalsIgnoreCase(rolUsuario)) {
        btnCitas.setVisible(false);
        btnPerfil.setVisible(true);
        btnHospital.setVisible(true);
        btnPersonal.setVisible(true);
        btnHistorial.setVisible(true);
        btnPacientes.setVisible(true);
        btnCerrar.setVisible(true);
    } else if ("paciente".equalsIgnoreCase(rolUsuario)) {
        btnCitas.setVisible(true);
        btnPerfil.setVisible(true);
        btnHospital.setVisible(true);
        btnCerrar.setVisible(true);

        btnPersonal.setVisible(false);
        btnHistorial.setVisible(false);
        btnPacientes.setVisible(false);
    }
    }
    public Menu(){
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPerfil = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnHospital = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnPersonal1 = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(51, 204, 255));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        navText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        navText.setForeground(new java.awt.Color(255, 255, 255));
        navText.setText("BIENVENIDOS AL SOFTWARE PARA SISTEMA DE SALUD RURAL");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navText)
                .addGap(195, 195, 195))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(51, 204, 255));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        btnPerfil.setBackground(new java.awt.Color(51, 204, 255));
        btnPerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnPerfil.setText("PERFIL");
        btnPerfil.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnPerfil.setBorderPainted(false);
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPerfil.setIconTextGap(13);
        btnPerfil.setInheritsPopupMenu(true);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnCitas.setBackground(new java.awt.Color(51, 204, 255));
        btnCitas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnCitas.setText("CITAS MEDICAS");
        btnCitas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnCitas.setBorderPainted(false);
        btnCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCitas.setIconTextGap(13);
        btnCitas.setInheritsPopupMenu(true);
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });

        btnPersonal.setBackground(new java.awt.Color(51, 204, 255));
        btnPersonal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPersonal.setForeground(new java.awt.Color(255, 255, 255));
        btnPersonal.setText("PERSONAL MEDICOS");
        btnPersonal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnPersonal.setBorderPainted(false);
        btnPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPersonal.setIconTextGap(13);
        btnPersonal.setInheritsPopupMenu(true);
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        btnHistorial.setBackground(new java.awt.Color(51, 204, 255));
        btnHistorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("HISTORIAL MEDICO");
        btnHistorial.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnHistorial.setBorderPainted(false);
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHistorial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHistorial.setIconTextGap(13);
        btnHistorial.setInheritsPopupMenu(true);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escudo-de-salud.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SalusSmart S.A.C");

        btnHospital.setBackground(new java.awt.Color(51, 204, 255));
        btnHospital.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHospital.setForeground(new java.awt.Color(255, 255, 255));
        btnHospital.setText("HOSPITAL");
        btnHospital.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnHospital.setBorderPainted(false);
        btnHospital.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHospital.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHospital.setIconTextGap(13);
        btnHospital.setInheritsPopupMenu(true);
        btnHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(51, 204, 255));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("CERRAR SESION");
        btnCerrar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnCerrar.setBorderPainted(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrar.setIconTextGap(13);
        btnCerrar.setInheritsPopupMenu(true);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnPersonal1.setBackground(new java.awt.Color(51, 204, 255));
        btnPersonal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPersonal1.setForeground(new java.awt.Color(255, 255, 255));
        btnPersonal1.setText("FORMULAR PDF");
        btnPersonal1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnPersonal1.setBorderPainted(false);
        btnPersonal1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPersonal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPersonal1.setIconTextGap(13);
        btnPersonal1.setInheritsPopupMenu(true);
        btnPersonal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonal1ActionPerformed(evt);
            }
        });

        btnPacientes.setBackground(new java.awt.Color(51, 204, 255));
        btnPacientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPacientes.setForeground(new java.awt.Color(255, 255, 255));
        btnPacientes.setText("PACIENTES");
        btnPacientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btnPacientes.setBorderPainted(false);
        btnPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPacientes.setIconTextGap(13);
        btnPacientes.setInheritsPopupMenu(true);
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel6)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnHospital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersonal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addGap(20, 20, 20)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPersonal1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
            Perfil perfil = new Perfil(rolUsuario);
            perfil.setLocationRelativeTo(null);
            perfil.setVisible(true);
            this.dispose();
            
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
            Usuario usuario = Sesion.getUsuarioActual();

            if (!usuario.getRol().equalsIgnoreCase("paciente")) {
                JOptionPane.showMessageDialog(this, "Solo los pacientes pueden registrar citas.");
                return;
            }

            int idUsuarioLogueado = usuario.getId_usuario(); 
            Cita cita = new Cita(usuario.getRol(), idUsuarioLogueado);
            cita.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnCitasActionPerformed
            
    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
            Medicos medi = new Medicos(rolUsuario);
            medi.setLocationRelativeTo(null);
            medi.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
            Historial his = new Historial(rolUsuario);
            his.setLocationRelativeTo(null);
            his.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
            Paciente pa = new Paciente(rolUsuario);
            pa.setLocationRelativeTo(null);
            pa.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalActionPerformed
            Hospital hos = new Hospital(rolUsuario);
            hos.setLocationRelativeTo(null);
            hos.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnHospitalActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Inicio ini = new Inicio();
        ini.setLocationRelativeTo(null);
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnPersonal1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            System.out.println("Iniciando exportación a PDF...");
            
          
            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();
            System.out.println("Usuarios obtenidos: " + usuarios.size());
            
            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "No hay usuarios para exportar", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

           
            File directory = new File("reportes");
            if (!directory.exists()) {
                directory.mkdirs();
            }

           
            String fileName = "reportes" + File.separator + "Usuarios_" + 
                            LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + ".pdf";
            
            
            PDFReportGenerator.generarReporteUsuarios(usuarios, fileName);
            
            JOptionPane.showMessageDialog(this, 
                "Archivo PDF creado exitosamente en:\n" + new File(fileName).getAbsolutePath(), 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            System.out.println("Error detallado: " + e.getMessage());
            JOptionPane.showMessageDialog(this, 
                "Error al exportar a PDF: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }                                            

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnHospital;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnPersonal1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navText;
    // End of variables declaration//GEN-END:variables
}
