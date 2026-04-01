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
    Enemy nemico = new Enemy("PrimoNemico", 100, "NomeOgettoPerso", 20);
    private Gestore g1;
    private Inventario inventario;
    private String oggettoCorrente;
    /**
     * Creates new form Grafica
     */
    public Grafica() {
        initComponents();

        getContentPane().setLayout(null);
        inventario = new Inventario();
        g1 = new Gestore(0, txtArea, lblNemico, lblOggetto);
        PanelScegliPersonaggio.setLayout(new BorderLayout());
        PanelScegliPersonaggio.add(new PanelConSfondo());

        PanelScegliPersonaggio.setOpaque(false);
        PanelPersonaggio1.setOpaque(false);
        PanelPersonaggio2.setOpaque(false);
        PanelPersonaggio3.setOpaque(false);

        BottoneSceltaPersonaggio.setBounds(250, 370, 119, 30);
        BottoneSceltaPersonaggio.setEnabled(false);

        setTitle("Selezione Personaggio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        
        PanelPausa.setVisible(false);
        Pausa.setBorderPainted(false);
        Pausa.setContentAreaFilled(false);
        Pausa.setFocusPainted(false);
        Pausa.setOpaque(false);
        txtArea.setEditable(false);
        lblOggetto.setVisible(false);
        lblNemico.setVisible(false);
        GameOver.setVisible(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/Immagini/SimboloMenuPausa.png"));
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Pausa.setIcon(new ImageIcon(img));
        PanelInizioPartita.setVisible(false);

        PanelPersonaggio1.setLayout(new BorderLayout());
        JLabel label1 = creaLabel("/Immagini/PersonaggioGDR.png", 90, 120);
        PanelPersonaggio1.add(label1, BorderLayout.CENTER);
        PanelPersonaggio1.setBounds(25, 90, 150, 200);
        
        PanelPersonaggio2.setLayout(new BorderLayout());
        JLabel label2 = creaLabel("/Immagini/secondoPersonaggioGDR.png", 90, 120);
        PanelPersonaggio2.add(label2, BorderLayout.CENTER);
        PanelPersonaggio2.setBounds(230, 90, 160, 200);
        
        PanelPersonaggio3.setLayout(new BorderLayout());
        JLabel label3 = creaLabel("/Immagini/TerzoPersonaggioGDR.png", 90, 120);
        PanelPersonaggio3.add(label3, BorderLayout.CENTER);
        PanelPersonaggio3.setBounds(463, 90, 140, 200);
        
        MouseAdapter selezioneListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selezionato = (JPanel) e.getSource();

                if (selezionato == PanelPersonaggio1) {
                    player = "/Immagini/PersonaggioGDR.png";
                    VitaPersonaggio.setText("120");
                }
                else if (selezionato == PanelPersonaggio2) {
                    player = "/Immagini/secondoPersonaggioGDR.png";
                    txtMangia.setText("2");
                    txtBevi.setText("2");
                    txtInventarioCorrente.setText("4");
                    inventario.aggiungiOggetto("Cibo");
                    inventario.aggiungiOggetto("Acqua");
                }
                else if (selezionato == PanelPersonaggio3) {
                    player = "/Immagini/TerzoPersonaggioGDR.png";
                    txtMangia.setText("0");
                    txtBevi.setText("0");
                    txtInventarioCorrente.setText("0");
                    txtInventarioMassimo.setText("12");
                }

                evidenziaSelezione();
                BottoneSceltaPersonaggio.setEnabled(true);
            }
        };
        
        PanelPersonaggio1.addMouseListener(selezioneListener);
        PanelPersonaggio2.addMouseListener(selezioneListener);
        PanelPersonaggio3.addMouseListener(selezioneListener);
    }
                
    private void ridimensionaFont(Container contenitore, int nuovaGrandezza) {
        for (Component c : contenitore.getComponents()) {
            if (c.getFont() != null) {
                c.setFont(new Font(c.getFont().getName(), c.getFont().getStyle(), nuovaGrandezza));
            }
            if (c instanceof Container) {
                ridimensionaFont((Container) c, nuovaGrandezza);
            }
        }
    }

    class PanelConSfondo extends JPanel {

        private Image sfondo = new ImageIcon(getClass().getResource("/Immagini/SelezionePersonaggio.png")).getImage();

        @Override

        public void paint(Graphics g) {
            super.paint(g);
            Image sfondo = new ImageIcon(getClass().getResource("/Immagini/SelezionePersonaggio.png")).getImage();
            g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);

        }
    }

    private JLabel creaLabel(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(img));
    }

    private void evidenziaSelezione() {

        PanelPersonaggio1.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        PanelPersonaggio2.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        PanelPersonaggio3.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

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

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelInizioPartita = new javax.swing.JPanel();
        PanelPausa = new javax.swing.JPanel();
        BottoneRiprendiPartita = new javax.swing.JButton();
        BottoneSalvaPartita = new javax.swing.JButton();
        BottoneCaricaPartita = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelPersonaggioScelto = new javax.swing.JLabel();
        BottoneBevi = new javax.swing.JButton();
        BottoneMangia = new javax.swing.JButton();
        Pausa = new javax.swing.JButton();
        BottoneAbilitaSpeciale = new javax.swing.JButton();
        txtMangia = new javax.swing.JLabel();
        txtBevi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtInventarioCorrente = new javax.swing.JLabel();
        txtInventarioMassimo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        VitaPersonaggio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAffamato = new javax.swing.JLabel();
        txtAssetato = new javax.swing.JLabel();
        BottoneAvanza = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lblNemico = new javax.swing.JLabel();
        lblOggetto = new javax.swing.JLabel();
        BottonePrendiOggetto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtContaGiorno = new javax.swing.JLabel();
        GameOver = new javax.swing.JLabel();
        BottoneControllaInventario = new javax.swing.JButton();
        PanelScegliPersonaggio = new javax.swing.JPanel();
        PanelPersonaggio2 = new javax.swing.JPanel();
        PanelPersonaggio3 = new javax.swing.JPanel();
        BottoneSceltaPersonaggio = new javax.swing.JButton();
        PanelPersonaggio1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
     

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelInizioPartita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPausa.setBackground(new java.awt.Color(0, 0, 0));
        PanelPausa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BottoneRiprendiPartita.setText("Riprendi");
        BottoneRiprendiPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneRiprendiPartitaActionPerformed(evt);
            }
        });
        PanelPausa.add(BottoneRiprendiPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        BottoneSalvaPartita.setText("SalvaPartita");
        PanelPausa.add(BottoneSalvaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 130, -1));

        BottoneCaricaPartita.setText("CaricaPartita");
        PanelPausa.add(BottoneCaricaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 130, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Pausa");
        PanelPausa.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 160, -1));

        PanelInizioPartita.add(PanelPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 150, 150));
        PanelInizioPartita.add(labelPersonaggioScelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 150, -1, -1));

        BottoneBevi.setText("Bevi");
        BottoneBevi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneBeviActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneBevi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 343, -1, 30));

        BottoneMangia.setText("Mangia");
        BottoneMangia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneMangiaActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneMangia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 303, -1, 30));

        
        Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausaActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(Pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 24, 65, 41));

        BottoneAbilitaSpeciale.setText("Abilità Speciale");
        PanelInizioPartita.add(BottoneAbilitaSpeciale, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        txtMangia.setText("0");
        PanelInizioPartita.add(txtMangia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 40, 30));

        txtBevi.setText("0");
        PanelInizioPartita.add(txtBevi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 40, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Inventario Massimo: ");
        PanelInizioPartita.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("Capienza inventario: ");
        PanelInizioPartita.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        txtInventarioCorrente.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtInventarioCorrente.setText("0");
        PanelInizioPartita.add(txtInventarioCorrente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 80, -1));

        txtInventarioMassimo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtInventarioMassimo.setText("10");
        PanelInizioPartita.add(txtInventarioMassimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 90, -1));

        jLabel7.setFont(new java.awt.Font("Sans Serif Collection", 3, 14)); // NOI18N
        jLabel7.setText("Vita:");
        PanelInizioPartita.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 40, -1));

        jLabel8.setFont(new java.awt.Font("Perpetua", 3, 14)); // NOI18N
        jLabel8.setText("Fame:");
        PanelInizioPartita.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 40, -1));

        VitaPersonaggio.setFont(new java.awt.Font("Sans Serif Collection", 3, 14)); // NOI18N
        VitaPersonaggio.setForeground(new java.awt.Color(51, 255, 51));
        VitaPersonaggio.setText("100");
        PanelInizioPartita.add(VitaPersonaggio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, -1));

        jLabel12.setFont(new java.awt.Font("Perpetua", 3, 14)); // NOI18N
        jLabel12.setText("Sete:");
        PanelInizioPartita.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 40, -1));

        txtAffamato.setFont(new java.awt.Font("Perpetua", 3, 14)); // NOI18N
        txtAffamato.setText("100");
        PanelInizioPartita.add(txtAffamato, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 60, -1));

        txtAssetato.setFont(new java.awt.Font("Perpetua", 3, 14)); // NOI18N
        txtAssetato.setText("100");
        PanelInizioPartita.add(txtAssetato, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 60, -1));

        BottoneAvanza.setText("Avanti");
        BottoneAvanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneAvanzaActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneAvanza, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 50));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        PanelInizioPartita.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 270));

        
        PanelInizioPartita.add(lblNemico, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 140));


        PanelInizioPartita.add(lblOggetto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 130, 150));

        BottonePrendiOggetto.setText("Raccogli");
        BottonePrendiOggetto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottonePrendiOggettoActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottonePrendiOggetto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, 30));

        jLabel15.setFont(new java.awt.Font("Poor Richard", 3, 18)); // NOI18N
        jLabel15.setText("Giorno Numero:");
        PanelInizioPartita.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 130, -1));

        txtContaGiorno.setFont(new java.awt.Font("Poor Richard", 3, 18)); // NOI18N
        txtContaGiorno.setText("0");
        PanelInizioPartita.add(txtContaGiorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 70, 20));
        PanelInizioPartita.add(GameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 150, 140));

        BottoneControllaInventario.setText("Controlla Inventario");
        BottoneControllaInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneControllaInventarioActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneControllaInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 160, -1));

        PanelScegliPersonaggio.setBackground(new java.awt.Color(255, 255, 204));
        PanelScegliPersonaggio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelPersonaggio2Layout = new javax.swing.GroupLayout(PanelPersonaggio2);
        PanelPersonaggio2.setLayout(PanelPersonaggio2Layout);
        PanelPersonaggio2Layout.setHorizontalGroup(
            PanelPersonaggio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        PanelPersonaggio2Layout.setVerticalGroup(
            PanelPersonaggio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        PanelScegliPersonaggio.add(PanelPersonaggio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        javax.swing.GroupLayout PanelPersonaggio3Layout = new javax.swing.GroupLayout(PanelPersonaggio3);
        PanelPersonaggio3.setLayout(PanelPersonaggio3Layout);
        PanelPersonaggio3Layout.setHorizontalGroup(
            PanelPersonaggio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        PanelPersonaggio3Layout.setVerticalGroup(
            PanelPersonaggio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        PanelScegliPersonaggio.add(PanelPersonaggio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 90, -1, -1));

        BottoneSceltaPersonaggio.setText("Scegli");
        BottoneSceltaPersonaggio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneSceltaPersonaggioActionPerformed(evt);
            }
        });
        PanelScegliPersonaggio.add(BottoneSceltaPersonaggio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 119, 30));

        javax.swing.GroupLayout PanelPersonaggio1Layout = new javax.swing.GroupLayout(PanelPersonaggio1);
        PanelPersonaggio1.setLayout(PanelPersonaggio1Layout);
        PanelPersonaggio1Layout.setHorizontalGroup(
            PanelPersonaggio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        PanelPersonaggio1Layout.setVerticalGroup(
            PanelPersonaggio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        PanelScegliPersonaggio.add(PanelPersonaggio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 51));
        jLabel9.setText("+20 Vita Max");
        PanelScegliPersonaggio.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel10.setBackground(new java.awt.Color(51, 255, 51));
        jLabel10.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 51));
        jLabel10.setText("+2 Cibo, +2 Acqua");
        PanelScegliPersonaggio.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel11.setBackground(new java.awt.Color(51, 255, 51));
        jLabel11.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 51));
        jLabel11.setText("+2 Spazio Inventario");
        PanelScegliPersonaggio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelScegliPersonaggio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelInizioPartita, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelScegliPersonaggio, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelInizioPartita, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BottoneSceltaPersonaggioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneSceltaPersonaggioActionPerformed
    ImageIcon icon = new ImageIcon(getClass().getResource(player));
        Image img = icon.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        labelPersonaggioScelto.setIcon(new ImageIcon(img));

        PanelScegliPersonaggio.setVisible(false);
        PanelInizioPartita.setVisible(true);
    }//GEN-LAST:event_BottoneSceltaPersonaggioActionPerformed

    private void PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PausaActionPerformed
        PanelPausa.setVisible(true);
        BottoneBevi.setVisible(false);
        BottoneMangia.setVisible(false);
        BottoneAbilitaSpeciale.setVisible(false);
        BottoneAvanza.setVisible(false);
        BottonePrendiOggetto.setVisible(false);
    }//GEN-LAST:event_PausaActionPerformed

    private void BottoneRiprendiPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneRiprendiPartitaActionPerformed
        PanelPausa.setVisible(false);
        BottoneBevi.setVisible(true);
        BottoneMangia.setVisible(true);
        BottoneAbilitaSpeciale.setVisible(true);
        BottoneAvanza.setVisible(true);
        BottonePrendiOggetto.setVisible(true);
    }//GEN-LAST:event_BottoneRiprendiPartitaActionPerformed

    private void BottoneMangiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneMangiaActionPerformed
        if(Integer.parseInt(txtMangia.getText()) > 0){
        txtMangia.setText("" + (Integer.parseInt(txtMangia.getText()) - 1));
        }
        VitaPersonaggio.setText("" + (Integer.parseInt(VitaPersonaggio.getText()) - 10));
        txtAffamato.setText("" + (Integer.parseInt(txtAffamato.getText()) + 20));
        
        if(Integer.parseInt(txtMangia.getText()) <= 0){
            BottoneMangia.setEnabled(false);
        }
        
        if (Integer.parseInt(VitaPersonaggio.getText()) < 70 && Integer.parseInt(VitaPersonaggio.getText()) >= 50) {
            VitaPersonaggio.setForeground(Color.yellow);
        }
        else if (Integer.parseInt(VitaPersonaggio.getText()) < 50 && Integer.parseInt(VitaPersonaggio.getText()) >= 30) {
            VitaPersonaggio.setForeground(Color.orange);
        }
        else if (Integer.parseInt(VitaPersonaggio.getText()) < 30) {
            VitaPersonaggio.setForeground(Color.red);
        }
        else {
            VitaPersonaggio.setForeground(Color.green);
        }
    }//GEN-LAST:event_BottoneMangiaActionPerformed

    private void BottoneBeviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneBeviActionPerformed
        if(Integer.parseInt(txtBevi.getText()) > 0){
            txtBevi.setText("" + (Integer.parseInt(txtBevi.getText()) - 1));
        }
        txtAssetato.setText("" + (Integer.parseInt(txtAssetato.getText()) + 20));
        GameOver.setVisible(true);
    }//GEN-LAST:event_BottoneBeviActionPerformed

    private void BottoneAvanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneAvanzaActionPerformed
        g1.prossimoGiorno();
        txtContaGiorno.setText("" + (Integer.parseInt(txtContaGiorno.getText()) + 1));
        txtAffamato.setText("" + (Integer.parseInt(txtAffamato.getText()) - 20));
        txtAssetato.setText("" + (Integer.parseInt(txtAssetato.getText()) - 20));
        
        if(txtContaGiorno.getText().equals("10")){
            //rendi visibile il panel di vittoria
        }
        
        if(Integer.parseInt(txtMangia.getText()) > 0){
            BottoneMangia.setEnabled(true);
        }
        
    }//GEN-LAST:event_BottoneAvanzaActionPerformed

    private void BottonePrendiOggettoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottonePrendiOggettoActionPerformed
        if(lblOggetto.isVisible() && inventario.interaLista() < 10){
            inventario.aggiungiOggetto(oggettoCorrente);
            txtInventarioCorrente.setText("" + (Integer.parseInt(txtInventarioCorrente.getText()) + 1));
            if(lblOggetto.getText().equals("Cibo")){
                txtMangia.setText("" + (Integer.parseInt(txtMangia.getText()) - 1));
            }
            lblOggetto.setVisible(false);
            System.out.println("Oggetto raccolto");
        }
        else{
            System.out.println("Non ci sono oggetti da raccogliere");
        }
    }//GEN-LAST:event_BottonePrendiOggettoActionPerformed

    private void BottoneControllaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneControllaInventarioActionPerformed
        /*
        for(String g : inventario){
            System.out.println(g);
        }
        */
    }//GEN-LAST:event_BottoneControllaInventarioActionPerformed

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
    private javax.swing.JButton BottoneAbilitaSpeciale;
    private javax.swing.JButton BottoneAvanza;
    private javax.swing.JButton BottoneBevi;
    private javax.swing.JButton BottoneCaricaPartita;
    private javax.swing.JButton BottoneControllaInventario;
    private javax.swing.JButton BottoneMangia;
    private javax.swing.JButton BottonePrendiOggetto;
    private javax.swing.JButton BottoneRiprendiPartita;
    private javax.swing.JButton BottoneSalvaPartita;
    private javax.swing.JButton BottoneSceltaPersonaggio;
    private javax.swing.JLabel GameOver;
    private javax.swing.JPanel PanelInizioPartita;
    private javax.swing.JPanel PanelPausa;
    private javax.swing.JPanel PanelPersonaggio1;
    private javax.swing.JPanel PanelPersonaggio2;
    private javax.swing.JPanel PanelPersonaggio3;
    private javax.swing.JPanel PanelScegliPersonaggio;
    private javax.swing.JButton Pausa;
    private javax.swing.JLabel VitaPersonaggio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPersonaggioScelto;
    private javax.swing.JLabel lblNemico;
    private javax.swing.JLabel lblOggetto;
    private javax.swing.JLabel txtAffamato;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JLabel txtAssetato;
    private javax.swing.JLabel txtBevi;
    private javax.swing.JLabel txtContaGiorno;
    private javax.swing.JLabel txtInventarioCorrente;
    private javax.swing.JLabel txtInventarioMassimo;
    private javax.swing.JLabel txtMangia;
    // End of variables declaration//GEN-END:variables
}
