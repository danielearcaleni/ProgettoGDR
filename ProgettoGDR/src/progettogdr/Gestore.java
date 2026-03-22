/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author arcaleni.daniele2
 */
public class Gestore {
    private int punteggio;
    private JTextArea txtArea;
    
    public Gestore(int punteggio, JTextArea txtArea){
        this.punteggio = punteggio;
        this.txtArea = txtArea;
    }
    
    public int getPunteggio(){
        return punteggio;
    }
    
    public void setPunteggio(int punteggio){
        this.punteggio += punteggio;
    }
    
    public void prossimoGiorno(){
        Random rd  = new Random();
        FileManager fm = new FileManager();
        
        ArrayList<String> frasi = fm.letturaFile();
        int indice = rd.nextInt(frasi.size());
        String frase = frasi.get(indice);
        txtArea.setText(frase);
    }
}