/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package progettogdr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author arcaleni.daniele2
 */
public class Grafica extends javax.swing.JFrame {

    private JPanel selezionato = null;
    private String player = "";

    /**
     * Creates new form Grafica
     */
    public Grafica() {
        initComponents();
        BottoneSceltaPersonaggio.setEnabled(false);
        BottoneSceltaPersonaggio.setText("Gioca");
        setTitle("Selezione Personaggio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);


        // PANEL 1: immagine ridimensionata
        JLabel label1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon icon = new ImageIcon(getClass().getResource("/progettogdr/PersonaggioGDR.png"));
                Image img = icon.getImage();

                int panelW = getWidth();
                int panelH = getHeight();

                int margin = 15;

                int availableW = panelW - margin * 2;
                int availableH = panelH - margin * 2;

                int imgW = img.getWidth(null);
                int imgH = img.getHeight(null);

                double scale = Math.min((double) availableW / imgW, (double) availableH / imgH) * 1.08;

                int newW = (int) (imgW * scale);
                int newH = (int) (imgH * scale);

                int x = (panelW - newW) / 2 + 10;
                int y = (panelH - newH) / 2;

                g.drawImage(img, x, y, newW, newH, this);
            }
        };
        PanelPersonaggio1.add(label1, BorderLayout.CENTER);
        PanelPersonaggio1.setBounds(25, 90, 150, 200);
        PanelScegliPersonaggio.add(PanelPersonaggio1);

        JLabel label2 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon icon = new ImageIcon(getClass().getResource("/progettogdr/secondoPersonaggio.png"));
                Image img = icon.getImage();

                int panelW = getWidth();
                int panelH = getHeight();

                int margin = 15;

                int availableW = panelW - margin * 2;
                int availableH = panelH - margin * 2;

                int imgW = img.getWidth(null);
                int imgH = img.getHeight(null);

                double scale = Math.min((double) availableW / imgW, (double) availableH / imgH) * 1.08;

                int newW = (int) (imgW * scale);
                int newH = (int) (imgH * scale);

                int x = (panelW - newW) / 2;
                int y = (panelH - newH) / 2;

