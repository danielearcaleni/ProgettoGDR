/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
/**
 *
 * @author arcaleni.daniele2
 */
public class Gestore {
    private int punteggio;
    private JTextArea txtArea;
    private JLabel lblNemico;
    private JLabel lblOggetto;
    private FileManager fm;
    private ArrayList<String> tipoOggettoRandom = new ArrayList<>();
    private String oggettoCorrente;
    
    public Gestore(int punteggio, JTextArea txtArea, JLabel lblNemico, JLabel lblOggetto){
        this.punteggio = punteggio;
        this.txtArea = txtArea;
        this.lblNemico = lblNemico;
        this.lblOggetto = lblOggetto;
        
        fm = new FileManager();
        fm.letturaFile();
        
        tipoOggettoRandom.add("Cibo");
        tipoOggettoRandom.add("Acqua");
        tipoOggettoRandom.add("Medicine");
    }
    
    public int getPunteggio(){
        return punteggio;
    }
    
    public void setPunteggio(int punteggio){
        this.punteggio += punteggio;
    }
    
    public String getOggettoCorrente(){
        return this.oggettoCorrente;
    }
    
    public Color calcolaColoreVita(int vita){
        if(vita >= 70){
            return Color.green;
        }
        else if (vita >= 50){
            return Color.yellow;
        }
        else if (vita >= 30){
            return Color.ORANGE;
        }
        else{
            return Color.red;
        }
    }
    
    public void prossimoGiorno(){
        Random rd  = new Random();
        
        ArrayList<String> frasi = fm.getFrasi();
        int numero = rd.nextInt(frasi.size());
        String frase = frasi.get(numero);
        txtArea.append(frase + "\n");
        
        if(fm.ritornaTipoNemico().contains(frase)){
            lblNemico.setIcon(new ImageIcon(getClass().getResource("/Immagini/NemicoGDR.png")));
            lblNemico.setVisible(true);
            lblOggetto.setVisible(false);
        }
        else{
            lblOggetto.setVisible(true);
            lblNemico.setVisible(false);
            
            int randomOggetto = rd.nextInt(tipoOggettoRandom.size());
            oggettoCorrente = tipoOggettoRandom.get(randomOggetto);
            
            switch (oggettoCorrente){
                case "Cibo":
                    lblOggetto.setIcon(new ImageIcon(getClass().getResource("/Immagini/OggettoCibo.png")));
                    break;
                    
                case "Acqua":
                    lblOggetto.setIcon(new ImageIcon(getClass().getResource("/Immagini/acquaGDR.png")));
                    break;
                
                case "Medicine":
                    lblOggetto.setIcon(new ImageIcon(getClass().getResource("/Immagini/MedicineGDR.png")));
                    break;
            }
        }
    }
}