/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package progettogdr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author arcaleni.daniele2
 */
public class Grafica extends javax.swing.JFrame {
    private JPanel selezionato = null;
    private Personaggio player;
    private String personaggioImage = "";
    Enemy nemico = new Enemy("PrimoNemico", 100, "NomeOgettoPerso", 20);
    private Gestore g1;
    private Inventario inventario;
    private String oggettoCorrente;
    private int contaGiorno;
    private String cibo;
    private String acqua;
    private String inventarioCorrente;
    private String inventarioMassimo;
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
        lblVittoria.setVisible(false);
        ScrittaDiVittoria.setVisible(false);
        lblNemico.setText(" ");
        lblOggetto.setText(" ");

        ImageIcon icon = new ImageIcon(getClass().getResource("/Immagini/SimboloMenuPausa.png"));
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Pausa.setIcon(new ImageIcon(img));
                
        PanelInizioPartita.setVisible(false);

        PanelPersonaggio1.setLayout(new BorderLayout());
        JLabel label1 = creaLabel("/Immagini/PersonaggioGDR.png", 180, 240);
        PanelPersonaggio1.add(label1, BorderLayout.CENTER);
        
        PanelPersonaggio2.setLayout(new BorderLayout());
        JLabel label2 = creaLabel("/Immagini/secondoPersonaggioGDR.png", 140, 220);
        PanelPersonaggio2.add(label2, BorderLayout.CENTER);
        
        PanelPersonaggio3.setLayout(new BorderLayout());
        JLabel label3 = creaLabel("/Immagini/TerzoPersonaggioGDR.png", 180, 240);
        PanelPersonaggio3.add(label3, BorderLayout.CENTER);
        
        MouseAdapter selezioneListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selezionato = (JPanel) e.getSource();

                if (selezionato == PanelPersonaggio1){
                    player = new PersonaggioVita("Nome", 100, 100, 120);
                    personaggioImage = "/Immagini/PersonaggioGDR.png";
                    VitaPersonaggio.setText("120");
                    BottoneMangia.setEnabled(false);
                    BottoneBevi.setEnabled(false);
                }
                else if (selezionato == PanelPersonaggio2){
                    player = new PersonaggioOscuro("Nome", 100, 100, 100);
                    personaggioImage = "/Immagini/secondoPersonaggioGDR.png";
                    txtMangia.setText("2");
                    txtBevi.setText("2");
                    txtInventarioCorrente.setText("4");
                    inventario.aggiungiOggetto("Cibo");
                    inventario.aggiungiOggetto("Cibo");
                    inventario.aggiungiOggetto("Acqua");
                    inventario.aggiungiOggetto("Acqua");
                    BottoneMangia.setEnabled(true);
                    BottoneBevi.setEnabled(true);
                }
                else if (selezionato == PanelPersonaggio3){
                    player = new PersonaggioZaino("Nome", 100, 100, 100);
                    personaggioImage = "/Immagini/TerzoPersonaggioGDR.png";
                    txtMangia.setText("0");
                    txtBevi.setText("0");
                    txtInventarioCorrente.setText("0");
                    txtInventarioMassimo.setText("12");
                    BottoneMangia.setEnabled(false);
                    BottoneBevi.setEnabled(false);
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
    
    public void mostraPanelSconfitta() {
        GameOver.setVisible(true);
        BottoneSceltaPersonaggio.setVisible(false);
        BottoneBevi.setVisible(false);
        BottoneMangia.setVisible(false);
        BottoneAbilitaSpeciale.setVisible(false);
        BottoneAvanza.setVisible(false);
        BottonePrendiOggetto.setVisible(false);
        BottoneControllaInventario.setVisible(false);
        BottoneUsaMedicine.setVisible(false);
    }

    public void mostraPanelVittoria() {
        lblVittoria.setVisible(true);
        BottoneSceltaPersonaggio.setVisible(false);
        BottoneBevi.setVisible(false);
        BottoneMangia.setVisible(false);
        BottoneAbilitaSpeciale.setVisible(false);
        BottoneAvanza.setVisible(false);
        BottonePrendiOggetto.setVisible(false);
        BottoneControllaInventario.setVisible(false);
        BottoneUsaMedicine.setVisible(false);
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
        ScrittaDiVittoria = new javax.swing.JLabel();
        lblVittoria = new javax.swing.JLabel();
        GameOver = new javax.swing.JLabel();
        PanelPausa = new javax.swing.JPanel();
        BottoneRiprendiPartita = new javax.swing.JButton();
        BottoneSalvaPartita = new javax.swing.JButton();
        BottoneCaricaPartita = new javax.swing.JButton();
        lblPausa = new javax.swing.JLabel();
        BottoneSalvaCSV = new javax.swing.JButton();
        BottoneCaricaCSV = new javax.swing.JButton();
        BottoneControllaInventario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
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
        lblNemico = new javax.swing.JLabel();
        lblOggetto = new javax.swing.JLabel();
        BottonePrendiOggetto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtContaGiorno = new javax.swing.JLabel();
        BottoneUsaMedicine = new javax.swing.JButton();
        PanelScegliPersonaggio = new javax.swing.JPanel();
        PanelPersonaggio2 = new javax.swing.JPanel();
        PanelPersonaggio3 = new javax.swing.JPanel();
        BottoneSceltaPersonaggio = new javax.swing.JButton();
        PanelPersonaggio1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelInizioPartita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ScrittaDiVittoria.setFont(new java.awt.Font("Rockwell Nova Extra Bold", 3, 36)); // NOI18N
        ScrittaDiVittoria.setForeground(new java.awt.Color(51, 255, 51));
        ScrittaDiVittoria.setText("<----Hai Vinto---->");
        PanelInizioPartita.add(ScrittaDiVittoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 440, 60));

        lblVittoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/HaiVinto.png"))); // NOI18N
        PanelInizioPartita.add(lblVittoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 790));

        GameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/ImmagineGameOver.jpg"))); // NOI18N
        PanelInizioPartita.add(GameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 780));

        PanelPausa.setBackground(new java.awt.Color(0, 0, 0));
        PanelPausa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BottoneRiprendiPartita.setText("Riprendi");
        BottoneRiprendiPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneRiprendiPartitaActionPerformed(evt);
            }
        });
        PanelPausa.add(BottoneRiprendiPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, -1, 30));

        BottoneSalvaPartita.setText("SalvaPartita");
        BottoneSalvaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneSalvaPartitaActionPerformed(evt);
            }
        });
        PanelPausa.add(BottoneSalvaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 130, 30));

        BottoneCaricaPartita.setText("CaricaPartita");
        BottoneCaricaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneCaricaPartitaActionPerformed(evt);
            }
        });
        PanelPausa.add(BottoneCaricaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 130, 30));

        lblPausa.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 40)); // NOI18N
        lblPausa.setForeground(new java.awt.Color(255, 0, 0));
        lblPausa.setText("Pausa");
        PanelPausa.add(lblPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 160, 60));

        BottoneSalvaCSV.setText("SalvaCSV");
        BottoneSalvaCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneSalvaCSVActionPerformed(evt);
            }
        });
        PanelPausa.add(BottoneSalvaCSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 130, 30));

        BottoneCaricaCSV.setText("CaricaCSV");
        BottoneCaricaCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneCaricaCSVActionPerformed(evt);
            }
        });
        PanelPausa.add(BottoneCaricaCSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 130, 30));

        PanelInizioPartita.add(PanelPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 790));

        BottoneControllaInventario.setText("Controlla Inventario");
        BottoneControllaInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneControllaInventarioActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneControllaInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 160, -1));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        PanelInizioPartita.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 350, 360));
        PanelInizioPartita.add(labelPersonaggioScelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, 270));

        BottoneBevi.setText("Bevi");
        BottoneBevi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneBeviActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneBevi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, 30));

        BottoneMangia.setText("Mangia");
        BottoneMangia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneMangiaActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneMangia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, 30));

        Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausaActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(Pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 24, 90, 60));

        BottoneAbilitaSpeciale.setText("Abilità Speciale");
        BottoneAbilitaSpeciale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneAbilitaSpecialeActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneAbilitaSpeciale, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, 40));

        txtMangia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMangia.setText("0");
        PanelInizioPartita.add(txtMangia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 40, 30));

        txtBevi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBevi.setText("0");
        PanelInizioPartita.add(txtBevi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 40, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabel5.setText("Inventario Massimo: ");
        PanelInizioPartita.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabel6.setText("Capienza inventario: ");
        PanelInizioPartita.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, -1, -1));

        txtInventarioCorrente.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        txtInventarioCorrente.setText("0");
        PanelInizioPartita.add(txtInventarioCorrente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 80, -1));

        txtInventarioMassimo.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        txtInventarioMassimo.setText("10");
        PanelInizioPartita.add(txtInventarioMassimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 90, -1));

        jLabel7.setFont(new java.awt.Font("Sans Serif Collection", 3, 18)); // NOI18N
        jLabel7.setText("Vita:");
        PanelInizioPartita.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 50, -1));

        jLabel8.setFont(new java.awt.Font("Perpetua", 3, 18)); // NOI18N
        jLabel8.setText("Fame:");
        PanelInizioPartita.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 60, -1));

        VitaPersonaggio.setFont(new java.awt.Font("Sans Serif Collection", 3, 18)); // NOI18N
        VitaPersonaggio.setForeground(new java.awt.Color(51, 255, 51));
        VitaPersonaggio.setText("100");
        PanelInizioPartita.add(VitaPersonaggio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 80, -1));

        jLabel12.setFont(new java.awt.Font("Perpetua", 3, 18)); // NOI18N
        jLabel12.setText("Sete:");
        PanelInizioPartita.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 60, -1));

        txtAffamato.setFont(new java.awt.Font("Perpetua", 3, 18)); // NOI18N
        txtAffamato.setText("100");
        PanelInizioPartita.add(txtAffamato, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 60, -1));

        txtAssetato.setFont(new java.awt.Font("Perpetua", 3, 18)); // NOI18N
        txtAssetato.setText("100");
        PanelInizioPartita.add(txtAssetato, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 60, -1));

        BottoneAvanza.setText("Avanti");
        BottoneAvanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneAvanzaActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneAvanza, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, 50));
        PanelInizioPartita.add(lblNemico, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 220, 190));
        PanelInizioPartita.add(lblOggetto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 210, 200));

        BottonePrendiOggetto.setText("Raccogli");
        BottonePrendiOggetto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottonePrendiOggettoActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottonePrendiOggetto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, 30));

        jLabel15.setFont(new java.awt.Font("Poor Richard", 3, 28)); // NOI18N
        jLabel15.setText("Giorno Numero:");
        PanelInizioPartita.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 200, -1));

        txtContaGiorno.setFont(new java.awt.Font("Poor Richard", 3, 28)); // NOI18N
        txtContaGiorno.setText("0");
        PanelInizioPartita.add(txtContaGiorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 70, 30));

        BottoneUsaMedicine.setText("Usa Medicine");
        BottoneUsaMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneUsaMedicineActionPerformed(evt);
            }
        });
        PanelInizioPartita.add(BottoneUsaMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 120, -1));

        PanelScegliPersonaggio.setBackground(new java.awt.Color(255, 255, 204));
        PanelScegliPersonaggio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelPersonaggio2Layout = new javax.swing.GroupLayout(PanelPersonaggio2);
        PanelPersonaggio2.setLayout(PanelPersonaggio2Layout);
        PanelPersonaggio2Layout.setHorizontalGroup(
            PanelPersonaggio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        PanelPersonaggio2Layout.setVerticalGroup(
            PanelPersonaggio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        PanelScegliPersonaggio.add(PanelPersonaggio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 210, 240));

        javax.swing.GroupLayout PanelPersonaggio3Layout = new javax.swing.GroupLayout(PanelPersonaggio3);
        PanelPersonaggio3.setLayout(PanelPersonaggio3Layout);
        PanelPersonaggio3Layout.setHorizontalGroup(
            PanelPersonaggio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        PanelPersonaggio3Layout.setVerticalGroup(
            PanelPersonaggio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        PanelScegliPersonaggio.add(PanelPersonaggio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 210, 240));

        BottoneSceltaPersonaggio.setText("Scegli");
        BottoneSceltaPersonaggio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneSceltaPersonaggioActionPerformed(evt);
            }
        });
        PanelScegliPersonaggio.add(BottoneSceltaPersonaggio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 690, 119, 30));

        javax.swing.GroupLayout PanelPersonaggio1Layout = new javax.swing.GroupLayout(PanelPersonaggio1);
        PanelPersonaggio1.setLayout(PanelPersonaggio1Layout);
        PanelPersonaggio1Layout.setHorizontalGroup(
            PanelPersonaggio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        PanelPersonaggio1Layout.setVerticalGroup(
            PanelPersonaggio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        PanelScegliPersonaggio.add(PanelPersonaggio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 210, 240));

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 51));
        jLabel9.setText("+20 Vita Max");
        PanelScegliPersonaggio.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        jLabel10.setBackground(new java.awt.Color(51, 255, 51));
        jLabel10.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 51));
        jLabel10.setText("+2 Cibo, +2 Acqua");
        PanelScegliPersonaggio.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, -1, -1));

        jLabel11.setBackground(new java.awt.Color(51, 255, 51));
        jLabel11.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 51));
        jLabel11.setText("+2 Spazio Inventario");
        PanelScegliPersonaggio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 550, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelScegliPersonaggio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2385, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelInizioPartita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelScegliPersonaggio, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelInizioPartita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BottoneSceltaPersonaggioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneSceltaPersonaggioActionPerformed
    ImageIcon icon = new ImageIcon(getClass().getResource(personaggioImage));
        Image img = icon.getImage().getScaledInstance(140, 220, Image.SCALE_SMOOTH);
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
        BottoneControllaInventario.setVisible(false);
        BottoneUsaMedicine.setVisible(false);
        txtArea.setVisible(false);
    }//GEN-LAST:event_PausaActionPerformed

    private void BottoneRiprendiPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneRiprendiPartitaActionPerformed
        PanelPausa.setVisible(false);
        BottoneBevi.setVisible(true);
        BottoneMangia.setVisible(true);
        BottoneAbilitaSpeciale.setVisible(true);
        BottoneAvanza.setVisible(true);
        BottonePrendiOggetto.setVisible(true);
        BottoneControllaInventario.setVisible(true);
        BottoneUsaMedicine.setVisible(true);
        txtArea.setVisible(true);
    }//GEN-LAST:event_BottoneRiprendiPartitaActionPerformed

    private void BottoneMangiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneMangiaActionPerformed
        if (Integer.parseInt(txtMangia.getText()) > 0) {
            txtMangia.setText("" + (Integer.parseInt(txtMangia.getText()) - 1));
            BottoneMangia.setEnabled(true);
            inventario.rimuoviOggetto("Cibo");
        }
        else{
            BottoneMangia.setEnabled(false);
        }
        player.aumentaVita(10);
        player.mangia(30);
        player.bevi(10);
        
        txtAffamato.setText("" + player.getFame());
        VitaPersonaggio.setText("" + player.getVita());
        txtAssetato.setText("" + player.getSete());

        if (Integer.parseInt(txtMangia.getText()) <= 0) {
            BottoneMangia.setEnabled(false);
        }

        txtInventarioCorrente.setText("" + (Integer.parseInt(txtInventarioCorrente.getText()) - 1));
        if (Integer.parseInt(txtInventarioCorrente.getText()) < 0) {
            txtInventarioCorrente.setText("0");
        }
    }//GEN-LAST:event_BottoneMangiaActionPerformed

    private void BottoneBeviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneBeviActionPerformed
        if(Integer.parseInt(txtBevi.getText()) > 0){
            txtBevi.setText("" + (Integer.parseInt(txtBevi.getText()) - 1));
            player.bevi(30);
            txtAssetato.setText("" + player.getSete());
            inventario.rimuoviOggetto("Acqua");
        }
        if (Integer.parseInt(txtBevi.getText()) <= 0) {
            BottoneBevi.setEnabled(false);
        }

        txtInventarioCorrente.setText("" + (Integer.parseInt(txtInventarioCorrente.getText()) - 1));
        if (Integer.parseInt(txtInventarioCorrente.getText()) < 0) {
            txtInventarioCorrente.setText("0");
        }
    }//GEN-LAST:event_BottoneBeviActionPerformed

    private void BottoneAvanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneAvanzaActionPerformed
        g1.prossimoGiorno();
        txtContaGiorno.setText("" + (Integer.parseInt(txtContaGiorno.getText()) + 1));
        player.mangia(-20);
        player.bevi(-20);
        contaGiorno++;
        
        txtAffamato.setText("" + player.getFame());
        txtAssetato.setText("" + player.getSete());

        if (txtContaGiorno.getText().equals("10")){
            BottoneBevi.setEnabled(false);
            BottoneMangia.setEnabled(false);
            BottoneAbilitaSpeciale.setEnabled(false);
            BottoneAvanza.setEnabled(false);
            BottonePrendiOggetto.setEnabled(false);
            BottoneControllaInventario.setEnabled(false);
            BottoneUsaMedicine.setEnabled(false);
            mostraPanelVittoria();
            ScrittaDiVittoria.setVisible(true);
        }
        
        if(Integer.parseInt(txtMangia.getText()) > 0){
            BottoneMangia.setEnabled(true);
        }
        if (Integer.parseInt(txtBevi.getText()) > 0){
            BottoneBevi.setEnabled(true);
        }
        
        if(lblNemico.isVisible()){
            player.perdiVita(20);
            VitaPersonaggio.setText("" + player.getVita());
        }
        if (player.getFame() < 0 || player.getSete() < 0 || player.getVita() <= 0) {
            GameOver.setVisible(true);
            mostraPanelSconfitta();
            txtArea.setVisible(false);
        }
        int vitaAttuale = player.getVita();
        Color calcolaColore = g1.calcolaColoreVita(vitaAttuale);
        VitaPersonaggio.setForeground(calcolaColore);
    }//GEN-LAST:event_BottoneAvanzaActionPerformed

    private void BottonePrendiOggettoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottonePrendiOggettoActionPerformed
        if (lblOggetto.isVisible()){
            int inventarioAttuale = Integer.parseInt(txtInventarioCorrente.getText());
            if (inventarioAttuale < Integer.parseInt(txtInventarioMassimo.getText())){
                BottonePrendiOggetto.setEnabled(true);
                String oggettoTrovato = g1.getOggettoCorrente();
                if (oggettoTrovato != null){
                    inventario.aggiungiOggetto(oggettoTrovato);
                    txtInventarioCorrente.setText("" + (Integer.parseInt(txtInventarioCorrente.getText()) + 1));

                    if (oggettoTrovato.equals("Cibo")){
                        txtMangia.setText("" + (Integer.parseInt(txtMangia.getText()) + 1));
                        BottoneMangia.setEnabled(true);
                    }
                    else if (oggettoTrovato.equals("Acqua")){
                        txtBevi.setText("" + (Integer.parseInt(txtBevi.getText()) + 1));
                        BottoneBevi.setEnabled(true);
                    }
                    lblOggetto.setVisible(false);
                    txtArea.append("Hai raccolto: " + oggettoTrovato + "\n");
                }
            }
            else{
                BottonePrendiOggetto.setEnabled(false);
            }
        }
        else{
            txtArea.append("Non ci sono oggetti da raccogliere\n");
        }
    }//GEN-LAST:event_BottonePrendiOggettoActionPerformed

    private void BottoneControllaInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneControllaInventarioActionPerformed
        String vedi = "";
        for(String g : inventario.getInventario()){
            if(g == null){
                g = "Medicine";
            }
            vedi += "\n" + g + "\n";
        }
        if(vedi == null){
            vedi = "Inventario vuoto \n";
        }
        txtArea.append("////////////////\n" + vedi + "\n////////////////\n");
    }//GEN-LAST:event_BottoneControllaInventarioActionPerformed

    private void BottoneAbilitaSpecialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneAbilitaSpecialeActionPerformed
        player.abilitaSpeciale(txtMangia, txtBevi, txtInventarioCorrente, txtArea, inventario);
        
        VitaPersonaggio.setText("" + player.getVita());
        txtAssetato.setText("" + player.getSete());
        txtAffamato.setText("" + player.getFame());
                
        BottoneAbilitaSpeciale.setEnabled(false);
    }//GEN-LAST:event_BottoneAbilitaSpecialeActionPerformed

    private void BottoneUsaMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneUsaMedicineActionPerformed
        
        if(inventario.getInventario().contains("Medicine")){
        player.aumentaVita(30);
        VitaPersonaggio.setText("" + player.getVita());
        inventario.rimuoviOggetto("Medicine");
        txtArea.append("Hai usato Medicine\n");
        }
        else{
            txtArea.append("Non hai medicine da prendere\n");
        }
        
        
    }//GEN-LAST:event_BottoneUsaMedicineActionPerformed

    private void BottoneSalvaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneSalvaPartitaActionPerformed
        String filePath = "salva.Dan";
        
        this.cibo = txtMangia.getText();
        this.acqua = txtBevi.getText();
        this.inventarioCorrente = txtInventarioCorrente.getText();
        this.inventarioMassimo = txtInventarioMassimo.getText();
        
        DatiSalvataggio dati = new DatiSalvataggio(player, inventario, contaGiorno, personaggioImage, this.cibo,  this.acqua, this.inventarioCorrente, this.inventarioMassimo);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(dati);
            System.out.println("Partita salvata con successo");
        }
        catch(IOException e){
            System.out.println("Errore durante il salvataggio del file");
        }
    }//GEN-LAST:event_BottoneSalvaPartitaActionPerformed

    private void BottoneCaricaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneCaricaPartitaActionPerformed
        String filePath = "salva.Dan";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            DatiSalvataggio caricaDati = (DatiSalvataggio) ois.readObject();
            
            this.player = caricaDati.playerSalvato;
            this.inventario = caricaDati.inventarioSalvato;
            this.contaGiorno = caricaDati.giornoSalvato;
            this.personaggioImage = caricaDati.immaginePersonaggio;
            this.cibo = caricaDati.ciboSalvato;
            this.acqua = caricaDati.acquaSalvato;
            this.inventarioCorrente = caricaDati.inventarioCorrenteSalvato;
            this.inventarioMassimo = caricaDati.InventarioMassimoSalvato;

            if (this.personaggioImage != null && !this.personaggioImage.isEmpty()) {
                ImageIcon icon = new ImageIcon(getClass().getResource(this.personaggioImage));
                Image img = icon.getImage().getScaledInstance(140, 220, Image.SCALE_SMOOTH);
                labelPersonaggioScelto.setIcon(new ImageIcon(img));
            }

            VitaPersonaggio.setText("" + player.getVita());
            txtAffamato.setText("" + player.getFame());
            txtAssetato.setText("" + player.getSete());
            txtMangia.setText("" + this.cibo);
            txtBevi.setText("" + this.acqua);
            txtInventarioCorrente.setText("" + this.inventarioCorrente);
            txtInventarioMassimo.setText("" + this.inventarioMassimo);
            txtContaGiorno.setText("" + this.contaGiorno);
            System.out.println("Partita caricata con successo");
        }
        catch(Exception e){
            System.out.println("Errore durante il caricamento del file");
        }
    }//GEN-LAST:event_BottoneCaricaPartitaActionPerformed

    private void BottoneSalvaCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneSalvaCSVActionPerformed
        String filePath = "dati.csv";
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            String vita = VitaPersonaggio.getText();
            String fame = txtAffamato.getText();
            String sete = txtAssetato.getText();
            String cibo = txtMangia.getText();
            String acqua = txtBevi.getText();
            String inventarioCorrente = txtInventarioCorrente.getText();
            String inventarioMassimo = txtInventarioMassimo.getText();
            String giorno = txtContaGiorno.getText();
            
            String immagine = "null";
            if (this.personaggioImage != null) {
                immagine = this.personaggioImage;
            }
            
            String inventarioUnito = "";
            boolean primoOggetto = true;
            
            for (String oggetto : inventario.getInventario()) {
                if(primoOggetto == false){
                    inventarioUnito = inventarioUnito + ",";
                }
                inventarioUnito = inventarioUnito + oggetto;
                
                primoOggetto = false;
            }
            if(inventarioUnito.equals("")){
                inventarioUnito = "vuoto";
            }
            
            String rigaDaSalvare = vita + ";" + fame + ";" + sete + ";" + cibo + ";" + acqua + ";" + inventarioCorrente + ";" + inventarioMassimo + ";" + giorno + ";" + immagine + ";" + inventarioUnito;
            
            writer.write(rigaDaSalvare);
            System.out.println("Partita CSV salvata con successo");
        }
        catch(IOException e){
            System.out.println("Errore durante il salvataggio del file CSV");
        }
    }//GEN-LAST:event_BottoneSalvaCSVActionPerformed

    private void BottoneCaricaCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneCaricaCSVActionPerformed
        String filePath = "dati.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String rigaLetta = reader.readLine();
            if(rigaLetta != null){
                String[] dati = rigaLetta.split(";");
                VitaPersonaggio.setText(dati[0]);
                txtAffamato.setText(dati[1]);
                txtAssetato.setText(dati[2]);
                txtMangia.setText(dati[3]);
                txtBevi.setText(dati[4]);
                txtInventarioCorrente.setText(dati[5]);
                txtInventarioMassimo.setText(dati[6]);
                txtContaGiorno.setText(dati[7]);
                
                this.cibo = dati[3];
                this.acqua = dati[4];
                this.inventarioCorrente = dati[5];
                this.inventarioMassimo = dati[6];
                this.contaGiorno = Integer.parseInt(dati[7]);
                
                player.setVita(Integer.parseInt(dati[0]));
                player.setFame(Integer.parseInt(dati[1]));
                player.setSete(Integer.parseInt(dati[2]));
                
                this.personaggioImage = dati[8];
                if (!this.personaggioImage.equals("null") && !this.personaggioImage.isEmpty()) {
                    ImageIcon icon = new ImageIcon(getClass().getResource(this.personaggioImage));
                    Image img = icon.getImage().getScaledInstance(140, 220, Image.SCALE_SMOOTH);
                    labelPersonaggioScelto.setIcon(new ImageIcon(img));
                }
                
                inventario.getInventario().clear();
                String oggettiInventario = dati[9];
                
                if(!oggettiInventario.equals("vuoto")){
                    String[] arrayOggetti = oggettiInventario.split(",");
                    for(String oggetto : arrayOggetti){
                        inventario.aggiungiOggetto(oggetto);
                    }
                }
                System.out.println("Partita CSV caricata con successo");
            }
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento del file CSV");
        }
    }//GEN-LAST:event_BottoneCaricaCSVActionPerformed

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
    private javax.swing.JButton BottoneCaricaCSV;
    private javax.swing.JButton BottoneCaricaPartita;
    private javax.swing.JButton BottoneControllaInventario;
    private javax.swing.JButton BottoneMangia;
    private javax.swing.JButton BottonePrendiOggetto;
    private javax.swing.JButton BottoneRiprendiPartita;
    private javax.swing.JButton BottoneSalvaCSV;
    private javax.swing.JButton BottoneSalvaPartita;
    private javax.swing.JButton BottoneSceltaPersonaggio;
    private javax.swing.JButton BottoneUsaMedicine;
    private javax.swing.JLabel GameOver;
    private javax.swing.JPanel PanelInizioPartita;
    private javax.swing.JPanel PanelPausa;
    private javax.swing.JPanel PanelPersonaggio1;
    private javax.swing.JPanel PanelPersonaggio2;
    private javax.swing.JPanel PanelPersonaggio3;
    private javax.swing.JPanel PanelScegliPersonaggio;
    private javax.swing.JButton Pausa;
    private javax.swing.JLabel ScrittaDiVittoria;
    private javax.swing.JLabel VitaPersonaggio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel lblPausa;
    private javax.swing.JLabel lblVittoria;
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