                g.drawImage(img, x, y, newW, newH, this);
            }
        };
        PanelPersonaggio2.add(label2, BorderLayout.CENTER);
        PanelPersonaggio2.setBounds(230, 90, 160, 200);
        PanelScegliPersonaggio.add(PanelPersonaggio2);

        JLabel label3 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon icon = new ImageIcon(getClass().getResource("/progettogdr/TerzoPersonaggioGDR.png"));
                Image img = icon.getImage();

                int panelW = getWidth();
                int panelH = getHeight();

                int margin = 15;

                int availableW = panelW - margin * 2;
                int availableH = panelH - margin * 2;

                int imgW = img.getWidth(null);
                int imgH = img.getHeight(null);

                double scale = Math.min((double) availableW / imgW, (double) availableH / imgH) * 1.08;

                int newW = (int) (imgW * scale);
                int newH = (int) (imgH * scale);

                int x = (panelW - newW) / 2;
                int y = (panelH - newH) / 2;

                g.drawImage(img, x, y, newW, newH, this);
            }
        };
        PanelPersonaggio3.add(label3, BorderLayout.CENTER);
        PanelPersonaggio3.setBounds(463, 90, 140, 200);
        PanelScegliPersonaggio.add(PanelPersonaggio3);
        
        MouseAdapter selezioneListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selezionato = (JPanel) e.getSource();
                if(selezionato == PanelPersonaggio1){
                    player = "Personaggio1";
                }
                else if(selezionato == PanelPersonaggio2){
                    player = "Personaggio2";
                }
                else if (selezionato == PanelPersonaggio3){
                    player = "Personaggio3";
                }
                evidenziaSelezione();
                BottoneSceltaPersonaggio.setEnabled(true);
            }
        };

        PanelPersonaggio1.addMouseListener(selezioneListener);
        PanelPersonaggio2.addMouseListener(selezioneListener);
        PanelPersonaggio3.addMouseListener(selezioneListener);

        add(PanelScegliPersonaggio);
    }

    private void evidenziaSelezione() {
        PanelPersonaggio1.setBorder(null);
        PanelPersonaggio2.setBorder(null);
        PanelPersonaggio3.setBorder(null);

        // Evidenzia quello selezionato
        if (selezionato != null) {
            selezionato.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
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

        PanelScegliPersonaggio = new javax.swing.JPanel();
        PanelPersonaggio2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelPersonaggio3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BottoneSceltaPersonaggio = new javax.swing.JButton();
        PanelPersonaggio1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOggettoPerso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelScegliPersonaggio.setBackground(new java.awt.Color(255, 255, 204));
        PanelScegliPersonaggio.setLayout(null);

        PanelPersonaggio2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progettogdr/TerzoPersonaggioGDR.png"))); // NOI18N

        javax.swing.GroupLayout PanelPersonaggio2Layout = new javax.swing.GroupLayout(PanelPersonaggio2);
        PanelPersonaggio2.setLayout(PanelPersonaggio2Layout);
        PanelPersonaggio2Layout.setHorizontalGroup(
            PanelPersonaggio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonaggio2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPersonaggio2Layout.setVerticalGroup(
            PanelPersonaggio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPersonaggio2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelScegliPersonaggio.add(PanelPersonaggio2);
        PanelPersonaggio2.setBounds(230, 90, 160, 200);

        PanelPersonaggio3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progettogdr/secondoPersonaggio.png"))); // NOI18N

        javax.swing.GroupLayout PanelPersonaggio3Layout = new javax.swing.GroupLayout(PanelPersonaggio3);
        PanelPersonaggio3.setLayout(PanelPersonaggio3Layout);
        PanelPersonaggio3Layout.setHorizontalGroup(
            PanelPersonaggio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonaggio3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPersonaggio3Layout.setVerticalGroup(
            PanelPersonaggio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPersonaggio3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelScegliPersonaggio.add(PanelPersonaggio3);
        PanelPersonaggio3.setBounds(463, 90, 140, 200);

        BottoneSceltaPersonaggio.setText("Scegli");
        BottoneSceltaPersonaggio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneSceltaPersonaggioActionPerformed(evt);
            }
        });
        PanelScegliPersonaggio.add(BottoneSceltaPersonaggio);
        BottoneSceltaPersonaggio.setBounds(250, 370, 119, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progettogdr/PersonaggioGDR.png"))); // NOI18N

        javax.swing.GroupLayout PanelPersonaggio1Layout = new javax.swing.GroupLayout(PanelPersonaggio1);
        PanelPersonaggio1.setLayout(PanelPersonaggio1Layout);
        PanelPersonaggio1Layout.setHorizontalGroup(
            PanelPersonaggio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonaggio1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPersonaggio1Layout.setVerticalGroup(
            PanelPersonaggio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonaggio1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelScegliPersonaggio.add(PanelPersonaggio1);
        PanelPersonaggio1.setBounds(20, 90, 160, 200);

        txtOggettoPerso.setText("perdiOggetto");
        PanelScegliPersonaggio.add(txtOggettoPerso);
        txtOggettoPerso.setBounds(270, 50, 320, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelScegliPersonaggio, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelScegliPersonaggio, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BottoneSceltaPersonaggioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneSceltaPersonaggioActionPerformed
        PanelScegliPersonaggio.setVisible(false);
        
    }//GEN-LAST:event_BottoneSceltaPersonaggioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Grafica().setVisible(true));
    
    
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BottoneSceltaPersonaggio;
    private javax.swing.JPanel PanelPersonaggio1;
    private javax.swing.JPanel PanelPersonaggio2;
    private javax.swing.JPanel PanelPersonaggio3;
    private javax.swing.JPanel PanelScegliPersonaggio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel txtOggettoPerso;
    // End of variables declaration//GEN-END:variables
}
