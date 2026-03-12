/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;

/**
 *
 * @author arcaleni.daniele2
 */
public class Personaggio {
    private String nome;
    private int attacco;
    private int fame;
    private int sete;
    private int salute;
    
    public Personaggio(String nome, int attacco, int fame, int sete, int salute){
        this.nome = nome;
        this.attacco = attacco;
        this.fame = fame;
        this.sete = sete;
        this.salute = salute;
    }
    
    public void aumentaAttacco(int attacco){
        this.attacco += attacco;
    }
    
    public void bevi(int disseta){
        this.sete += disseta;
    }
    
    public void mangia(int sfama){
        this.fame += sfama;
    }
    
    public void perdiVita(int vitaPersa){
        this.salute += vitaPersa;
    }
    
    public void aumentaVita(int vitaAumentata){
        this.salute += vitaAumentata;
    }
    
    public void abilitaSpeciale(){
        //completala cosa ci metto?
    }
}
