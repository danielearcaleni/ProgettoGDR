/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import java.util.Random;
/**
 *
 * @author arcaleni.daniele2
 */
public class Enemy {
    private String nome;
    private int salute;
    private boolean perdiOggetto;
    private String oggettoPerso;
    private int danno;
    
    public Enemy(String nome, int salute, boolean perdiOggetto, String oggettoPerso, int danno){
        this.nome = nome;
        this.salute = salute;
        this.perdiOggetto = perdiOggetto;
        this.oggettoPerso = oggettoPerso;
        this.danno = danno;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getSalute(){
        return salute;
    }
    
    public void perdiSalute(int salute){
        this.salute -= salute;
    }
    
    public void oggettoPerso(Oggetto o){
        Random rd = new Random();
        int casuale = rd.nextInt(1, 3);
        
        if (casuale == 1){
            perdiOggetto = true;
        }
        else{
            perdiOggetto = false;
        }
    }
}
