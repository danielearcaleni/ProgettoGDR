/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
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
    private String tipoOggetto;
    
    public Gestore(int punteggio, JTextArea txtArea, JLabel lblNemico, JLabel lblOggetto, String tipoOggetto){
        this.punteggio = punteggio;
        this.txtArea = txtArea;
        this.lblNemico = lblNemico;
        this.lblOggetto = lblOggetto;
        this.tipoOggetto = tipoOggetto;
        
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
                    tipoOggetto = "Cibo";
                    break;
                    
                case "Acqua":
                    lblOggetto.setIcon(new ImageIcon(getClass().getResource("/Immagini/acquaGDR.png")));
                    tipoOggetto = "Acqua";
                    break;
                
                case "Medicine":
                    lblOggetto.setIcon(new ImageIcon(getClass().getResource("/Immagini/MedicineGDR.png")));
                    tipoOggetto = "Medicine";
                    break;
            }
        }
    }
}