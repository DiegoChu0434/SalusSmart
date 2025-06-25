
package Interfaces;


public class Inicio extends javax.swing.JFrame {

 
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIni = new javax.swing.JButton();
        btnregi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btngmail = new javax.swing.JButton();
        btnfacebook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("SalusSmart S.A.C");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tu salud mas cerca, sin importar la distancia");

        btnIni.setBackground(new java.awt.Color(51, 204, 255));
        btnIni.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnIni.setForeground(new java.awt.Color(255, 255, 255));
        btnIni.setText("INICIAR SESION");
        btnIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniActionPerformed(evt);
            }
        });

        btnregi.setBackground(new java.awt.Color(51, 204, 255));
        btnregi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnregi.setForeground(new java.awt.Color(255, 255, 255));
        btnregi.setText("REGISTRARSE");
        btnregi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregiActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Or");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escudo-de-salud.png"))); // NOI18N

        btngmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gmail.png"))); // NOI18N
        btngmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmailActionPerformed(evt);
            }
        });

        btnfacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/facebook.png"))); // NOI18N
        btnfacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacebookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnIni, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnregi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btngmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfacebook)
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIni, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngmail)
                    .addComponent(btnfacebook))
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniActionPerformed
            Login login = new Login(); 
            login.setVisible(true);    
            this.dispose();
    }//GEN-LAST:event_btnIniActionPerformed

    private void btnregiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregiActionPerformed
            Register registro = new Register();
            registro.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnregiActionPerformed

    private void btngmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmailActionPerformed
         try {
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        java.net.URI uri = new java.net.URI("https://mail.google.com/");
        desktop.browse(uri);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btngmailActionPerformed

    private void btnfacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacebookActionPerformed
          try {
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        java.net.URI uri = new java.net.URI("https://www.facebook.com/");
        desktop.browse(uri);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnfacebookActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIni;
    private javax.swing.JButton btnfacebook;
    private javax.swing.JButton btngmail;
    private javax.swing.JButton btnregi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
