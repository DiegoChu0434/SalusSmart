/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaces;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
public class PanelMapa extends JPanel {

     private JFXPanel jfxPanel;
    private WebEngine webEngine;

    public PanelMapa() {
        setLayout(new BorderLayout());
        jfxPanel = new JFXPanel(); // Permite usar JavaFX dentro de Swing
        add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            WebView webView = new WebView();
            webEngine = webView.getEngine();
            // URL para buscar hospitales cerca de ti
            String mapsUrl = "https://www.google.com/maps/search/hospitales+cerca+de+mi/";
            webEngine.load(mapsUrl);
            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
