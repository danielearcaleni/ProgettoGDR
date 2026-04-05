/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author arcaleni.daniele2
 */
public class Personaggio {
    private String nome;
    private int fame;
    private int sete;
    private int salute;
    private int saluteMassima;
    
    public Personaggio(String nome, int fame, int sete, int salute){
        this.nome = nome;
        this.fame = fame;
        this.sete = sete;
        this.salute = salute;
        this.saluteMassima = salute;
    }
    
    public void bevi(int disseta){
        this.sete += disseta;
        if(sete > 100){
            sete = 100;
        }
    }
    
    public void mangia(int sfama){
        this.fame += sfama;
        if(fame > 100){
            fame = 100;
        }
    }
    
    public void perdiVita(int vitaPersa){
        this.salute -= vitaPersa;
        if(salute < 0){
            salute = 0;
        }
    }
    
    public int getVita(){
        return salute;
    }

    public int getFame() {
        return fame;
    }

    public int getSete() {
        return sete;
    }

    public void aumentaVita(int vitaAumentata){
        this.salute += vitaAumentata;
        if(salute > saluteMassima){
            salute = saluteMassima;
        }
    }
    
    public void diminuisciVita(int vitaDiminuita){
        this.salute -= vitaDiminuita;
        if(salute < 0){
            salute = 0;
        }
    }
    
    public void abilitaSpeciale(JLabel lblCibo, JLabel lblAcqua, JLabel lblInventarioCorrente, JTextArea txtArea){
        
    }
}
