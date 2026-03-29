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
    
    public void prossimoGiorno(){
        Random rd  = new Random();
        
        ArrayList<String> frasi = fm.getFrasi();
        int numero = rd.nextInt(frasi.size());
        String frase = frasi.get(numero);
        txtArea.setText(frase);
        
        if(fm.ritornaTipoNemico().contains(frase)){
            lblNemico.setVisible(true);
            lblOggetto.setVisible(false);
        }
        else{
            lblOggetto.setVisible(true);
            lblNemico.setVisible(false);
            
            int randomOggetto = rd.nextInt(tipoOggettoRandom.size());
            String tipo = tipoOggettoRandom.get(randomOggetto);
            
            switch (tipo){
                case "Cibo":
                    lblOggetto.setIcon(new ImageIcon("C:\\Users\\compu\\OneDrive\\Documenti\\GitHub\\ProgettoGDR\\ProgettoGDR\\src\\progettogdr\\OggettoCibo.png"));
                    break;
                    
                case "Acqua":
                    lblOggetto.setIcon(new ImageIcon("C:\\Users\\compu\\OneDrive\\Documenti\\GitHub\\ProgettoGDR\\ProgettoGDR\\src\\progettogdr\\acquaGDR.png"));
                    break;
                
                case "Medicine":
                    lblOggetto.setIcon(new ImageIcon("C:\\Users\\compu\\OneDrive\\Documenti\\GitHub\\ProgettoGDR\\ProgettoGDR\\src\\progettogdr\\MedicineGDR.png"));
                    break;
            }
        }
    }
}